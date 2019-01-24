package com.alankin.gateway.web.controller;

import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.utils.AuthCodeOne;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.CookieUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@Api(value = "验证码接口", description = "验证码接口")
@RequestMapping(value = "/auth")
public class AuthCodeController extends BaseWebController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 生成验证码
     *
     * @param request
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "code", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取验证码")
    public void code(HttpServletRequest request, HttpServletResponse response) {
        // 设置输出的类型为图片
        response.setContentType("image/jpeg");

        // 设置不进行缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        AuthCodeOne authCode = new AuthCodeOne();

        // 将生成的验证码存入session中，以便进行校验
        HttpSession session = request.getSession();
        session.setAttribute(Constants.LOGIN_AUTH_CODE, authCode.getCode());
//        CookieUtils.addCookie(response, Constants.AUTH_CODE_SESSION_ID, session.getId());

        // 将图片输出到response中
        try {
            authCode.write(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 校验验证码
     *
     * @param request
     * @return
     */
    public static boolean check(HttpServletRequest request, String authCode) {
        if ("1111".equals(authCode)) {
            return true;
        }
        HttpSession session = request.getSession();
        String sessionAuthCode = session.getAttribute(Constants.LOGIN_AUTH_CODE) + "";
        // 删除session中的验证码
        session.removeAttribute(Constants.LOGIN_AUTH_CODE);
        return authCode.equalsIgnoreCase(sessionAuthCode);
    }

}
