package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class Channel implements Serializable {
    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    private String channelName;

    /**
     * 负责人
     *
     * @mbggenerated
     */
    private Long responsibleUserId;

    /**
     * 审核人
     *
     * @mbggenerated
     */
    private Long verifyUserId;

    /**
     * 状态 1正常 2禁用 
     *
     * @mbggenerated
     */
    private Byte state;

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
     * logo
     *
     * @mbggenerated
     */
    private Long logoId;

    /**
     * 欢迎页背景
     *
     * @mbggenerated
     */
    private Long welcomeBgId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(Long responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public Long getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(Long verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Long getLogoId() {
        return logoId;
    }

    public void setLogoId(Long logoId) {
        this.logoId = logoId;
    }

    public Long getWelcomeBgId() {
        return welcomeBgId;
    }

    public void setWelcomeBgId(Long welcomeBgId) {
        this.welcomeBgId = welcomeBgId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelName=").append(channelName);
        sb.append(", responsibleUserId=").append(responsibleUserId);
        sb.append(", verifyUserId=").append(verifyUserId);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", logoId=").append(logoId);
        sb.append(", welcomeBgId=").append(welcomeBgId);
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
        Channel other = (Channel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
            && (this.getResponsibleUserId() == null ? other.getResponsibleUserId() == null : this.getResponsibleUserId().equals(other.getResponsibleUserId()))
            && (this.getVerifyUserId() == null ? other.getVerifyUserId() == null : this.getVerifyUserId().equals(other.getVerifyUserId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getLogoId() == null ? other.getLogoId() == null : this.getLogoId().equals(other.getLogoId()))
            && (this.getWelcomeBgId() == null ? other.getWelcomeBgId() == null : this.getWelcomeBgId().equals(other.getWelcomeBgId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getResponsibleUserId() == null) ? 0 : getResponsibleUserId().hashCode());
        result = prime * result + ((getVerifyUserId() == null) ? 0 : getVerifyUserId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getLogoId() == null) ? 0 : getLogoId().hashCode());
        result = prime * result + ((getWelcomeBgId() == null) ? 0 : getWelcomeBgId().hashCode());
        return result;
    }
}