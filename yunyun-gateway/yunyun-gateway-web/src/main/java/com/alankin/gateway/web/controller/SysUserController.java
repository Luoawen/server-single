package com.alankin.gateway.web.controller;

import com.alankin.common.base.BaseController;
import com.alankin.gateway.web.base.BaseWebController;
import com.alankin.gateway.web.vo.request.UserAuthReqVo;
import com.alankin.ucenter.common.constant.UcenterResult;
import com.alankin.ucenter.common.constant.UcenterResultConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统用户接口
 * Created by alankin.
 */
@Controller
@Api(value = "系统用户接口", description = "系统用户接口")
@RequestMapping(value = "api/sysUser", method = RequestMethod.POST)
public class SysUserController extends BaseWebController {

    //系统用户资料更新
    @ApiOperation(value = "系统用户资料更新")
    @RequestMapping(value = "update")
    @ResponseBody
    public Object update(HttpServletRequest request, HttpServletResponse response, @RequestBody UserAuthReqVo vo) {
        // 判断用户是否已登录
//        HttpSession session = request.getSession(false);
//        UserBase userBase = (UserBase) session.getAttribute(Constants.SESSION_LOGIN_USER);
//        BeanUtils.copyProperties(vo, userBase);
//        userBaseService.updateByPrimaryKeySelective(userBase);
        return new UcenterResult(UcenterResultConstant.FAILED, null);
    }
}