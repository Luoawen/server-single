package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class UserOtherAcount implements Serializable {
    private Long uid;

    private Long userUid;

    private String acount;

    private String acountPassword;

    /**
     * 账号类型（字典id）
     *
     * @mbggenerated
     */
    private Integer acountTypeKey;

    private Integer createTime;

    private Integer updateTime;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUserUid() {
        return userUid;
    }

    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getAcountPassword() {
        return acountPassword;
    }

    public void setAcountPassword(String acountPassword) {
        this.acountPassword = acountPassword;
    }

    public Integer getAcountTypeKey() {
        return acountTypeKey;
    }

    public void setAcountTypeKey(Integer acountTypeKey) {
        this.acountTypeKey = acountTypeKey;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", userUid=").append(userUid);
        sb.append(", acount=").append(acount);
        sb.append(", acountPassword=").append(acountPassword);
        sb.append(", acountTypeKey=").append(acountTypeKey);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        UserOtherAcount other = (UserOtherAcount) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserUid() == null ? other.getUserUid() == null : this.getUserUid().equals(other.getUserUid()))
            && (this.getAcount() == null ? other.getAcount() == null : this.getAcount().equals(other.getAcount()))
            && (this.getAcountPassword() == null ? other.getAcountPassword() == null : this.getAcountPassword().equals(other.getAcountPassword()))
            && (this.getAcountTypeKey() == null ? other.getAcountTypeKey() == null : this.getAcountTypeKey().equals(other.getAcountTypeKey()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserUid() == null) ? 0 : getUserUid().hashCode());
        result = prime * result + ((getAcount() == null) ? 0 : getAcount().hashCode());
        result = prime * result + ((getAcountPassword() == null) ? 0 : getAcountPassword().hashCode());
        result = prime * result + ((getAcountTypeKey() == null) ? 0 : getAcountTypeKey().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}