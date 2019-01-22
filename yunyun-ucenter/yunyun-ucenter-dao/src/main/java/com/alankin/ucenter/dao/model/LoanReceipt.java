package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class LoanReceipt implements Serializable {
    /**
     * 借款单uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 申请单id
     *
     * @mbggenerated
     */
    private Long applyOrderUid;

    /**
     * 出借人id
     *
     * @mbggenerated
     */
    private Long browerId;

    /**
     * 借款日期
     *
     * @mbggenerated
     */
    private Integer browerTime;

    /**
     * 还款日期
     *
     * @mbggenerated
     */
    private Integer repayTime;

    /**
     * 出借金额（分）
     *
     * @mbggenerated
     */
    private Integer provideMoney;

    /**
     * 应还金额
     *
     * @mbggenerated
     */
    private Integer shouldRepayMoney;

    /**
     * 年利化率（字典id）
     *
     * @mbggenerated
     */
    private Long yearMoneyRateId;

    /**
     * 用途
     *
     * @mbggenerated
     */
    private Long purposeId;

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
     * 状态
     *
     * @mbggenerated
     */
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getApplyOrderUid() {
        return applyOrderUid;
    }

    public void setApplyOrderUid(Long applyOrderUid) {
        this.applyOrderUid = applyOrderUid;
    }

    public Long getBrowerId() {
        return browerId;
    }

    public void setBrowerId(Long browerId) {
        this.browerId = browerId;
    }

    public Integer getBrowerTime() {
        return browerTime;
    }

    public void setBrowerTime(Integer browerTime) {
        this.browerTime = browerTime;
    }

    public Integer getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(Integer repayTime) {
        this.repayTime = repayTime;
    }

    public Integer getProvideMoney() {
        return provideMoney;
    }

    public void setProvideMoney(Integer provideMoney) {
        this.provideMoney = provideMoney;
    }

    public Integer getShouldRepayMoney() {
        return shouldRepayMoney;
    }

    public void setShouldRepayMoney(Integer shouldRepayMoney) {
        this.shouldRepayMoney = shouldRepayMoney;
    }

    public Long getYearMoneyRateId() {
        return yearMoneyRateId;
    }

    public void setYearMoneyRateId(Long yearMoneyRateId) {
        this.yearMoneyRateId = yearMoneyRateId;
    }

    public Long getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Long purposeId) {
        this.purposeId = purposeId;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", applyOrderUid=").append(applyOrderUid);
        sb.append(", browerId=").append(browerId);
        sb.append(", browerTime=").append(browerTime);
        sb.append(", repayTime=").append(repayTime);
        sb.append(", provideMoney=").append(provideMoney);
        sb.append(", shouldRepayMoney=").append(shouldRepayMoney);
        sb.append(", yearMoneyRateId=").append(yearMoneyRateId);
        sb.append(", purposeId=").append(purposeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", state=").append(state);
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
        LoanReceipt other = (LoanReceipt) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getApplyOrderUid() == null ? other.getApplyOrderUid() == null : this.getApplyOrderUid().equals(other.getApplyOrderUid()))
            && (this.getBrowerId() == null ? other.getBrowerId() == null : this.getBrowerId().equals(other.getBrowerId()))
            && (this.getBrowerTime() == null ? other.getBrowerTime() == null : this.getBrowerTime().equals(other.getBrowerTime()))
            && (this.getRepayTime() == null ? other.getRepayTime() == null : this.getRepayTime().equals(other.getRepayTime()))
            && (this.getProvideMoney() == null ? other.getProvideMoney() == null : this.getProvideMoney().equals(other.getProvideMoney()))
            && (this.getShouldRepayMoney() == null ? other.getShouldRepayMoney() == null : this.getShouldRepayMoney().equals(other.getShouldRepayMoney()))
            && (this.getYearMoneyRateId() == null ? other.getYearMoneyRateId() == null : this.getYearMoneyRateId().equals(other.getYearMoneyRateId()))
            && (this.getPurposeId() == null ? other.getPurposeId() == null : this.getPurposeId().equals(other.getPurposeId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getApplyOrderUid() == null) ? 0 : getApplyOrderUid().hashCode());
        result = prime * result + ((getBrowerId() == null) ? 0 : getBrowerId().hashCode());
        result = prime * result + ((getBrowerTime() == null) ? 0 : getBrowerTime().hashCode());
        result = prime * result + ((getRepayTime() == null) ? 0 : getRepayTime().hashCode());
        result = prime * result + ((getProvideMoney() == null) ? 0 : getProvideMoney().hashCode());
        result = prime * result + ((getShouldRepayMoney() == null) ? 0 : getShouldRepayMoney().hashCode());
        result = prime * result + ((getYearMoneyRateId() == null) ? 0 : getYearMoneyRateId().hashCode());
        result = prime * result + ((getPurposeId() == null) ? 0 : getPurposeId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}