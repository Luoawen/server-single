package com.alankin.gateway.web.controller;

import com.alankin.common.util.StringUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.vo.ListVo.IdReqVO;
import com.alankin.gateway.web.vo.ListVo.IdsReqVO;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.UpdateApplySettingReqVo;
import com.alankin.gateway.web.vo.request.VerifyEditReqVo;
import com.alankin.gateway.web.vo.request.VerifyListReqVo;
import com.alankin.gateway.web.vo.response.ListResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 系统管理接口
 * Created by alankin.
 */
@Controller
@Api(value = "系统管理接口", description = "系统管理接口")
@RequestMapping(value = "api/sysMng", method = RequestMethod.POST)
public class SystemMngController extends BaseWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemMngController.class);

    @Autowired
    private SysUserBaseService sysUserBaseService;
    @Autowired
    private SysUserAuthService sysUserAuthService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private DataDicService dataDicService;

    @ApiOperation(value = "所有账号")
    @RequestMapping(value = "/list")
    @ResponseBody
    @Transactional
    public ListResult list(HttpServletRequest request, @RequestBody ListReqVO<String> listReqVO) {
        SysUserBaseExample sysUserBaseExample = new SysUserBaseExample();
//        if (listReqVO.getCondition() != null) {
//            sysUserBaseExample.createCriteria()
//                    .andUserNameLike(listReqVO.getCondition());
//        }
        PageInfo<SysUserBase> pageInfo = sysUserBaseService.selectByExampleForStartPage(sysUserBaseExample, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new ListResult(ResultConstant.SUCCESS, pageInfo);
    }

    @ApiOperation(value = "渠道账号")
    @RequestMapping(value = "/listChannelAcount")
    @ResponseBody
    @Transactional
    public ListResult listChannelAcount(HttpServletRequest request, @RequestBody ListReqVO<String> listReqVO) {
//        SysUserBaseExample sysUserBaseExample = new SysUserBaseExample();
//        if (listReqVO.getReqBean() != null) {
//            sysUserBaseExample.createCriteria()
//                    .andUserNameLike(listReqVO.getReqBean());
//        }
//        PageInfo pageInfo = sysUserBaseService.selectForStartPageByMethod("listByRoleType", 3, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new ListResult(ResultConstant.SUCCESS, null);
    }

    @ApiOperation(value = "审核人账号")
    @RequestMapping(value = "/listVerifyAcount")
    @ResponseBody
    @Transactional
    public ListResult listVerifyAcount(HttpServletRequest request, @RequestBody ListReqVO<VerifyListReqVo> listReqVO) {
        PageInfo pageInfo = sysUserBaseService.selectForStartPageByMethod("listVerifyAcount", listReqVO, listReqVO.getPageNum(), listReqVO.getPageSize());
        return new ListResult(ResultConstant.SUCCESS, pageInfo);
    }

    @ApiOperation(value = "修改审核员账号")
    @RequestMapping(value = "/updateVerifyAcount")
    @ResponseBody
    @Transactional
    public Result updateVerifyAcount(HttpServletRequest request, @RequestBody VerifyEditReqVo verifyEditReqVo) {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(Long.valueOf(verifyEditReqVo.getUid()));
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        String identifier = verifyEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(ResultConstant.FAILED, "请输入正确的手机号");
        }
        userAuth.setIdentifier(identifier);
        userAuth.setCertificate(verifyEditReqVo.getPassword());
        sysUserAuthService.updateByPrimaryKeySelective(userAuth);

        SysUserBaseExample example1 = new SysUserBaseExample();
        example1.createCriteria()
                .andUidEqualTo(Long.valueOf(verifyEditReqVo.getUid()));
        SysUserBase userBase = sysUserBaseService.selectFirstByExample(example1);
        if (userBase == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        userBase.setMobile(identifier);
        userBase.setUserName(verifyEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(verifyEditReqVo.getUserRole()));
        userBase.setIsDel(verifyEditReqVo.getIsDel());
        userBase.setRealName(verifyEditReqVo.getRealName());
        userBase.setEmail(verifyEditReqVo.getEmail());
        userBase.setWchatId(verifyEditReqVo.getWchatId());
        if (!StringUtils.isEmpty(verifyEditReqVo.getWchatQrcode())) {
            userBase.setWchatQrcode(Long.valueOf(verifyEditReqVo.getWchatQrcode()));
        }
        sysUserBaseService.updateByPrimaryKeySelective(userBase);
        return new Result(ResultConstant.SUCCESS, null);
    }

    @ApiOperation(value = "新增审核员账号")
    @RequestMapping(value = "/addVerifyAcount")
    @ResponseBody
    @Transactional
    public Result addVerifyAcount(HttpServletRequest request, @RequestBody VerifyEditReqVo verifyEditReqVo) throws Exception {
        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andIdentifierEqualTo(verifyEditReqVo.getMobile());
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth != null) {
            return new Result(0, "已存在该账号!");
        }
        SysUserBaseExample userBaseExample = new SysUserBaseExample();
        userBaseExample.createCriteria()
                .andUserNameEqualTo(verifyEditReqVo.getUserName());
        SysUserBase sysUserBase = sysUserBaseService.selectFirstByExample(userBaseExample);
        if (sysUserBase != null) {
            return new Result(0, "已存在该用户名!");
        }

        //不存在账号时，创建用户
        SysUserBase userBase = new SysUserBase();
        userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
        int curentTime = SystemClock.currentTimeSecond();

        //获得登录账号
        //注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
        String identifier = verifyEditReqVo.getMobile();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(0, "请输入正确的手机号");
        }

        userBaseExample.clear();
        userBaseExample.createCriteria()
                .andMobileEqualTo(verifyEditReqVo.getMobile());
        if (sysUserBaseService.selectFirstByExample(userBaseExample) != null) {
            return new Result(0, "已存在该手机号!");
        }

        userBase.setMobile(identifier);
        userBase.setRegisterSource((byte) 1);
        userBase.setMobileBindTime(curentTime);
        userBase.setUserName(verifyEditReqVo.getUserName());
        userBase.setUserRole(Byte.valueOf(verifyEditReqVo.getUserRole()));
        userBase.setIsDel(verifyEditReqVo.getIsDel());
        userBase.setRealName(verifyEditReqVo.getRealName());
        userBase.setEmail(verifyEditReqVo.getEmail());
        userBase.setWchatId(verifyEditReqVo.getWchatId());
        if (!StringUtils.isEmpty(verifyEditReqVo.getWchatQrcode())) {
            userBase.setWchatQrcode(Long.valueOf(verifyEditReqVo.getWchatQrcode()));
        }
        if (sysUserBaseService.insertSelective(userBase) > 0) {
            SysUserAuth sysUserAuth = new SysUserAuth();
            sysUserAuth.setUid(userBase.getUid());
            sysUserAuth.setCertificate(verifyEditReqVo.getPassword());
            sysUserAuth.setIdentifier(verifyEditReqVo.getMobile());
            sysUserAuth.setIdentityType((byte) 1);

            SysRoleExample roleExample = new SysRoleExample();
            roleExample.createCriteria().andTypeEqualTo(2).andStatuEqualTo(1).andSysIdEqualTo(1);
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

    @ApiOperation(value = "删除账号")
    @RequestMapping(value = "/delVerifyAcount")
    @ResponseBody
    @Transactional
    public Result delVerifyAcount(HttpServletRequest request, @RequestBody IdReqVO idReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(2).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建审核员角色");
        }

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andUserIdEqualTo(idReqVO.getId()).andRoleIdEqualTo(sysRole.getId());
        SysRoleUser sysRoleUser = sysRoleUserService.selectFirstByExample(sysRoleUserExample);
        if (sysRoleUser == null) {
            return new Result(ResultConstant.FAILED, "该账号不是" + sysRole.getName());
        }

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andUidEqualTo(idReqVO.getId());
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT, null);
        }
        if (sysUserAuthService.deleteByPrimaryKey(userAuth.getId()) > 0 && sysRoleUserService.deleteByPrimaryKey(sysRoleUser.getId()) > 0 && sysUserBaseService.deleteByPrimaryKey(idReqVO.getId()) > 0) {
            return new Result(ResultConstant.SUCCESS, null);
        }
        return new Result(ResultConstant.FAILED, null);
    }

    @ApiOperation(value = "批量删除审核员账号")
    @RequestMapping(value = "/batchDelVerifyAcount")
    @ResponseBody
    @Transactional
    public Result batchDelVerifyAcount(@RequestBody IdsReqVO idsReqVO) {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andTypeEqualTo(2).andStatuEqualTo(1).andSysIdEqualTo(1);
        SysRole sysRole = sysRoleService.selectFirstByExample(roleExample);
        if (sysRole == null) {
            return new Result(ResultConstant.FAILED, "没有创建审核员角色");
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

    @ApiOperation(value = "修改申请单设置")
    @RequestMapping(value = "/updateApplySetting")
    @ResponseBody
    @Transactional
    public Result updateApplySetting(@RequestBody UpdateApplySettingReqVo vo) throws Exception {
        DataDicExample example = new DataDicExample();
        example.createCriteria().andDataTypeCodeEqualTo(15).andDicKeyEqualTo("1");
        DataDic dataDic = dataDicService.selectFirstByExample(example);
        dataDic.setDicValue(String.valueOf(vo.getMin()));

        DataDicExample example1 = new DataDicExample();
        example1.createCriteria().andDataTypeCodeEqualTo(15).andDicKeyEqualTo("2");
        DataDic dataDic1 = dataDicService.selectFirstByExample(example);
        dataDic1.setDicValue(String.valueOf(vo.getMax()));

        DataDicExample delExample = new DataDicExample();
        delExample.createCriteria().andDataTypeCodeEqualTo(16);
        dataDicService.deleteByExample(delExample);
        List<Integer> durationList = vo.getDurationList();
        for (Integer duration : durationList) {
            DataDic record = new DataDic();
            record.setDataTypeCode(16);
            record.setDicKey("1");
            record.setDicValue(String.valueOf(duration));
            record.setDataTypeName(String.valueOf(duration) + "天");
            record.setComment("周期标签");
            dataDicService.insertSelective(record);
        }
        return new Result(ResultConstant.SUCCESS, null);
    }
}