package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "LoanEditReqVo", description = "借条编辑请求Vo")
public class LoanEditReqVo extends BaseReqVO {
    /**
     * 申请单id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单id")
    private Long applyOrderUid;

    /**
     * 借款单uid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款单uid")
    private Long uid;

    /**
     * 出借人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出借人id")
    private Long browerId;

    /**
     * 借款日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款日期")
    private Integer browerTime;

    /**
     * 还款日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "还款日期")
    private Integer repayTime;

    /**
     * 出借金额（分）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出借金额（分）")
    private Integer provideMoney;

    /**
     * 应还金额（分）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应还金额（分）")
    private Integer shouldRepayMoney;

    /**
     * 年利化率（字典id）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "年利化率（字典id）")
    private Long yearMoneyRateId;

    /**
     * 用途
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用途")
    private Long purposeId;

    /**
     * 状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Byte state;

    public Integer getShouldRepayMoney() {
        return shouldRepayMoney;
    }

    public void setShouldRepayMoney(Integer shouldRepayMoney) {
        this.shouldRepayMoney = shouldRepayMoney;
    }

    public Long getApplyOrderUid() {
        return applyOrderUid;
    }

    public void setApplyOrderUid(Long applyOrderUid) {
        this.applyOrderUid = applyOrderUid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LoanEditReqVo{" +
                "applyOrderUid=" + applyOrderUid +
                ", uid=" + uid +
                ", browerId=" + browerId +
                ", browerTime=" + browerTime +
                ", repayTime=" + repayTime +
                ", provideMoney=" + provideMoney +
                ", shouldRepayMoney=" + shouldRepayMoney +
                ", yearMoneyRateId=" + yearMoneyRateId +
                ", purposeId=" + purposeId +
                ", state=" + state +
                '}';
    }
}
