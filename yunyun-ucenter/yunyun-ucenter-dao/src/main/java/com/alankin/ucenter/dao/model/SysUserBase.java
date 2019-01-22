package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class SysUserBase implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 1正常用户 2禁用
     *
     * @mbggenerated
     */
    private Byte userRole;

    /**
     * 注册来源：1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     *
     * @mbggenerated
     */
    private Byte registerSource;

    /**
     * 用户账号，必须唯一
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * 用户真实姓名
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * 用户昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 用户性别 0-female 1-male
     *
     * @mbggenerated
     */
    private Boolean gender;

    /**
     * 用户生日
     *
     * @mbggenerated
     */
    private Long birthday;

    /**
     * 用户个人签名
     *
     * @mbggenerated
     */
    private String signature;

    /**
     * 手机号码(唯一)
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 手机号码绑定时间
     *
     * @mbggenerated
     */
    private Integer mobileBindTime;

    /**
     * 邮箱(唯一)
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 邮箱绑定时间
     *
     * @mbggenerated
     */
    private Integer emailBindTime;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String face;

    /**
     * 头像 200x200x80
     *
     * @mbggenerated
     */
    private String face200;

    /**
     * 原图头像
     *
     * @mbggenerated
     */
    private String srcface;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Integer updateTime;

    /**
     * 用户设备push_token
     *
     * @mbggenerated
     */
    private String pushToken;

    /**
     * 0正常  1删除
     *
     * @mbggenerated
     */
    private Boolean isDel;

    /**
     * 微信号
     *
     * @mbggenerated
     */
    private String wchatId;

    /**
     * 微信二维码图片id
     *
     * @mbggenerated
     */
    private Long wchatQrcode;

    private static final long serialVersionUID = 1L;

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

    public Byte getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(Byte registerSource) {
        this.registerSource = registerSource;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getMobileBindTime() {
        return mobileBindTime;
    }

    public void setMobileBindTime(Integer mobileBindTime) {
        this.mobileBindTime = mobileBindTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailBindTime() {
        return emailBindTime;
    }

    public void setEmailBindTime(Integer emailBindTime) {
        this.emailBindTime = emailBindTime;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFace200() {
        return face200;
    }

    public void setFace200(String face200) {
        this.face200 = face200;
    }

    public String getSrcface() {
        return srcface;
    }

    public void setSrcface(String srcface) {
        this.srcface = srcface;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getWchatId() {
        return wchatId;
    }

    public void setWchatId(String wchatId) {
        this.wchatId = wchatId;
    }

    public Long getWchatQrcode() {
        return wchatQrcode;
    }

    public void setWchatQrcode(Long wchatQrcode) {
        this.wchatQrcode = wchatQrcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", userRole=").append(userRole);
        sb.append(", registerSource=").append(registerSource);
        sb.append(", userName=").append(userName);
        sb.append(", realName=").append(realName);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", signature=").append(signature);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileBindTime=").append(mobileBindTime);
        sb.append(", email=").append(email);
        sb.append(", emailBindTime=").append(emailBindTime);
        sb.append(", face=").append(face);
        sb.append(", face200=").append(face200);
        sb.append(", srcface=").append(srcface);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", pushToken=").append(pushToken);
        sb.append(", isDel=").append(isDel);
        sb.append(", wchatId=").append(wchatId);
        sb.append(", wchatQrcode=").append(wchatQrcode);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUserBase other = (SysUserBase) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getRegisterSource() == null ? other.getRegisterSource() == null : this.getRegisterSource().equals(other.getRegisterSource()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMobileBindTime() == null ? other.getMobileBindTime() == null : this.getMobileBindTime().equals(other.getMobileBindTime()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEmailBindTime() == null ? other.getEmailBindTime() == null : this.getEmailBindTime().equals(other.getEmailBindTime()))
            && (this.getFace() == null ? other.getFace() == null : this.getFace().equals(other.getFace()))
            && (this.getFace200() == null ? other.getFace200() == null : this.getFace200().equals(other.getFace200()))
            && (this.getSrcface() == null ? other.getSrcface() == null : this.getSrcface().equals(other.getSrcface()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPushToken() == null ? other.getPushToken() == null : this.getPushToken().equals(other.getPushToken()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getWchatId() == null ? other.getWchatId() == null : this.getWchatId().equals(other.getWchatId()))
            && (this.getWchatQrcode() == null ? other.getWchatQrcode() == null : this.getWchatQrcode().equals(other.getWchatQrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getRegisterSource() == null) ? 0 : getRegisterSource().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMobileBindTime() == null) ? 0 : getMobileBindTime().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEmailBindTime() == null) ? 0 : getEmailBindTime().hashCode());
        result = prime * result + ((getFace() == null) ? 0 : getFace().hashCode());
        result = prime * result + ((getFace200() == null) ? 0 : getFace200().hashCode());
        result = prime * result + ((getSrcface() == null) ? 0 : getSrcface().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPushToken() == null) ? 0 : getPushToken().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getWchatId() == null) ? 0 : getWchatId().hashCode());
        result = prime * result + ((getWchatQrcode() == null) ? 0 : getWchatQrcode().hashCode());
        return result;
    }
}