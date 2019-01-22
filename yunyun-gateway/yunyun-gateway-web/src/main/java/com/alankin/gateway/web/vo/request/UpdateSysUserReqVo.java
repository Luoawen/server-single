/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.alankin.gateway.web.vo.request;

import com.alankin.gateway.web.vo.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询视图基类
 * <p>
 *
 * @author alankin
 * @Date 2015年10月8日
 * @since 1.0
 */

@ApiModel(value = "UpdateSysUserReqVo", description = "UpdateSysUserReqVo")
public class UpdateSysUserReqVo extends BaseReqVO {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID", example = "uid")
    private Long uid;

    /**
     * 2正常用户 3禁言用户 4虚拟用户 5运营
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户状态", example = "2")
    private Byte userRole;

    /**
     * 用户真实姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户真实姓名", example = "张三")
    private String realName;

    /**
     * 用户账号，必须唯一
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户账号", example = "aaaa")
    private String userName;

    /**
     * 手机号码(唯一)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号码", example = "135666666")
    private String mobile;

    /**
     * 邮箱(唯一)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱", example = "47512255@qq.com")
    private String email;

    /**
     * 密码凭证(站内的保存密码，站外的不保存或保存token)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密码", example = "123")
    private String certificate;

    /**
     * 账号角色
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号角色", example = "2")
    private int role_id;

    @Override
    public String toString() {
        return "UpdateSysUserReqVo{" +
                "uid=" + uid +
                ", userRole=" + userRole +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", certificate='" + certificate + '\'' +
                ", role_id=" + role_id +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
