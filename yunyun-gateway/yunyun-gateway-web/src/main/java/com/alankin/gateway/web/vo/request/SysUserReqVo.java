package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "SysUserReqVo", description = "")
public class SysUserReqVo extends BaseReqVO {

    @ApiModelProperty(value = "电话", example = "13900000000")
    @NotBlank(message = "电话不能为空")
    String phone;

    @ApiModelProperty(value = "图片验证码", example = "1111")
    @NotBlank(message = "图片验证码不能为空")
    String authCode;

    @ApiModelProperty(value = "密码 不能为空", example = "123")
    @NotBlank(message = "密码不能为空")
    String password;

    @Override
    public String toString() {
        return "SysUserReqVo{" +
                "phone='" + phone + '\'' +
                ", authCode='" + authCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
