package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class RepayOrder implements Serializable {
    /**
     * uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 还款金额（分）
     *
     * @mbggenerated
     */
    private Long repayMoney;

    /**
     * 借款单id
     *
     * @mbggenerated
     */
    private Long loanReceiptId;

    /**
     * 还款日期
     *
     * @mbggenerated
     */
    private Integer repayTime;

    /**
     * 创建日期（还款日期）
     *
     * @mbggenerated
     */
    private Integer createTime;

    private Integer updateTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRepayMoney() {
        return repayMoney;
    }

    public void setRepayMoney(Long repayMoney) {
        this.repayMoney = repayMoney;
    }

    public Long getLoanReceiptId() {
        return loanReceiptId;
    }

    public void setLoanReceiptId(Long loanReceiptId) {
        this.loanReceiptId = loanReceiptId;
    }

    public Integer getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(Integer repayTime) {
        this.repayTime = repayTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", repayMoney=").append(repayMoney);
        sb.append(", loanReceiptId=").append(loanReceiptId);
        sb.append(", repayTime=").append(repayTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
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
        RepayOrder other = (RepayOrder) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRepayMoney() == null ? other.getRepayMoney() == null : this.getRepayMoney().equals(other.getRepayMoney()))
            && (this.getLoanReceiptId() == null ? other.getLoanReceiptId() == null : this.getLoanReceiptId().equals(other.getLoanReceiptId()))
            && (this.getRepayTime() == null ? other.getRepayTime() == null : this.getRepayTime().equals(other.getRepayTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRepayMoney() == null) ? 0 : getRepayMoney().hashCode());
        result = prime * result + ((getLoanReceiptId() == null) ? 0 : getLoanReceiptId().hashCode());
        result = prime * result + ((getRepayTime() == null) ? 0 : getRepayTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}