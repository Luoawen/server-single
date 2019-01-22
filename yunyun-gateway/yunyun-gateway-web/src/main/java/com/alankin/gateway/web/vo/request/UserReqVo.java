package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by alankin on 2018/12/30.
 */
@ApiModel(value = "UserReqVo", description = "")
public class UserReqVo extends BaseReqVO {

    @ApiModelProperty(value = "电话", example = "13900000000")
    String phone;
    @ApiModelProperty(value = "图片验证码", example = "1111")
    String authCode;
    @ApiModelProperty(value = "短信验证码", example = "2222")
    String phoneCode;

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
                ", channelId='" + channelId + '\'' +
                '}';
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
