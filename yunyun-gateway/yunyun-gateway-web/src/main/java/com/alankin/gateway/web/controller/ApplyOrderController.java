package com.alankin.gateway.web.controller;

import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.ApplyOrderReqVo;
import com.alankin.gateway.web.vo.request.CusUserListReqVo;
import com.alankin.gateway.web.vo.request.UserAuthReqVo;
import com.alankin.gateway.web.vo.request.VerifyCustomerReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 申请单接口
 * Created by alankin.
 */
@Controller
@Api(value = "申请单接口", description = "申请单接口")
@RequestMapping(value = "api/ApplyOrder", method = RequestMethod.POST)
public class ApplyOrderController extends BaseWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyOrderController.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ApplyOrderService applyOrderService;
    @Autowired
    private ApplyStateLogService applyStateLogService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private ChannelService channelService;

    @ApiOperation(value = "所有申请单列表")
    @RequestMapping(value = "/orderList")
    @ResponseBody
    @Transactional
    public ListResult orderList(HttpServletRequest request, @RequestBody ListReqVO<ApplyOrderReqVo> listReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            pageInfo = applyOrderService.selectForStartPageByMethod("selectBySysUserId", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 4) {//出借人看申请单
            listReqVO.getCondition().setUid(sysUser.getUid());
            pageInfo = applyOrderService.selectForStartPageByMethod("selectBySysUserId", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    @ApiOperation(value = "出借人修改申请单状态")
    @RequestMapping(value = "/updateOrderState")
    @ResponseBody
    @Transactional
    public Result updateOrderState(HttpServletRequest request, @RequestBody Map<String, String> map) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);

        String applyState = map.get("applyState");
        String orderUid = map.get("orderUid");
        if (StringUtils.isEmpty(applyState) || StringUtils.isEmpty(orderUid)) {
            return new Result(ResultConstant.FAILED);
        }
        ApplyOrder applyOrder = applyOrderService.selectByPrimaryKey(Long.valueOf(orderUid));
        if (applyOrder == null) {//申请单不存在
            return new Result(ResultConstant.FAILED);
        }
        ApplyStateLogExample example = new ApplyStateLogExample();
        example.createCriteria().andOrderIdEqualTo(Long.valueOf(orderUid)).andNowStateEqualTo(Integer.valueOf(applyState));
        ApplyStateLog applyStateLog = applyStateLogService.selectFirstByExample(example);
        if (applyStateLog == null) {//不存在该状态的修改记录，则创建
            ApplyStateLog record = new ApplyStateLog();
            record.setLastState(applyOrder.getState());
            record.setNowState(Integer.valueOf(applyState));
            record.setOrderId(applyOrder.getUid());
            record.setSysUserId(sysUser.getUid());
            applyStateLogService.insertSelective(record);
        } else {//存在,则修改时间
            applyStateLog.setCreateTime((int) (SystemClock.now() / 1000));
            applyStateLogService.updateByPrimaryKey(applyStateLog);
        }
        applyOrder.setState(Integer.valueOf(applyState));
        if (applyOrderService.updateByPrimaryKeySelective(applyOrder) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    @ApiOperation(value = "申请用户详情")
    @RequestMapping(value = "/userDetail")
    @ResponseBody
    @Transactional
    public Result userDetail(HttpServletRequest request, @RequestBody IdReqVO idReqVO) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        UserBase userBase = null;
        userBase = userBaseService.selectByPrimaryKey(idReqVO.getId());
        if (userBase != null) {
            return new Result(ResultConstant.SUCCESS, getUserResult(userBase));
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @Autowired
    private UserLocationService userLocationService;

    private UserAuthReqVo getUserResult(UserBase userBase) {
        UserAuthReqVo userAuthReqVo = new UserAuthReqVo();
        BeanUtils.copyProperties(userBase, userAuthReqVo);
        UserLocationExample example = new UserLocationExample();
        example.createCriteria().andUidEqualTo(userBase.getCompanyLocationUid());
        UserLocation userLocation = userLocationService.selectFirstByExample(example);
        userAuthReqVo.setCompanyProvance(userLocation.getCurrProvince());
        userAuthReqVo.setCompanyCity(userLocation.getCurrCity());
        userAuthReqVo.setCompanyArea(userLocation.getCurrDistrict());
        userAuthReqVo.setCompanyLocationDetail(userLocation.getLocation());
        return userAuthReqVo;
    }

    @ApiOperation(value = "查询渠道")
    @RequestMapping(value = "/orderChanelAll")
    @ResponseBody
    @Transactional
    public Result orderChanelAll(HttpServletRequest request) {
        //从session获取用户信息
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        List<Map> data = null;
        //判断用户是否是超级管理员
//        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
        data = channelService.selectAllByMethod("selectAll");
//        } else if (sysRole.getType() == 2) {//审核员
//            data = channelService.selectAllByMethod("selectBySysUserId", sysUser.getUid());
//        }
        if (data == null) {
            return new Result(ResultConstant.FAILED, null);
        }
        return new Result(ResultConstant.SUCCESS, data);
    }

    @ApiOperation(value = "所有客户列表")
    @RequestMapping(value = "/cusUserList")
    @ResponseBody
    @Transactional
    public ListResult cusUserList(HttpServletRequest request, @RequestBody ListReqVO<CusUserListReqVo> listReqVO) {
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员查看客户列表
            pageInfo = applyOrderService.selectForStartPageByMethod("cusUserList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 2) {//审核员查看客户列表
            listReqVO.getCondition().setVerifyUid(sysUser.getUid());
            pageInfo = applyOrderService.selectForStartPageByMethod("cusUserList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "申请单详情")
    @RequestMapping(value = "/orderDetail")
    @ResponseBody
    @Transactional
    public Result orderDetail(@RequestBody IdReqVO idReqVO) {
        List<Map> maps = applyOrderService.selectAllByMethod("orderDetail", idReqVO);
        if (maps != null && maps.size() > 0) {
            return new Result(ResultConstant.SUCCESS, maps.get(0));
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "审核申请人")
    @RequestMapping(value = "/verifyCustomer")
    @ResponseBody
    @Transactional
    public Result verifyCustomer(@RequestBody VerifyCustomerReqVo vo) {
        UserBase userBase = userBaseService.selectByPrimaryKey(vo.getUserUid());
        if (userBase == null) {
            return new Result(ResultConstant.FAILED);
        }
        Integer verifyStateKey = vo.getVerifyStateKey();
        if (verifyStateKey == 2) {
            userBase.setVerifyStateTime((int) (SystemClock.now() / 1000));
        }
        userBase.setVerifyStateKey(verifyStateKey);
        userBase.setBrowerUid(vo.getBrowerUid());
        if (userBaseService.updateByPrimaryKeySelective(userBase) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED);
    }

    //用户创建申请单
//    @ApiOperation(value = "用户创建申请单")
//    @RequestMapping(value = "/create")
//    @ResponseBody
//    public Result create(HttpServletRequest request, @Valid @RequestBody ApplyOrderReqVo orderReqVo) {
//        //查看用户是否有异常状态的订单
//        ApplyOrderExample orderExample = new ApplyOrderExample();
//        orderExample.createCriteria().andStateNotEqualTo(4);
//        ApplyOrder exceptionOrder = applyOrderService.selectFirstByExample(orderExample);
//        if (exceptionOrder != null) {
//            return new Result(ResultConstant.ORDER_EXCEPTION_ORDER);
//        }
//
//        ApplyOrder applyOrder = new ApplyOrder();
//        BeanUtils.copyProperties(orderReqVo, applyOrder);
//        applyOrder.setState(1);
//        applyOrder.setApplyUserUid(UserUtils.getUser(request).getUid());
//        applyOrderService.insertSelective(applyOrder);
//        return new Result(ResultConstant.SUCCESS, applyOrder);
//    }

}