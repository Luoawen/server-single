package com.alankin.gateway.web.utils;

import com.alankin.common.util.RequestUtil;
import com.alankin.gateway.web.exception.UserInvalidException;
import com.alankin.ucenter.dao.model.SysModule;
import com.alankin.ucenter.dao.model.SysUserBase;
import com.alankin.ucenter.dao.model.UserBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by alankin on 2018/12/30.
 */
public class UserUtils {

    public static SysUserBase getSysUser(HttpServletRequest request) throws UserInvalidException {
        // 判断用户是否已登录
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new UserInvalidException();
        }
        SysUserBase sysUserBase = (SysUserBase) session.getAttribute(Constants.SESSION_SYS_USER);
        if (sysUserBase == null) {
            throw new UserInvalidException();
        }
        return sysUserBase;
    }

    public static UserBase getUser(HttpServletRequest request) throws UserInvalidException {
        // 判断用户是否已登录
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new UserInvalidException();
        }
        UserBase userBase = (UserBase) session.getAttribute(Constants.SESSION_LOGIN_USER);
        if (userBase == null) {
            throw new UserInvalidException();
        }
        return userBase;
    }

    public static void createUserSession(HttpServletRequest request, UserBase userBase) {
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
        HttpSession session = request.getSession(true);
        // 将系统生成的sessionId作为token返回给前端
//        userBase.setToken(session.getId());
        // 在session中保存登录信息
//        session.setAttribute(Constants.SESSION_AUTHS_KEY, null);
        session.setAttribute(Constants.SESSION_LOGIN_USER, userBase);
        session.setAttribute(Constants.REQUEST_CLIENT_IP, RequestUtil.getIpAddr(request));
        // 在redis中，保存userId和 sessionId 的映射关系
//        sessionHandler.putSessionId(resp.getLoginUser().getUserId(), session.getId());
    }

    public static void createSysUserSession(HttpServletRequest request, SysUserBase userBase) {
        HttpSession newSession = request.getSession(true);
        // 将系统生成的sessionId作为token返回给前端
//        userBase.setToken(session.getId());
        // 在session中保存登录信息
//        newSession.setAttribute(Constants.SESSION_AUTHS_KEY, null);
        newSession.setAttribute(Constants.SESSION_SYS_USER, userBase);
        newSession.setAttribute(Constants.REQUEST_CLIENT_IP, RequestUtil.getIpAddr(request));
        // 在andler.putSessionId(resp.getLoginUser().getUserId(), session.getId());
    }

    public static void createSysUserAuths(HttpServletRequest request, List<SysModule> moduleList) {
        HttpSession session = request.getSession(true);
        session.setAttribute(Constants.SESSION_AUTHS_KEY, moduleList);
    }
}
