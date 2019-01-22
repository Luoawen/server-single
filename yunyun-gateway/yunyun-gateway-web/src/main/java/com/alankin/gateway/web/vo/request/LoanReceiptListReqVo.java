package com.alankin.gateway.web.vo.request;

import com.alankin.common.annotation.EndTime;
import com.alankin.common.annotation.StartTime;
import com.alankin.common.annotation.WhereEqual;
import com.alankin.common.annotation.WhereLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "LoanReceiptListReqVo", description = "借条列表请求Vo")
public class LoanReceiptListReqVo extends BaseReqVO {
    /**
     * 借款人uid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款人uid")
    private Long brrowerUid;

    /**
     * 借款人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款人姓名")
    @WhereLike(dbFieldName = "user_real_name")
    private String realName;

    /**
     * 借款人用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款人用户名")
    @WhereLike(dbFieldName = "user_name")
    private String userName;

    /**
     * 出借人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出借人姓名")
    @WhereLike(dbFieldName = "brrower_real_name")
    private String brrowerRealName;

    /**
     * 出借人用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出借人用户名")
    @WhereLike(dbFieldName = "brrower_user_name")
    private String brrowerUserName;

    /**
     * 借款单状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借款单状态")
    @WhereEqual()
    private String state;

    /**
     * 借条结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借条结束时间")
    @EndTime(dbFieldName = "lr.brower_time")
    private String receiptDateEndTime;

    /**
     * 借条开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借条开始时间")
    @StartTime(dbFieldName = "lr.brower_time")
    private String receiptDateStartTime;

    /**
     * 借条还款结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借条还款结束时间")
    @EndTime(dbFieldName = "lr.repay_time")
    private String repayDateEndTime;

    /**
     * 借条还款开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "借条还款开始时间")
    @StartTime(dbFieldName = "lr.repay_time")
    private String repayDateStartTime;

    @Override
    public String toString() {
        return "LoanReceiptListReqVo{" +
                "brrowerUid='" + brrowerUid + '\'' +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", brrowerRealName='" + brrowerRealName + '\'' +
                ", brrowerUserName='" + brrowerUserName + '\'' +
                ", state='" + state + '\'' +
                ", receiptDateEndTime='" + receiptDateEndTime + '\'' +
                ", receiptDateStartTime='" + receiptDateStartTime + '\'' +
                ", repayDateEndTime='" + repayDateEndTime + '\'' +
                ", repayDateStartTime='" + repayDateStartTime + '\'' +
                '}';
    }

    public Long getBrrowerUid() {
        return brrowerUid;
    }

    public void setBrrowerUid(Long brrowerUid) {
        this.brrowerUid = brrowerUid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBrrowerRealName() {
        return brrowerRealName;
    }

    public void setBrrowerRealName(String brrowerRealName) {
        this.brrowerRealName = brrowerRealName;
    }

    public String getBrrowerUserName() {
        return brrowerUserName;
    }

    public void setBrrowerUserName(String brrowerUserName) {
        this.brrowerUserName = brrowerUserName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReceiptDateEndTime() {
        return receiptDateEndTime;
    }

    public void setReceiptDateEndTime(String receiptDateEndTime) {
        this.receiptDateEndTime = receiptDateEndTime;
    }

    public String getReceiptDateStartTime() {
        return receiptDateStartTime;
    }

    public void setReceiptDateStartTime(String receiptDateStartTime) {
        this.receiptDateStartTime = receiptDateStartTime;
    }

    public String getRepayDateEndTime() {
        return repayDateEndTime;
    }

    public void setRepayDateEndTime(String repayDateEndTime) {
        this.repayDateEndTime = repayDateEndTime;
    }

    public String getRepayDateStartTime() {
        return repayDateStartTime;
    }

    public void setRepayDateStartTime(String repayDateStartTime) {
        this.repayDateStartTime = repayDateStartTime;
    }
}
