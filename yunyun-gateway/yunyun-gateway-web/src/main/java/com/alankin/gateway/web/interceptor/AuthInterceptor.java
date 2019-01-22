package com.alankin.gateway.web.interceptor;

import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 判断用户是否已登录
//        HttpSession session = request.getSession(false);
//        response.setCharacterEncoding("UTF-8");
//        if (session == null) {
//            Utils.writeResponesObj(response, new Result(ResultConstant.EXCEPTION_INVALID));
//            return false;
//        }
//        //一般用户或系统用户均不存在
//        if (session.getAttribute(Constants.SESSION_LOGIN_USER) == null&&session.getAttribute(Constants.SESSION_SYS_USER) == null) {
//            Utils.writeResponesObj(response, new Result(ResultConstant.EXCEPTION_NO_USER));
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}