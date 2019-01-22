package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class ApplyStateLog implements Serializable {
    private Long uid;

    /**
     * 申请单uid
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 状态操作人id
     *
     * @mbggenerated
     */
    private Long sysUserId;

    /**
     * 原来状态
     *
     * @mbggenerated
     */
    private Integer lastState;

    /**
     * 现在状态
     *
     * @mbggenerated
     */
    private Integer nowState;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getLastState() {
        return lastState;
    }

    public void setLastState(Integer lastState) {
        this.lastState = lastState;
    }

    public Integer getNowState() {
        return nowState;
    }

    public void setNowState(Integer nowState) {
        this.nowState = nowState;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", orderId=").append(orderId);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", lastState=").append(lastState);
        sb.append(", nowState=").append(nowState);
        sb.append(", createTime=").append(createTime);
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
        ApplyStateLog other = (ApplyStateLog) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getLastState() == null ? other.getLastState() == null : this.getLastState().equals(other.getLastState()))
            && (this.getNowState() == null ? other.getNowState() == null : this.getNowState().equals(other.getNowState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getLastState() == null) ? 0 : getLastState().hashCode());
        result = prime * result + ((getNowState() == null) ? 0 : getNowState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}