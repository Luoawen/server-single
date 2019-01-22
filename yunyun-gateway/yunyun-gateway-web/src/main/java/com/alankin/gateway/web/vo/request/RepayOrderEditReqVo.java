package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "RepayOrderEditReqVo", description = "还款单编辑请求Vo")
public class RepayOrderEditReqVo extends BaseReqVO {
    /**
     * uid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "uid")
    private Long uid;

    /**
     * 还款金额（分）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "还款金额分）")
    private Long repayMoney;

    /**
     * 借款单id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款单id")
    private Long loanReceiptId;

    /**
     * 还款日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "还款日期")
    private Integer repayTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "RepayOrderEditReqVo{" +
                "uid=" + uid +
                ", repayMoney=" + repayMoney +
                ", loanReceiptId=" + loanReceiptId +
                ", repayTime=" + repayTime +
                ", remark='" + remark + '\'' +
                '}';
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
