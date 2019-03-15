package com.alankin.gateway.web.vo.request;

import com.alankin.gateway.web.utils.MsgCodeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "UserReqVo", description = "")
public class UserReqVo extends BaseReqVO {

    @ApiModelProperty(value = "电话", example = "13900000000")
    @NotEmpty(message = "请输入手机号码")
    @NotNull(message = "请输入手机号码")
    @Pattern(regexp = "^1[0-9][0-9]\\d{8}$", message = "请输入正确的电话号码")
    String phone;
    @ApiModelProperty(value = "图片验证码", example = "1111")
    String authCode;
    @ApiModelProperty(value = "短信验证码", example = "2222")
    @NotEmpty(message = "请填写短信验证码")
    @Length(min = MsgCodeUtil.MSG_CODE_NUM, max = MsgCodeUtil.MSG_CODE_NUM, message = "请输入" + MsgCodeUtil.MSG_CODE_NUM + "位短信验证码")
    String phoneCode;
    @ApiModelProperty(value = "密码", example = "123")
//    @NotBlank(message = "密码不能为空")
    String password;
    /**
     * 引流渠道id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "引流进入的渠道id")
    private Long channelId;

    @Override
    public String toString() {
        return "UserReqVo{" +
                "phone='" + phone + '\'' +
                ", authCode='" + authCode + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", password='" + password + '\'' +
                ", channelId=" + channelId +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
