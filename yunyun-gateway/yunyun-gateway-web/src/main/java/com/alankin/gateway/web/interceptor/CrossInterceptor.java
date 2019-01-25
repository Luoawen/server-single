package com.alankin.gateway.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: alankin
 * @Description: TODO
 * @date 创建时间：2019/1/25　12:43
 */
public class CrossInterceptor  extends HandlerInterceptorAdapter{
//    private String accessControlAllowOrigin;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String curOrigin = request.getHeader("Origin");
//        if (StringUtils.isNotBlank(curOrigin)) {
//            String[] allowUrls = accessControlAllowOrigin.split(",");
//            for (String origin : allowUrls) {
//                if (origin.equals(curOrigin)) {
//                    response.addHeader("Access-Control-Allow-Origin", origin);
//                }
//            }
//        }
        String curOrigin = request.getHeader("Origin");
        response.addHeader("Access-Control-Allow-Origin", curOrigin);
//        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie, Authorization");
        return super.preHandle(request, response, handler);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        if (StringUtils.isBlank(accessControlAllowOrigin)) {
//            throw new RuntimeException("请配置CrossInterceptor跨域支持的host");
//        }
//    }

//    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
//        this.accessControlAllowOrigin = accessControlAllowOrigin;
//    }
}
