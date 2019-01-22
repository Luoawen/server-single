package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class ApplyOrder implements Serializable {
    /**
     * 申请单id
     *
     * @mbggenerated
     */
    private Long uid;

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
     * 1审核中 2已放款 3拒绝受理 4已结清 5逾期  6失联 7已取消
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * 申请人id
     *
     * @mbggenerated
     */
    private Long applyUserUid;

    /**
     * 订单金额
     *
     * @mbggenerated
     */
    private Integer orderMoney;

    /**
     * 申请时长
     *
     * @mbggenerated
     */
    private Integer loanDuration;

    /**
     * 分配审核人id
     *
     * @mbggenerated
     */
    private Long verifyUserId;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getApplyUserUid() {
        return applyUserUid;
    }

    public void setApplyUserUid(Long applyUserUid) {
        this.applyUserUid = applyUserUid;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Long getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(Long verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", state=").append(state);
        sb.append(", applyUserUid=").append(applyUserUid);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", loanDuration=").append(loanDuration);
        sb.append(", verifyUserId=").append(verifyUserId);
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
        ApplyOrder other = (ApplyOrder) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getApplyUserUid() == null ? other.getApplyUserUid() == null : this.getApplyUserUid().equals(other.getApplyUserUid()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getLoanDuration() == null ? other.getLoanDuration() == null : this.getLoanDuration().equals(other.getLoanDuration()))
            && (this.getVerifyUserId() == null ? other.getVerifyUserId() == null : this.getVerifyUserId().equals(other.getVerifyUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getApplyUserUid() == null) ? 0 : getApplyUserUid().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getLoanDuration() == null) ? 0 : getLoanDuration().hashCode());
        result = prime * result + ((getVerifyUserId() == null) ? 0 : getVerifyUserId().hashCode());
        return result;
    }
}