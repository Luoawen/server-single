package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "ChannelAcountEditReqVo", description = "渠道账号编辑请求Vo")
public class ChannelAcountEditReqVo extends BaseReqVO {
    @ApiModelProperty(value = "uid")
    private String uid;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "账号状态")
    private String userRole;

    @ApiModelProperty(value = "账号密码")
    private String password;

    @Override
    public String toString() {
        return "ChannelAcountEditReqVo{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
