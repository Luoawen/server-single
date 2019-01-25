package com.alankin.gateway.web.interceptor;

import com.alankin.common.util.RequestUtil;
import com.alankin.gateway.web.utils.Constants;
import com.alankin.gateway.web.utils.Utils;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);
    @Resource
    private Map<String, String> overtApiMap;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 截取访问地址
        String uri = request.getRequestURI();
        uri = uri.replaceAll("//", "/");
        uri = uri.substring(uri.indexOf("/", uri.indexOf("api/")));

        // 判断访问的接口是否为公开接口
        if (isOvertApi(uri)) {
            return true;
        }

        // 判断用户是否已登录
        HttpSession session = request.getSession(false);
        if (session == null) {
            Utils.writeResponesObj(response, new Result(ResultConstant.EXCEPTION_INVALID));
            return false;
        }

        //一般用户或系统用户均不存在
        if (session.getAttribute(Constants.SESSION_LOGIN_USER) == null && session.getAttribute(Constants.SESSION_SYS_USER) == null) {
            Utils.writeResponesObj(response, new Result(ResultConstant.EXCEPTION_NO_USER));
            return false;
        }

        // 校验当前IP是否与登录时的IP一致
        String reqIp = RequestUtil.getIpAddr(request);
        if (!reqIp.startsWith("0:0:0:0") && !"127.0.0.1".equals(reqIp)
                && !reqIp.equalsIgnoreCase(session.getAttribute(Constants.REQUEST_CLIENT_IP) + "")) {
            LOGGER.error("接口:{},,访问IP与登录不一致！{}---{}",
                    request.getRequestURI(),
                    reqIp,
                    session.getAttribute(Constants.REQUEST_CLIENT_IP));
            Utils.writeResponesObj(response, new Result(ResultConstant.EXCEPTION_NO_USER));
            return false;
        }
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

    /**
     * 校验访问的接口是否公开不需要权限控制
     *
     * @return
     */
    private boolean isOvertApi(String uri) {
        for (Iterator<String> iterator = overtApiMap.keySet().iterator(); iterator.hasNext(); ) {
            if (uri.startsWith(iterator.next())) {
                return true;
            }
        }
        return false;
    }
}