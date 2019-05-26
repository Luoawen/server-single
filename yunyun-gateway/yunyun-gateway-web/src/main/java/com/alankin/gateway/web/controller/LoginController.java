package com.alankin.gateway.web.controller;

import com.alankin.common.base.BaseController;
import com.alankin.common.util.RequestUtil;
import com.alankin.common.util.StringUtil;
import com.alankin.common.util.key.SnowflakeIdWorker;
import com.alankin.common.util.key.SystemClock;
import com.alankin.common.validator.NotNullValidator;
import com.alankin.gateway.web.base.BaseTokenResult;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.MsgCodeUtil;
import com.alankin.gateway.web.vo.ListVo.ListReqVO;
import com.alankin.gateway.web.vo.request.UserAuthReqVo;
import com.alankin.gateway.web.vo.request.UserReqVo;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.CookieUtils;
import com.alankin.gateway.web.utils.UserUtils;
import com.alankin.gateway.web.vo.request.VerifyListReqVo;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import com.alankin.ucenter.dao.model.*;
import com.alankin.ucenter.rpc.api.*;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "用户登录接口", description = "用户登录接口")
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController extends BaseWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserLocationService userLocationService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private SysUserBaseService sysUserBaseService;

    //登录
    @ApiOperation(value = "用户登录或注册")
    @RequestMapping(value = "/signin")
    @ResponseBody
    @Transactional
    public Result signin(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody UserReqVo vo) throws Exception {
        LOGGER.info("=================收到http请求：用户登录=================" + RequestUtil.getIpAddr(request));

        // 校验通过后删除验证码之前的session和Cookie
        HttpSession session = request.getSession();
        CookieUtils.delCookie(request, response, Constants.AUTH_CODE_SESSION_ID);

        //验证图片码
//        if (!AuthCodeController.check(request, vo.getAuthCode())) {
//            return new Result(ResultConstant.EXCEPTION_AUTH_CODE);
//        }
        //手机短信
        if (!MsgCodeUtil.validateCode(vo.getPhone(), vo.getPhoneCode(), session)) {
            return new Result(ResultConstant.EXCEPTION_MSG_CODE);
        }

        UserAuthExample example = new UserAuthExample();
        example.createCriteria().andIdentifierEqualTo(vo.getPhone()).andIsDelEqualTo(false);
        UserAuth userAuth = userAuthService.selectFirstByExample(example);
        if (userAuth != null) {//认证表存在
            UserBase userBase = userBaseService.selectByPrimaryKey(userAuth.getUid());
            if (userBase != null) {//基础信息表存在
                Long verifyUid = userBase.getVerifyUid();
                if (verifyUid == null) {//存在的用户但是没有分配审核人，再次登录将自动重新分配审核人。
                    distributUser(userBase);//分配审核人,及初始化审核状态。
                    userBaseService.updateByPrimaryKeySelective(userBase);//更新用户
                }
                UserUtils.createUserSession(request, userBase);
                return new BaseTokenResult(ResultConstant.SUCCESS, getUserResult(userBase), request.getSession().getId());
            } else {
                int curentTime = SystemClock.currentTimeSecond();
                UserBase userBase1 = new UserBase();
                userBase1.setUid(userAuth.getUid());
                userBase1.setUserName("damisujie_" + curentTime);
                userBase1.setRegisterSource((byte) 1);
                userBase1.setMobile(vo.getPhone());
                userBase1.setRegisterSource((byte) 1);
                userBase1.setMobileBindTime(curentTime);
                userBase1.setCreateTime(userAuth.getCreateTime());
                userBase1.setChannelId(vo.getChannelId());//设置引流渠道id
                distributUser(userBase1);//分配审核人,及初始化审核状态。
                if (userBaseService.insertSelective(userBase1) > 0) {
                    UserUtils.createUserSession(request, userBase1);
                    return new BaseTokenResult(ResultConstant.SUCCESS, getUserResult(userBase1), request.getSession().getId());
                }
            }
        } else {//不存在则创建用户
            int curentTime = SystemClock.currentTimeSecond();
            UserBase userBase = new UserBase();
            userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
            userBase.setUserName("damisujie_" + curentTime);
            userBase.setRegisterSource((byte) 1);
            userBase.setMobile(vo.getPhone());
            userBase.setRegisterSource((byte) 1);
            userBase.setMobileBindTime(curentTime);
            userBase.setChannelId(vo.getChannelId());//设置引流渠道id
            distributUser(userBase);//分配审核人,及初始化审核状态。
            if (userBaseService.insertSelective(userBase) > 0) {
                UserAuth record = new UserAuth();
                record.setIdentifier(vo.getPhone());
                record.setUid(userBase.getUid());
                record.setIdentityType((byte) 1);
                record.setCertificate(vo.getPassword());
                userAuthService.insertSelective(record);
                UserUtils.createUserSession(request, userBase);
                return new BaseTokenResult(ResultConstant.SUCCESS, getUserResult(userBase), request.getSession().getId());
            } else {
                throw new RuntimeException("注册失败");
            }
        }
        return new BaseTokenResult(ResultConstant.FAILED);
    }


    /**
     * 为用户分配审核人
     *
     * @param userBase
     */
    private void distributUser(UserBase userBase) {
        Long channelId = userBase.getChannelId();
        if (channelId == null || channelId <= 0) {//没有从任何渠道进入
            //随机分配审核人
            Long verifyUid = randomVerifyUid();
            userBase.setVerifyUid(verifyUid);
            userBase.setDistributStateKey(1);
            userBase.setVerifyStateKey(verifyUid != null ? 1 : 2);
        } else {
            //找到渠道
            Channel channel = channelService.selectByPrimaryKey(channelId);
            if (channel == null || channel.getVerifyUserId() == null) {//没找到渠道或渠道没有指定审核员,随机分配
                //随机分配审核人
                Long verifyUid = randomVerifyUid();
                userBase.setVerifyUid(verifyUid);
                userBase.setDistributStateKey(1);
                userBase.setVerifyStateKey(verifyUid != null ? 1 : 2);
            } else {//找到渠道，按渠道指定审核员分配
                Long verifyUserId = channel.getVerifyUserId();
                userBase.setVerifyUid(verifyUserId);
                userBase.setDistributStateKey(1);
                userBase.setVerifyStateKey(verifyUserId != null ? 1 : 2);
            }
        }
    }

    /**
     * 上一次被分配的审核员Uid
     */
    private SysUserBase lastVerify = null;

    /**
     * 随机获取审核员uid
     *
     * @return
     */
    private Long randomVerifyUid() {
        //查找所有分配状态为1（正常的审核员）
        List<SysUserBase> listNormalVerifyAcount = sysUserBaseService.selectAllBeanByMethod("listNormalVerifyAcount", null);
        if (listNormalVerifyAcount == null || listNormalVerifyAcount.size() < 1) {
            return null;
        }
        if (lastVerify == null) {
            lastVerify = listNormalVerifyAcount.get(0);
            return lastVerify.getUid();
        }

        SysUserBase sysUserBase = sysUserBaseService.selectBeanByMethod("selectNextNormalVerifyByUid", lastVerify.getUid());
        if (sysUserBase == null) {
            lastVerify = listNormalVerifyAcount.get(0);
            return lastVerify.getUid();
        } else {
            lastVerify = sysUserBase;
            return lastVerify.getUid();
        }
    }

    private UserAuthReqVo getUserResult(UserBase userBase) {
        UserAuthReqVo userAuthReqVo = new UserAuthReqVo();
        BeanUtils.copyProperties(userBase, userAuthReqVo);
        userAuthReqVo.setUid(String.valueOf(userBase.getUid()));
        if (userBase.getCompanyLocationUid() != null) {
            UserLocationExample example = new UserLocationExample();
            example.createCriteria().andUidEqualTo(userBase.getCompanyLocationUid());
            UserLocation userLocation = userLocationService.selectFirstByExample(example);
            if (userLocation != null) {
                userAuthReqVo.setCompanyProvance(userLocation.getCurrProvince());
                userAuthReqVo.setCompanyCity(userLocation.getCurrCity());
                userAuthReqVo.setCompanyArea(userLocation.getCurrDistrict());
                userAuthReqVo.setCompanyLocationDetail(userLocation.getLocation());
            }
        }
        return userAuthReqVo;
    }

    /**
     * 用户登出
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "用户登出")
    @RequestMapping(value = "logout")
    @ResponseBody
    public Object logout(HttpServletRequest request) {
        LOGGER.info("=================收到http请求：用户登出=================");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return new UcenterResult(UcenterResultConstant.SUCCESS, "注销成功");
        } else {
            return new UcenterResult(UcenterResultConstant.SUCCESS, "你还没有登录，无法注销");
        }
    }

}