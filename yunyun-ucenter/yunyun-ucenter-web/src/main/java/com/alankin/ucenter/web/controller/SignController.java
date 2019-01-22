package com.alankin.ucenter.web.controller;

import com.alankin.common.base.BaseController;
import com.alankin.common.validator.NotNullValidator;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import com.alankin.ucenter.dao.model.UserAuth;
import com.alankin.ucenter.dao.model.UserAuthExample;
import com.alankin.ucenter.dao.model.UserBase;
import com.alankin.ucenter.rpc.api.UserAuthService;
import com.alankin.ucenter.rpc.api.UserBaseService;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 * Created by alankin.
 */
@Controller
@Api(value = "注册控制器", description = "注册控制器")
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class SignController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    @Autowired
    private UserBaseService userBaseService;

    private UserAuthService userAuthService;

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/signup")
    @ResponseBody
    public Object signup(HttpServletRequest request) {
//        UserBase userBase = new UserBase();
//        userBase.setUid(new SnowflakeIdWorker(0, 0).nextId());
//        userBase.setBirthday(SystemClock.now());
//        userBase.setCreateTime(1111);
//        userBase.setUpdateTime(222);
//        userBase.setPushToken("3333");
//        userBase.setEmail("465628112@qq.com");
//        userBase.setGender(true);
//        userBase.setMobile("18752456854");
//        userBase.setNickName("摇尾巴的狗");
//        if (userBaseService.insertSelective(userBase) > 0) {
//            return new UcenterResult(UcenterResultConstant.SUCCESS, userBase);
//        }
        return new UcenterResult(UcenterResultConstant.FAILED, null);
    }

    //登录
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/signin")
    @ResponseBody
    public Object signin(@RequestBody UserAuth vo) {
        Result result = FluentValidator.checkAll()
                .on(vo.getCertificate(), new NotNullValidator("Certificate"))
                .on(vo.getIdentifier(), new NotNullValidator("Identifier"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        if (!result.isSuccess()) {
            return result.getErrors().get(0);
        }

        UserAuthExample userAuthExample = new UserAuthExample();
        userAuthExample
                .createCriteria()
                .andIdentifierEqualTo(vo.getIdentifier())
                .andIdentifierEqualTo(vo.getIdentifier());
        UserAuth userAuth = userAuthService.selectFirstByExample(userAuthExample);

        if (userAuth == null) {
            return new UcenterResult(UcenterResultConstant.FAILED, "用户名或密码错误");
        }
        UserBase userBase = userBaseService.selectByPrimaryKey(userAuth.getUid());
        if(userBase==null){
            return new UcenterResult(UcenterResultConstant.FAILED, "该用户不存在");
        }
        return new UcenterResult(UcenterResultConstant.SUCCESS, userBase);
    }


}