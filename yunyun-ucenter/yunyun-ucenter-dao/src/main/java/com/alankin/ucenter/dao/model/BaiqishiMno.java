package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class BaiqishiMno implements Serializable {
    private Integer id;

    /**
     * 用户uid
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 通话号码
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 互联网标识
     *
     * @mbggenerated
     */
    private String mobileTag;

    /**
     * 互联网标识类型
     *
     * @mbggenerated
     */
    private String mobileTagType;

    /**
     * 金融标签
     *
     * @mbggenerated
     */
    private String financeTag;

    /**
     * 号码一级标签
     *
     * @mbggenerated
     */
    private String commonTagType;

    /**
     * 第一次联系时间
     *
     * @mbggenerated
     */
    private Long beginTime;

    /**
     * 最后一次联系时间
     *
     * @mbggenerated
     */
    private Long endTime;

    /**
     * 运营商类型
     *
     * @mbggenerated
     */
    private String monType;

    /**
     * 归属地
     *
     * @mbggenerated
     */
    private String belongTo;

    /**
     * 联系次数
     *
     * @mbggenerated
     */
    private Integer connectCount;

    /**
     * 联系时间（单位：秒）
     *
     * @mbggenerated
     */
    private Integer connectTime;

    /**
     * 主叫次数
     *
     * @mbggenerated
     */
    private Integer originatingCallCount;

    /**
     * 主叫时长（单位：秒）
     *
     * @mbggenerated
     */
    private Integer originatingTime;

    /**
     * 被叫次数
     *
     * @mbggenerated
     */
    private Integer terminatingCallCount;

    /**
     * 被叫时长（单位：秒）
     *
     * @mbggenerated
     */
    private Integer terminatingTime;

    /**
     * 其他通话类型次数
     *
     * @mbggenerated
     */
    private Integer otherTypeCallCount;

    /**
     * 其他通话类型时长(单位:秒)
     *
     * @mbggenerated
     */
    private Integer otherTypeCallTime;

    /**
     * 发送短信次数
     *
     * @mbggenerated
     */
    private Integer sendSmsCount;

    /**
     * 接收短信次数
     *
     * @mbggenerated
     */
    private Integer receiveSmsCount;

    /**
     * 1：3天 2:7天 3:一个月 4：三个月 5:六个月
     *
     * @mbggenerated
     */
    private Byte daysType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileTag() {
        return mobileTag;
    }

    public void setMobileTag(String mobileTag) {
        this.mobileTag = mobileTag;
    }

    public String getMobileTagType() {
        return mobileTagType;
    }

    public void setMobileTagType(String mobileTagType) {
        this.mobileTagType = mobileTagType;
    }

    public String getFinanceTag() {
        return financeTag;
    }

    public void setFinanceTag(String financeTag) {
        this.financeTag = financeTag;
    }

    public String getCommonTagType() {
        return commonTagType;
    }

    public void setCommonTagType(String commonTagType) {
        this.commonTagType = commonTagType;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getMonType() {
        return monType;
    }

    public void setMonType(String monType) {
        this.monType = monType;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public Integer getConnectCount() {
        return connectCount;
    }

    public void setConnectCount(Integer connectCount) {
        this.connectCount = connectCount;
    }

    public Integer getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Integer connectTime) {
        this.connectTime = connectTime;
    }

    public Integer getOriginatingCallCount() {
        return originatingCallCount;
    }

    public void setOriginatingCallCount(Integer originatingCallCount) {
        this.originatingCallCount = originatingCallCount;
    }

    public Integer getOriginatingTime() {
        return originatingTime;
    }

    public void setOriginatingTime(Integer originatingTime) {
        this.originatingTime = originatingTime;
    }

    public Integer getTerminatingCallCount() {
        return terminatingCallCount;
    }

    public void setTerminatingCallCount(Integer terminatingCallCount) {
        this.terminatingCallCount = terminatingCallCount;
    }

    public Integer getTerminatingTime() {
        return terminatingTime;
    }

    public void setTerminatingTime(Integer terminatingTime) {
        this.terminatingTime = terminatingTime;
    }

    public Integer getOtherTypeCallCount() {
        return otherTypeCallCount;
    }

    public void setOtherTypeCallCount(Integer otherTypeCallCount) {
        this.otherTypeCallCount = otherTypeCallCount;
    }

    public Integer getOtherTypeCallTime() {
        return otherTypeCallTime;
    }

    public void setOtherTypeCallTime(Integer otherTypeCallTime) {
        this.otherTypeCallTime = otherTypeCallTime;
    }

    public Integer getSendSmsCount() {
        return sendSmsCount;
    }

    public void setSendSmsCount(Integer sendSmsCount) {
        this.sendSmsCount = sendSmsCount;
    }

    public Integer getReceiveSmsCount() {
        return receiveSmsCount;
    }

    public void setReceiveSmsCount(Integer receiveSmsCount) {
        this.receiveSmsCount = receiveSmsCount;
    }

    public Byte getDaysType() {
        return daysType;
    }

    public void setDaysType(Byte daysType) {
        this.daysType = daysType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileTag=").append(mobileTag);
        sb.append(", mobileTagType=").append(mobileTagType);
        sb.append(", financeTag=").append(financeTag);
        sb.append(", commonTagType=").append(commonTagType);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", monType=").append(monType);
        sb.append(", belongTo=").append(belongTo);
        sb.append(", connectCount=").append(connectCount);
        sb.append(", connectTime=").append(connectTime);
        sb.append(", originatingCallCount=").append(originatingCallCount);
        sb.append(", originatingTime=").append(originatingTime);
        sb.append(", terminatingCallCount=").append(terminatingCallCount);
        sb.append(", terminatingTime=").append(terminatingTime);
        sb.append(", otherTypeCallCount=").append(otherTypeCallCount);
        sb.append(", otherTypeCallTime=").append(otherTypeCallTime);
        sb.append(", sendSmsCount=").append(sendSmsCount);
        sb.append(", receiveSmsCount=").append(receiveSmsCount);
        sb.append(", daysType=").append(daysType);
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
        BaiqishiMno other = (BaiqishiMno) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMobileTag() == null ? other.getMobileTag() == null : this.getMobileTag().equals(other.getMobileTag()))
            && (this.getMobileTagType() == null ? other.getMobileTagType() == null : this.getMobileTagType().equals(other.getMobileTagType()))
            && (this.getFinanceTag() == null ? other.getFinanceTag() == null : this.getFinanceTag().equals(other.getFinanceTag()))
            && (this.getCommonTagType() == null ? other.getCommonTagType() == null : this.getCommonTagType().equals(other.getCommonTagType()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getMonType() == null ? other.getMonType() == null : this.getMonType().equals(other.getMonType()))
            && (this.getBelongTo() == null ? other.getBelongTo() == null : this.getBelongTo().equals(other.getBelongTo()))
            && (this.getConnectCount() == null ? other.getConnectCount() == null : this.getConnectCount().equals(other.getConnectCount()))
            && (this.getConnectTime() == null ? other.getConnectTime() == null : this.getConnectTime().equals(other.getConnectTime()))
            && (this.getOriginatingCallCount() == null ? other.getOriginatingCallCount() == null : this.getOriginatingCallCount().equals(other.getOriginatingCallCount()))
            && (this.getOriginatingTime() == null ? other.getOriginatingTime() == null : this.getOriginatingTime().equals(other.getOriginatingTime()))
            && (this.getTerminatingCallCount() == null ? other.getTerminatingCallCount() == null : this.getTerminatingCallCount().equals(other.getTerminatingCallCount()))
            && (this.getTerminatingTime() == null ? other.getTerminatingTime() == null : this.getTerminatingTime().equals(other.getTerminatingTime()))
            && (this.getOtherTypeCallCount() == null ? other.getOtherTypeCallCount() == null : this.getOtherTypeCallCount().equals(other.getOtherTypeCallCount()))
            && (this.getOtherTypeCallTime() == null ? other.getOtherTypeCallTime() == null : this.getOtherTypeCallTime().equals(other.getOtherTypeCallTime()))
            && (this.getSendSmsCount() == null ? other.getSendSmsCount() == null : this.getSendSmsCount().equals(other.getSendSmsCount()))
            && (this.getReceiveSmsCount() == null ? other.getReceiveSmsCount() == null : this.getReceiveSmsCount().equals(other.getReceiveSmsCount()))
            && (this.getDaysType() == null ? other.getDaysType() == null : this.getDaysType().equals(other.getDaysType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMobileTag() == null) ? 0 : getMobileTag().hashCode());
        result = prime * result + ((getMobileTagType() == null) ? 0 : getMobileTagType().hashCode());
        result = prime * result + ((getFinanceTag() == null) ? 0 : getFinanceTag().hashCode());
        result = prime * result + ((getCommonTagType() == null) ? 0 : getCommonTagType().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getMonType() == null) ? 0 : getMonType().hashCode());
        result = prime * result + ((getBelongTo() == null) ? 0 : getBelongTo().hashCode());
        result = prime * result + ((getConnectCount() == null) ? 0 : getConnectCount().hashCode());
        result = prime * result + ((getConnectTime() == null) ? 0 : getConnectTime().hashCode());
        result = prime * result + ((getOriginatingCallCount() == null) ? 0 : getOriginatingCallCount().hashCode());
        result = prime * result + ((getOriginatingTime() == null) ? 0 : getOriginatingTime().hashCode());
        result = prime * result + ((getTerminatingCallCount() == null) ? 0 : getTerminatingCallCount().hashCode());
        result = prime * result + ((getTerminatingTime() == null) ? 0 : getTerminatingTime().hashCode());
        result = prime * result + ((getOtherTypeCallCount() == null) ? 0 : getOtherTypeCallCount().hashCode());
        result = prime * result + ((getOtherTypeCallTime() == null) ? 0 : getOtherTypeCallTime().hashCode());
        result = prime * result + ((getSendSmsCount() == null) ? 0 : getSendSmsCount().hashCode());
        result = prime * result + ((getReceiveSmsCount() == null) ? 0 : getReceiveSmsCount().hashCode());
        result = prime * result + ((getDaysType() == null) ? 0 : getDaysType().hashCode());
        return result;
    }
}