package com.alankin.gateway.web.controller;

import com.alankin.common.util.RequestUtil;
import com.alankin.common.util.StringUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.common.validator.NotNullValidator;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.CookieUtils;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.BaseRespVO;
import com.alankin.gateway.web.vo.request.SysUserReqVo;
import com.alankin.gateway.web.vo.response.LoginResult;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户接口
 * Created by alankin.
 */
@Controller
@Api(value = "系统用户登录接口", description = "系统用户登录接口")
@RequestMapping(value = "/sysLogin", method = RequestMethod.POST)
public class SysLoginController extends BaseWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysLoginController.class);
    @Autowired
    private SysUserBaseService sysUserBaseService;
    @Autowired
    private SysUserAuthService sysUserAuthService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleModlePermissionService sysRoleModlePermissionService;
    @Autowired
    private SysModuleService sysModuleService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/signup")
    @ResponseBody
    @Transactional
    public Object signup(HttpServletRequest request, HttpServletResponse response, @RequestBody SysUserReqVo vo) {
        ComplexResult result = FluentValidator.checkAll()
                .on(vo.getPhone(), new NotNullValidator("Phone"))
                .on(vo.getAuthCode(), new NotNullValidator("AuthCode"))
                .on(vo.getPassword(), new NotNullValidator("Password"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return result.getErrors().get(0);
        }
        //验证图片二维码是否正确

        SysUserAuthExample example = new SysUserAuthExample();
        example.createCriteria()
                .andIdentifierEqualTo(vo.getPhone()).andIsDelEqualTo(false);
        SysUserAuth userAuth = sysUserAuthService.selectFirstByExample(example);
        if (userAuth != null) {
            return new Result(ResultConstant.EXCEPTION_ACOUNT_EXIST);
        }
        //不存在账号时，创建用户
        SysUserBase userBase = new SysUserBase();
        userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
        int curentTime = SystemClock.currentTimeSecond();

        //获得登录账号
        //注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
        String identifier = vo.getPhone();
        if (!StringUtil.isPhoneNumber(identifier)) {
            return new Result(ResultConstant.FAILED, "请输入正确的手机号");
        }

        userBase.setMobile(identifier);
        userBase.setRegisterSource((byte) 1);
        userBase.setMobileBindTime(curentTime);
        userBase.setUserName("shenSuDai_" + curentTime);
        if (sysUserBaseService.insertSelective(userBase) > 0) {
            SysUserAuth sysUserAuth = new SysUserAuth();
            sysUserAuth.setUid(userBase.getUid());
            sysUserAuth.setCertificate(vo.getPassword());
            sysUserAuth.setIdentifier(vo.getPhone());
            sysUserAuth.setIdentityType((byte) 1);
            sysUserAuthService.insertSelective(sysUserAuth);
            return new Result(ResultConstant.SUCCESS, userBase);
        } else {
            throw new RuntimeException("注册失败");
        }
    }

    //登录
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/signin")
    @ResponseBody
    public Result signin(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody SysUserReqVo vo) {
        //验证图片二维码是否正确
        if (!AuthCodeController.check(request, vo.getAuthCode())) {
            return new Result(ResultConstant.EXCEPTION_AUTH_CODE);
        }
        // 校验通过后删除验证码之前的session和Cookie
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

        SysUserAuthExample sysUserAuthExample = new SysUserAuthExample();
        sysUserAuthExample.createCriteria()
                .andIdentifierEqualTo(vo.getPhone())
                .andCertificateEqualTo(vo.getPassword()).andIsDelEqualTo(false);
        sysUserAuthService.selectByExample(sysUserAuthExample);
        SysUserAuth sysUserAuth = sysUserAuthService.selectFirstByExample(sysUserAuthExample);
        if (sysUserAuth == null) {
            return new Result(ResultConstant.EXCEPTION_ACOUNT_OR_PWD_NOT_RIGHT);
        }
        SysUserBase sysUserBase = sysUserBaseService.selectByPrimaryKey(sysUserAuth.getUid());
        if (sysUserBase == null) {
            return new Result(ResultConstant.EXCEPTION_NO_ACOUNT);
        }
        Map param = new HashMap(2);
        param.put("uid", sysUserBase.getUid());
        List<SysModule> sysModules = sysModuleService.selectAllBeanByMethod("findAllSysModuleByUserIdAndParentId", param);
        for (SysModule sysModule : sysModules) {
            Map param1 = new HashMap(2);
            param1.put("uid", sysUserBase.getUid());
            param1.put("parentid", sysModule.getId());
            List<SysModule> childSysModules = sysModuleService.selectAllBeanByMethod("findAllSysModuleByUserIdAndParentId", param1);
            sysModule.setChildren(childSysModules);
        }

        HttpSession newSession = request.getSession(true);
        newSession.setAttribute(Constants.SESSION_SYS_USER, sysUserBase);
        newSession.setAttribute(Constants.REQUEST_CLIENT_IP, RequestUtil.getIpAddr(request));
        newSession.setAttribute(Constants.SESSION_AUTHS_KEY, sysModules);
        Map map = new HashMap();
        map.put("sysUserBase", sysUserBase);
        map.put("sysModules", sysModules);
        Result result = new Result(ResultConstant.SUCCESS, map);
        return result;
    }

    //用户注销
    @ApiOperation(value = "用户注销")
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return new Result(ResultConstant.SUCCESS);
        } else {
            return new Result(ResultConstant.EXCEPTION_NO_USER);
        }
    }
}