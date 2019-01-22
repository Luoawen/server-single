package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class UserOtherAuth implements Serializable {
    private Long id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 1淘宝 2为运营商
     *
     * @mbggenerated
     */
    private Byte identityType;

    /**
     * 手机号 邮箱 用户名或第三方应用的唯一标识
     *
     * @mbggenerated
     */
    private String identifier;

    /**
     * 密码凭证(站内的保存密码，站外的不保存或保存token)
     *
     * @mbggenerated
     */
    private String certificate;

    /**
     * 绑定时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * 更新绑定时间
     *
     * @mbggenerated
     */
    private Integer updateTime;

    /**
     * 三方数据
     *
     * @mbggenerated
     */
    private String thirdData;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Byte getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Byte identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public String getThirdData() {
        return thirdData;
    }

    public void setThirdData(String thirdData) {
        this.thirdData = thirdData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", identityType=").append(identityType);
        sb.append(", identifier=").append(identifier);
        sb.append(", certificate=").append(certificate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", thirdData=").append(thirdData);
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
        UserOtherAuth other = (UserOtherAuth) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getIdentityType() == null ? other.getIdentityType() == null : this.getIdentityType().equals(other.getIdentityType()))
            && (this.getIdentifier() == null ? other.getIdentifier() == null : this.getIdentifier().equals(other.getIdentifier()))
            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getThirdData() == null ? other.getThirdData() == null : this.getThirdData().equals(other.getThirdData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getIdentityType() == null) ? 0 : getIdentityType().hashCode());
        result = prime * result + ((getIdentifier() == null) ? 0 : getIdentifier().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getThirdData() == null) ? 0 : getThirdData().hashCode());
        return result;
    }
}