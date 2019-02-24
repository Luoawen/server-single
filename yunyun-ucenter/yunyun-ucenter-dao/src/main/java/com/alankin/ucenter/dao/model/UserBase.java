package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class UserBase implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 1正常用户 2封号用户
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
     * 用户昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    private String userRealName;

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
     * 身份证号
     *
     * @mbggenerated
     */
    private String idCard;

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
     * 微信号
     *
     * @mbggenerated
     */
    private String wchatId;

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
     * 身份证正面照片
     *
     * @mbggenerated
     */
    private Long idCardPhoto1;

    /**
     * 身份证背面照片
     *
     * @mbggenerated
     */
    private Long idCardPhoto2;

    /**
     * 手持身份证照片
     *
     * @mbggenerated
     */
    private Long idCardPhoto3;

    /**
     * 公司名称
     *
     * @mbggenerated
     */
    private String companyName;

    /**
     * 公司地址
     *
     * @mbggenerated
     */
    private Long companyLocationUid;

    /**
     * 公司联系方式
     *
     * @mbggenerated
     */
    private String companyPhone;

    /**
     * 公司职位
     *
     * @mbggenerated
     */
    private String companyJob;

    /**
     * 工资
     *
     * @mbggenerated
     */
    private Integer salary;

    /**
     * 芝麻分
     *
     * @mbggenerated
     */
    private Integer aliScore;

    /**
     * 用户设备push_token
     *
     * @mbggenerated
     */
    private String pushToken;

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
     * 0正常 1删除
     *
     * @mbggenerated
     */
    private Boolean isDel;

    /**
     * 引流渠道id
     *
     * @mbggenerated
     */
    private Long channelId;

    /**
     * 申请人分配状态（字典）1分配审核人 2未分配
     *
     * @mbggenerated
     */
    private Integer distributStateKey;

    /**
     * 申请人审核状态 1未通过  2已通过审核
     *
     * @mbggenerated
     */
    private Integer verifyStateKey;

    /**
     * 审核时间
     *
     * @mbggenerated
     */
    private Integer verifyStateTime;

    /**
     * 分配审核人uid
     *
     * @mbggenerated
     */
    private Long verifyUid;

    /**
     * 出借人uid
     *
     * @mbggenerated
     */
    private Long browerUid;

    /**
     * 白骑士运营商认证， 0为未认证   1为已认证
     *
     * @mbggenerated
     */
    private Integer operateBaiqishiState;

    private Integer taobaoBaiqishiState;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getWchatId() {
        return wchatId;
    }

    public void setWchatId(String wchatId) {
        this.wchatId = wchatId;
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

    public Long getIdCardPhoto1() {
        return idCardPhoto1;
    }

    public void setIdCardPhoto1(Long idCardPhoto1) {
        this.idCardPhoto1 = idCardPhoto1;
    }

    public Long getIdCardPhoto2() {
        return idCardPhoto2;
    }

    public void setIdCardPhoto2(Long idCardPhoto2) {
        this.idCardPhoto2 = idCardPhoto2;
    }

    public Long getIdCardPhoto3() {
        return idCardPhoto3;
    }

    public void setIdCardPhoto3(Long idCardPhoto3) {
        this.idCardPhoto3 = idCardPhoto3;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyLocationUid() {
        return companyLocationUid;
    }

    public void setCompanyLocationUid(Long companyLocationUid) {
        this.companyLocationUid = companyLocationUid;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyJob() {
        return companyJob;
    }

    public void setCompanyJob(String companyJob) {
        this.companyJob = companyJob;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAliScore() {
        return aliScore;
    }

    public void setAliScore(Integer aliScore) {
        this.aliScore = aliScore;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getDistributStateKey() {
        return distributStateKey;
    }

    public void setDistributStateKey(Integer distributStateKey) {
        this.distributStateKey = distributStateKey;
    }

    public Integer getVerifyStateKey() {
        return verifyStateKey;
    }

    public void setVerifyStateKey(Integer verifyStateKey) {
        this.verifyStateKey = verifyStateKey;
    }

    public Integer getVerifyStateTime() {
        return verifyStateTime;
    }

    public void setVerifyStateTime(Integer verifyStateTime) {
        this.verifyStateTime = verifyStateTime;
    }

    public Long getVerifyUid() {
        return verifyUid;
    }

    public void setVerifyUid(Long verifyUid) {
        this.verifyUid = verifyUid;
    }

    public Long getBrowerUid() {
        return browerUid;
    }

    public void setBrowerUid(Long browerUid) {
        this.browerUid = browerUid;
    }

    public Integer getOperateBaiqishiState() {
        return operateBaiqishiState;
    }

    public void setOperateBaiqishiState(Integer operateBaiqishiState) {
        this.operateBaiqishiState = operateBaiqishiState;
    }

    public Integer getTaobaoBaiqishiState() {
        return taobaoBaiqishiState;
    }

    public void setTaobaoBaiqishiState(Integer taobaoBaiqishiState) {
        this.taobaoBaiqishiState = taobaoBaiqishiState;
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
        sb.append(", nickName=").append(nickName);
        sb.append(", userRealName=").append(userRealName);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", idCard=").append(idCard);
        sb.append(", signature=").append(signature);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileBindTime=").append(mobileBindTime);
        sb.append(", email=").append(email);
        sb.append(", emailBindTime=").append(emailBindTime);
        sb.append(", wchatId=").append(wchatId);
        sb.append(", face=").append(face);
        sb.append(", face200=").append(face200);
        sb.append(", srcface=").append(srcface);
        sb.append(", idCardPhoto1=").append(idCardPhoto1);
        sb.append(", idCardPhoto2=").append(idCardPhoto2);
        sb.append(", idCardPhoto3=").append(idCardPhoto3);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyLocationUid=").append(companyLocationUid);
        sb.append(", companyPhone=").append(companyPhone);
        sb.append(", companyJob=").append(companyJob);
        sb.append(", salary=").append(salary);
        sb.append(", aliScore=").append(aliScore);
        sb.append(", pushToken=").append(pushToken);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", channelId=").append(channelId);
        sb.append(", distributStateKey=").append(distributStateKey);
        sb.append(", verifyStateKey=").append(verifyStateKey);
        sb.append(", verifyStateTime=").append(verifyStateTime);
        sb.append(", verifyUid=").append(verifyUid);
        sb.append(", browerUid=").append(browerUid);
        sb.append(", operateBaiqishiState=").append(operateBaiqishiState);
        sb.append(", taobaoBaiqishiState=").append(taobaoBaiqishiState);
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
        UserBase other = (UserBase) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getRegisterSource() == null ? other.getRegisterSource() == null : this.getRegisterSource().equals(other.getRegisterSource()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getUserRealName() == null ? other.getUserRealName() == null : this.getUserRealName().equals(other.getUserRealName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMobileBindTime() == null ? other.getMobileBindTime() == null : this.getMobileBindTime().equals(other.getMobileBindTime()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEmailBindTime() == null ? other.getEmailBindTime() == null : this.getEmailBindTime().equals(other.getEmailBindTime()))
            && (this.getWchatId() == null ? other.getWchatId() == null : this.getWchatId().equals(other.getWchatId()))
            && (this.getFace() == null ? other.getFace() == null : this.getFace().equals(other.getFace()))
            && (this.getFace200() == null ? other.getFace200() == null : this.getFace200().equals(other.getFace200()))
            && (this.getSrcface() == null ? other.getSrcface() == null : this.getSrcface().equals(other.getSrcface()))
            && (this.getIdCardPhoto1() == null ? other.getIdCardPhoto1() == null : this.getIdCardPhoto1().equals(other.getIdCardPhoto1()))
            && (this.getIdCardPhoto2() == null ? other.getIdCardPhoto2() == null : this.getIdCardPhoto2().equals(other.getIdCardPhoto2()))
            && (this.getIdCardPhoto3() == null ? other.getIdCardPhoto3() == null : this.getIdCardPhoto3().equals(other.getIdCardPhoto3()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyLocationUid() == null ? other.getCompanyLocationUid() == null : this.getCompanyLocationUid().equals(other.getCompanyLocationUid()))
            && (this.getCompanyPhone() == null ? other.getCompanyPhone() == null : this.getCompanyPhone().equals(other.getCompanyPhone()))
            && (this.getCompanyJob() == null ? other.getCompanyJob() == null : this.getCompanyJob().equals(other.getCompanyJob()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getAliScore() == null ? other.getAliScore() == null : this.getAliScore().equals(other.getAliScore()))
            && (this.getPushToken() == null ? other.getPushToken() == null : this.getPushToken().equals(other.getPushToken()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getDistributStateKey() == null ? other.getDistributStateKey() == null : this.getDistributStateKey().equals(other.getDistributStateKey()))
            && (this.getVerifyStateKey() == null ? other.getVerifyStateKey() == null : this.getVerifyStateKey().equals(other.getVerifyStateKey()))
            && (this.getVerifyStateTime() == null ? other.getVerifyStateTime() == null : this.getVerifyStateTime().equals(other.getVerifyStateTime()))
            && (this.getVerifyUid() == null ? other.getVerifyUid() == null : this.getVerifyUid().equals(other.getVerifyUid()))
            && (this.getBrowerUid() == null ? other.getBrowerUid() == null : this.getBrowerUid().equals(other.getBrowerUid()))
            && (this.getOperateBaiqishiState() == null ? other.getOperateBaiqishiState() == null : this.getOperateBaiqishiState().equals(other.getOperateBaiqishiState()))
            && (this.getTaobaoBaiqishiState() == null ? other.getTaobaoBaiqishiState() == null : this.getTaobaoBaiqishiState().equals(other.getTaobaoBaiqishiState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getRegisterSource() == null) ? 0 : getRegisterSource().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getUserRealName() == null) ? 0 : getUserRealName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMobileBindTime() == null) ? 0 : getMobileBindTime().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEmailBindTime() == null) ? 0 : getEmailBindTime().hashCode());
        result = prime * result + ((getWchatId() == null) ? 0 : getWchatId().hashCode());
        result = prime * result + ((getFace() == null) ? 0 : getFace().hashCode());
        result = prime * result + ((getFace200() == null) ? 0 : getFace200().hashCode());
        result = prime * result + ((getSrcface() == null) ? 0 : getSrcface().hashCode());
        result = prime * result + ((getIdCardPhoto1() == null) ? 0 : getIdCardPhoto1().hashCode());
        result = prime * result + ((getIdCardPhoto2() == null) ? 0 : getIdCardPhoto2().hashCode());
        result = prime * result + ((getIdCardPhoto3() == null) ? 0 : getIdCardPhoto3().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyLocationUid() == null) ? 0 : getCompanyLocationUid().hashCode());
        result = prime * result + ((getCompanyPhone() == null) ? 0 : getCompanyPhone().hashCode());
        result = prime * result + ((getCompanyJob() == null) ? 0 : getCompanyJob().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getAliScore() == null) ? 0 : getAliScore().hashCode());
        result = prime * result + ((getPushToken() == null) ? 0 : getPushToken().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getDistributStateKey() == null) ? 0 : getDistributStateKey().hashCode());
        result = prime * result + ((getVerifyStateKey() == null) ? 0 : getVerifyStateKey().hashCode());
        result = prime * result + ((getVerifyStateTime() == null) ? 0 : getVerifyStateTime().hashCode());
        result = prime * result + ((getVerifyUid() == null) ? 0 : getVerifyUid().hashCode());
        result = prime * result + ((getBrowerUid() == null) ? 0 : getBrowerUid().hashCode());
        result = prime * result + ((getOperateBaiqishiState() == null) ? 0 : getOperateBaiqishiState().hashCode());
        result = prime * result + ((getTaobaoBaiqishiState() == null) ? 0 : getTaobaoBaiqishiState().hashCode());
        return result;
    }
}