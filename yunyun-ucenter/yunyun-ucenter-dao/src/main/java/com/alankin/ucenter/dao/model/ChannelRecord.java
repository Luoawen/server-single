package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class ChannelRecord implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private Long channelId;

    /**
     * 广告商id
     *
     * @mbggenerated
     */
    private Long sysUserId;

    /**
     * 注册人数
     *
     * @mbggenerated
     */
    private Integer registerCount;

    /**
     * 进件数
     *
     * @mbggenerated
     */
    private Integer inCount;

    /**
     * 审核数
     *
     * @mbggenerated
     */
    private Integer verifyCount;

    /**
     * 放款数
     *
     * @mbggenerated
     */
    private Integer provideCount;

    /**
     * 绑定时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Integer updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }

    public Integer getInCount() {
        return inCount;
    }

    public void setInCount(Integer inCount) {
        this.inCount = inCount;
    }

    public Integer getVerifyCount() {
        return verifyCount;
    }

    public void setVerifyCount(Integer verifyCount) {
        this.verifyCount = verifyCount;
    }

    public Integer getProvideCount() {
        return provideCount;
    }

    public void setProvideCount(Integer provideCount) {
        this.provideCount = provideCount;
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
        sb.append(", id=").append(id);
        sb.append(", channelId=").append(channelId);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", registerCount=").append(registerCount);
        sb.append(", inCount=").append(inCount);
        sb.append(", verifyCount=").append(verifyCount);
        sb.append(", provideCount=").append(provideCount);
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
        ChannelRecord other = (ChannelRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getRegisterCount() == null ? other.getRegisterCount() == null : this.getRegisterCount().equals(other.getRegisterCount()))
            && (this.getInCount() == null ? other.getInCount() == null : this.getInCount().equals(other.getInCount()))
            && (this.getVerifyCount() == null ? other.getVerifyCount() == null : this.getVerifyCount().equals(other.getVerifyCount()))
            && (this.getProvideCount() == null ? other.getProvideCount() == null : this.getProvideCount().equals(other.getProvideCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getRegisterCount() == null) ? 0 : getRegisterCount().hashCode());
        result = prime * result + ((getInCount() == null) ? 0 : getInCount().hashCode());
        result = prime * result + ((getVerifyCount() == null) ? 0 : getVerifyCount().hashCode());
        result = prime * result + ((getProvideCount() == null) ? 0 : getProvideCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}