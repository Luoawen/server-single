package com.alankin.gateway.web.controller;

import com.alankin.common.util.StringUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.IdsReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.BrowerEditReqVo;
import com.alankin.gateway.web.vo.request.LoanEditReqVo;
import com.alankin.gateway.web.vo.request.LoanReceiptListReqVo;
import com.alankin.gateway.web.vo.request.RepayOrderEditReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zhicheng.echo.star.utils.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "借条管理接口", description = "借条管理接口")
@RequestMapping(value = "/api/loanMng", method = RequestMethod.POST)
public class LoanMngController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanMngController.class);

    @Autowired
    private LoanReceiptService loanReceiptService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserBaseService sysUserBaseService;
    @Autowired
    private SysUserAuthService sysUserAuthService;

    @Autowired
    private RepayOrderService repayOrderService;
    @Autowired
    private ApplyStateLogService applyStateLogService;
    @Autowired
    private ApplyOrderService applyOrderService;

    //    借条
    @ApiOperation(value = "借条列表")
    @RequestMapping(value = "/getLoanByOrderId")
    @ResponseBody
    @Transactional
    public ListResult getLoanByOrderId(@RequestBody IdReqVO idReqVO) {
        LoanReceiptExample example = new LoanReceiptExample();
        example.createCriteria().andApplyOrderUidEqualTo(idReqVO.getId());
        LoanReceipt loanReceipt = loanReceiptService.selectFirstByExample(example);
//
//        if (pageInfo != null) {
//            return new ListResult(ResultConstant.SUCCESS, pageInfo);
//        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    //    借条
    @ApiOperation(value = "借条列表")
    @RequestMapping(value = "/loanlist")
    @ResponseBody
    @Transactional
    public ListResult loanlist(HttpServletRequest request, @RequestBody ListReqVO<LoanReceiptListReqVo> listReqVO) {
        SysUserBase sysUser = UserUtils.getSysUser(request);
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(sysUser.getUid());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        SysRole sysRole = sysRoleService.selectByPrimaryKey(sysRoleUser.getRoleId());
        PageInfo pageInfo = null;
        //判断用户是否是超级管理员
        if (sysRole.getType() == 1) {//如果是超级管理员，展示所有列表
            pageInfo = loanReceiptService.selectForStartPageByMethod("loanlist", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        } else if (sysRole.getType() == 4) {//出借人看申请单
            listReqVO.getCondition().setBrrowerUid(sysUser.getUid());
            pageInfo = loanReceiptService.selectForStartPageByMethod("loanlist", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        }
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "添加借条")
    @RequestMapping(value = "/addLoanReceipt")
    @ResponseBody
    @Transactional
    public Result addLoanReceipt(@RequestBody LoanEditReqVo loanEditReqVo) throws Exception {
        LoanReceipt loanReceipt = new LoanReceipt();
        BeanUtils.copyProperties(loanEditReqVo, loanReceipt);
        loanReceipt.setState((byte) 2);//借条状态同申请单状态
        ApplyOrder applyOrder = applyOrderService.selectByPrimaryKey(loanEditReqVo.getApplyOrderUid());
        if (applyOrder == null) {
            return new Result(ResultConstant.FAILED, null);
        }
        ApplyStateLogExample example = new ApplyStateLogExample();
        example.createCriteria().andOrderIdEqualTo(loanEditReqVo.getApplyOrderUid()).andNowStateEqualTo(2);
        ApplyStateLog applyStateLog = applyStateLogService.selectFirstByExample(example);
        if (applyStateLog == null) {//不存在该状态的修改记录，则创建
            ApplyStateLog record = new ApplyStateLog();
            record.setLastState(applyOrder.getState());
            record.setNowState(2);
            record.setOrderId(applyOrder.getUid());
            record.setSysUserId(loanEditReqVo.getBrowerId());
            applyStateLogService.insertSelective(record);
        } else {//存在,则修改时间
            applyStateLog.setCreateTime((int) (SystemClock.now() / 1000));
            applyStateLogService.updateByPrimaryKey(applyStateLog);
        }
        applyOrder.setState(2);
        if (loanReceiptService.insertSelective(loanReceipt) > 0 && applyOrderService.updateByPrimaryKeySelective(applyOrder) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    /**
     * @param vo 修改状态为4   即已放款
     * @return
     */
    @ApiOperation(value = "确认放款")
    @RequestMapping(value = "/fankuan")
    @ResponseBody
    @Transactional
    public Result fankuan(@RequestBody IdReqVO vo) throws Exception {
        Long orderUid = vo.getId();
        return updateState(orderUid, 4);
    }

    private Result updateState(Long orderUid, int state) throws Exception {
        if (orderUid == null) {
            return new Result(ResultConstant.FAILED);
        }
        LoanReceiptExample loanExample = new LoanReceiptExample();
        loanExample.createCriteria().andApplyOrderUidEqualTo(orderUid);
        LoanReceipt loanReceipt = loanReceiptService.selectFirstByExample(loanExample);
        if (loanReceipt == null) {
            return new Result(ResultConstant.FAILED);
        }
        ApplyOrder applyOrder = applyOrderService.selectByPrimaryKey(orderUid);
        if (applyOrder == null) {
            return new Result(ResultConstant.FAILED);
        }

        ApplyStateLogExample example = new ApplyStateLogExample();
        example.createCriteria().andOrderIdEqualTo(orderUid).andNowStateEqualTo(state);
        ApplyStateLog applyStateLog = applyStateLogService.selectFirstByExample(example);
        if (applyStateLog == null) {//不存在该状态的修改记录，则创建
            ApplyStateLog record = new ApplyStateLog();
            record.setLastState(applyOrder.getState());
            record.setNowState(state);
            record.setOrderId(applyOrder.getUid());
            record.setSysUserId(loanReceipt.getBrowerId());
            applyStateLogService.insertSelective(record);
        } else {//存在,则修改时间
            applyStateLog.setCreateTime((int) (SystemClock.now() / 1000));
            applyStateLogService.updateByPrimaryKey(applyStateLog);
        }
        loanReceipt.setState((byte) state);
        applyOrder.setState(state);
        if (loanReceiptService.updateByPrimaryKeySelective(loanReceipt) > 0 && applyOrderService.updateByPrimaryKeySelective(applyOrder) > 0) {
            return new Result(ResultConstant.SUCCESS);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "更新借条")
    @RequestMapping(value = "/updateLoanReceipt")
    @ResponseBody
    @Transactional
    public Result updateLoanReceipt(@RequestBody LoanEditReqVo loanEditReqVo) throws Exception {
        LoanReceipt loanReceipt = new LoanReceipt();
        BeanUtils.copyProperties(loanEditReqVo, loanReceipt);
        if (loanReceiptService.updateByPrimaryKeySelective(loanReceipt) > 0) {
            return autoUpdateState(loanReceipt.getUid());
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "删除借条")
    @RequestMapping(value = "/delLoanReceipt")
    @ResponseBody
    @Transactional
    public Result delLoanReceipt(@RequestBody IdReqVO idReqVO) {
        if (loanReceiptService.deleteByPrimaryKey(idReqVO.getId()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除借条")
    @RequestMapping(value = "/batchDelLoanReceipt")
    @ResponseBody
    @Transactional
    public Result batchDelLoanReceipt(@RequestBody IdsReqVO idsReqVO) {
        if (loanReceiptService.deleteByPrimaryKeys(idsReqVO.getIds()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    //   出借人
    @ApiOperation(value = "出借人列表")
    @RequestMapping(value = "/brrowerList")
    @ResponseBody
    @Transactional
    public ListResult brrowerList(@RequestBody ListReqVO listReqVO) {
        PageInfo pageInfo = loanReceiptService.selectForStartPageByMethod("brrowerList", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        if (pageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, pageInfo);
        }
        return new ListResult(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "添加出借人")
    @RequestMapping(value = "/addBrrower")
    @ResponseBody
    @Transactional
    public Result addBrrower(@RequestBody BrowerEditReqVo browerEditReqVo) throws Exception {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andIdentifierEqualTo(browerEditReqVo.getMobile()).andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth != null) {
            return new Result(0, "已存在该账号!");
        }

        SysUserBaseExample userBaseExample = new SysUserBaseExample();
        userBaseExample.createCriteria()
                .andUserNameEqualTo(browerEditReqVo.getUserName());
        if (sysUserBaseService.selectFirstByExample(userBaseExample) != null) {
            return new Result(0, "已存在该用户名!");
        }

        //不存在账号时，创建用户
        SysUserBase userBase = new SysUserBase();
        userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
        int curentTime = SystemClock.currentTimeSecond();

        //获得登录账号
        //注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
        String identifier = browerEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(0, "请输入正确的手机号");
        }

        userBaseExample.clear();
        userBaseExample.createCriteria()
                .andMobileEqualTo(browerEditReqVo.getMobile());
        if (sysUserBaseService.selectFirstByExample(userBaseExample) != null) {
            return new Result(0, "已存在该手机号!");
        }

        userBase.setMobile(identifier);
        userBase.setRegisterSource((byte) 1);
        userBase.setMobileBindTime(curentTime);
        userBase.setUserName(browerEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(browerEditReqVo.getUserRole()));
        userBase.setRealName(browerEditReqVo.getRealName());
        userBase.setEmail(browerEditReqVo.getEmail());
        userBase.setWchatId(browerEditReqVo.getWchatId());
        if (!StringUtils.isEmpty(browerEditReqVo.getWchatQrcode())) {
            userBase.setWchatQrcode(Long.valueOf(browerEditReqVo.getWchatQrcode()));
        }
        if (sysUserBaseService.insertSelective(userBase) > 0) {
            SysUserAuth sysUserAuth = new SysUserAuth();
            sysUserAuth.setUid(userBase.getUid());
            sysUserAuth.setCertificate(browerEditReqVo.getPassword());
            sysUserAuth.setIdentifier(browerEditReqVo.getMobile());
            sysUserAuth.setIdentityType((byte) 1);

            SysRoleExample roleExample = new SysRoleExample();
            roleExample.createCriteria().andTypeEqualTo(4).andStatuEqualTo(1).andSysIdEqualTo(1);
            SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
            if (sysRole == null) {
                return new Result(ResultConstant.FAILED, null);
            }
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setRoleId(sysRole.getId());
            roleUser.setRolename(sysRole.getName());
            roleUser.setUserId(userBase.getUid());
            sysRoleUserService.insertSelective(roleUser);

            //添加密码认证权限
            sysUserAuthService.insertSelective(sysUserAuth);
            return new Result(ResultConstant.SUCCESS, userBase);
        } else {
            return new Result(ResultConstant.FAILED, null);
        }
    }

    @ApiOperation(value = "更新出借人")
    @RequestMapping(value = "/updateBrrower")
    @ResponseBody
    @Transactional
    public Result updateBrrower(@RequestBody BrowerEditReqVo browerEditReqVo) {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(Long.valueOf(browerEditReqVo.getUid()))
                .andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        String identifier = browerEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(ResultConstant.FAILED, "请输入正确的手机号");
        }
        userAuth.setIdentifier(identifier);
        userAuth.setCertificate(browerEditReqVo.getPassword());
        sysUserAuthService.updateByPrimaryKeySelective(userAuth);

        SysUserBaseExample example1 = new SysUserBaseExample();
        example1.createCriteria()
                .andUidEqualTo(Long.valueOf(browerEditReqVo.getUid()))
                .andIsDelEqualTo(false);
        SysUserBase userBase = sysUserBaseService.selectFirstByExample(example1);
        if (userBase == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        userBase.setMobile(identifier);
        userBase.setUserName(browerEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(browerEditReqVo.getUserRole()));
        userBase.setRealName(browerEditReqVo.getRealName());
        userBase.setEmail(browerEditReqVo.getEmail());
        userBase.setWchatId(browerEditReqVo.getWchatId());
        if (!StringUtils.isEmpty(browerEditReqVo.getWchatQrcode())) {
            userBase.setWchatQrcode(Long.valueOf(browerEditReqVo.getWchatQrcode()));
        }
        sysUserBaseService.updateByPrimaryKeySelective(userBase);
        return new Result(ResultConstant.SUCCESS, null);
    }

    @ApiOperation(value = "删除出借人")
    @RequestMapping(value = "/delBrrower")
    @ResponseBody
    @Transactional
    public Result delBrrower(@RequestBody IdReqVO idReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(4).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建出借人角色");
        }

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(idReqVO.getId()).andRoleIdEqualTo(sysRole.getId());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        if (sysRoleUser == null) {
            return new Result(ResultConstant.FAILED, "该账号不是" + sysRole.getName());
        }

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(idReqVO.getId()).andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        if (sysUserAuthService.deleteByPrimaryKey(userAuth.getId()) > 0 && sysRoleUserService.deleteByPrimaryKey(sysRoleUser.getId()) > 0 && sysUserBaseService.deleteByPrimaryKey(idReqVO.getId()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除出借人")
    @RequestMapping(value = "/batchDelBrrower")
    @ResponseBody
    @Transactional
    public Result batchDelBrrower(@RequestBody IdsReqVO idsReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(4).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建出借人角色");
        }

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        List<String> strings = Arrays.asList(idsReqVO.getIds());
        List<Long> ids = new ArrayList<>();
        for (String string : strings) {
            ids.add(Long.valueOf(string));
        }
        sysRoleUserExample.createCriteria().andUserIdIn(ids).andRoleIdEqualTo(sysRole.getId());

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria().andUidIn(ids);
        if (sysUserAuthService.deleteByExample(example) > 0 && sysRoleUserService.deleteByExample(sysRoleUserExample) > 0 && sysUserBaseService.deleteByPrimaryKeys(idsReqVO.getIds()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "还款单列表")
    @RequestMapping(value = "/repayOrderList")
    @ResponseBody
    @Transactional
    public ListResult repayOrderList(@RequestBody ListReqVO<IdReqVO> listReqVO) {
        RepayOrderExample orderExample = new RepayOrderExample();
        orderExample.createCriteria().andLoanReceiptIdEqualTo(listReqVO.getCondition().getId());
        PageInfo<RepayOrder> repayOrderPageInfo = repayOrderService.selectByExampleForStartPage(orderExample, listReqVO.getPageNum(), listReqVO.getPageSize());
        if (repayOrderPageInfo != null) {
            return new ListResult(ResultConstant.SUCCESS, repayOrderPageInfo);
        }
        return new ListResult(ResultConstant.FAILED);
    }

    @ApiOperation(value = "添加还款单")
    @RequestMapping(value = "/addRepayOrder")
    @ResponseBody
    @Transactional
    public Result addRepayOrder(@RequestBody RepayOrderEditReqVo repayOrderEditReqVo) throws Exception {
        RepayOrder repayOrder = new RepayOrder();
        BeanUtils.copyProperties(repayOrderEditReqVo, repayOrder);
        if (repayOrderService.insertSelective(repayOrder) > 0) {
            return autoUpdateState(repayOrderEditReqVo.getLoanReceiptId());
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "更新还款单")
    @RequestMapping(value = "/updateRepayOrder")
    @ResponseBody
    @Transactional
    public Result updateRepayOrder(@RequestBody RepayOrderEditReqVo repayOrderEditReqVo) throws Exception {
        RepayOrder repayOrder = new RepayOrder();
        BeanUtils.copyProperties(repayOrderEditReqVo, repayOrder);
        if (repayOrderService.updateByPrimaryKeySelective(repayOrder) > 0) {
            return autoUpdateState(repayOrderEditReqVo.getLoanReceiptId());
        }
        return new Result(ResultConstant.FAILED);
    }

    private Result autoUpdateState(Long loanReceiptId) throws Exception {
        RepayOrderExample example = new RepayOrderExample();
        example.createCriteria().andLoanReceiptIdEqualTo(loanReceiptId);
        List<RepayOrder> repayOrders = repayOrderService.selectByExample(example);
        long sum = 0;
        for (RepayOrder order : repayOrders) {
            sum += order.getRepayMoney();
        }
        LoanReceipt loanReceipt = loanReceiptService.selectByPrimaryKey(loanReceiptId);
        Integer shouldRepayMoney = loanReceipt.getShouldRepayMoney();
        if (sum >= shouldRepayMoney) {//大于等于借款数时，自动更新状态
            return updateState(loanReceipt.getApplyOrderUid(), 5);
        } else {
            if (loanReceipt.getState() == 5) {//原来为已结清状态才需要改变
                return updateState(loanReceipt.getApplyOrderUid(), 4);
            }
        }
        return new Result(ResultConstant.SUCCESS);
    }

    @ApiOperation(value = "删除还款单")
    @RequestMapping(value = "/delRepayOrder")
    @ResponseBody
    @Transactional
    public Result delRepayOrder(@RequestBody IdReqVO idReqVO) throws Exception {
        RepayOrderExample example = new RepayOrderExample();
        example.createCriteria().andUidEqualTo(idReqVO.getId());
        RepayOrder repayOrder = repayOrderService.selectByPrimaryKey(idReqVO.getId());
        Long loanReceiptId = repayOrder.getLoanReceiptId();
        if (repayOrderService.deleteByExample(example) > 0) {
            return autoUpdateState(loanReceiptId);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除还款单")
    @RequestMapping(value = "/batchDelRepayOrder")
    @ResponseBody
    @Transactional
    public Result batchDelRepayOrder(@RequestBody IdsReqVO idsReqVO) {
        RepayOrderExample example = new RepayOrderExample();
        String[] ids = idsReqVO.getIds();
        List<Long> longs = new ArrayList<>();
        for (String id : ids) {
            longs.add(Long.valueOf(id));
        }
        example.createCriteria().andUidIn(longs);
        if (repayOrderService.deleteByExample(example) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }


}
