package com.alankin.gateway.web.vo.request;

import com.alankin.common.annotation.EndTime;
import com.alankin.common.annotation.StartTime;
import com.alankin.common.annotation.WhereEqual;
import com.alankin.common.annotation.WhereLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "ApplyOrderReqVo", description = "申请单请求Vo")
public class ApplyOrderReqVo extends BaseReqVO {
    @WhereEqual
    @ApiModelProperty(hidden = true)
    private Long uid;
    /**
     * 申请开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请结束时间")
    @EndTime(dbFieldName = "create_time")
    private String applyDateEndTime;

    /**
     * 申请结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请开始时间")
    @StartTime(dbFieldName = "create_time")
    private String applyDateStartTime;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道id")
    @WhereEqual(dbFieldName = "channel_id")
    private String channelId;

    /**
     * 分配状态
     *
     * @mbggenerated
     */
//    @ApiModelProperty(value = "分配状态")
//    @WhereEqual(dbFieldName = "distribut_state")
//    private String distributState;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    @WhereLike(dbFieldName = "user_real_name")
    private String name;

    /**
     * 手机号码(唯一)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号码")
    @WhereLike(dbFieldName = "mobile")
    private String mobile;

    /**
     * 申请单状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单状态")
    @WhereEqual()
    private String state;

    /**
     * 申请单审核结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单审核结束时间")
    @EndTime(dbFieldName = "verify_time")
    private String verifyDateEndTime;

    /**
     * 申请单审核开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单审核开始时间")
    @StartTime(dbFieldName = "verify_time")
    private String verifyDateStartTime;

    @Override
    public String toString() {
        return "ApplyOrderReqVo{" +
                "uid=" + uid +
                ", applyDateEndTime='" + applyDateEndTime + '\'' +
                ", applyDateStartTime='" + applyDateStartTime + '\'' +
                ", channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", state='" + state + '\'' +
                ", verifyDateEndTime='" + verifyDateEndTime + '\'' +
                ", verifyDateStartTime='" + verifyDateStartTime + '\'' +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getApplyDateEndTime() {
        return applyDateEndTime;
    }

    public void setApplyDateEndTime(String applyDateEndTime) {
        this.applyDateEndTime = applyDateEndTime;
    }

    public String getApplyDateStartTime() {
        return applyDateStartTime;
    }

    public void setApplyDateStartTime(String applyDateStartTime) {
        this.applyDateStartTime = applyDateStartTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVerifyDateEndTime() {
        return verifyDateEndTime;
    }

    public void setVerifyDateEndTime(String verifyDateEndTime) {
        this.verifyDateEndTime = verifyDateEndTime;
    }

    public String getVerifyDateStartTime() {
        return verifyDateStartTime;
    }

    public void setVerifyDateStartTime(String verifyDateStartTime) {
        this.verifyDateStartTime = verifyDateStartTime;
    }
}
