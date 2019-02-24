package com.alankin.gateway.web.vo.request;

import com.alankin.common.annotation.EndTime;
import com.alankin.common.annotation.StartTime;
import com.alankin.common.annotation.WhereEqual;
import com.alankin.common.annotation.WhereLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by alankin on 2019/1/6.
 */
@ApiModel(value = "CusUserListReqVo", description = "用户列表业务请求Vo")
public class CusUserListReqVo extends BaseReqVO {
    /**
     * 注册结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "注册结束时间")
    @EndTime(dbFieldName = "ub.create_time")
    private String registerDateEndTime;

    /**
     * 注册开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "注册开始时间")
    @StartTime(dbFieldName = "ub.create_time")
    private String registerDateStartTime;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道id")
    @WhereEqual(dbFieldName = "ub.channel_id")
    private String channelId;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    @WhereLike(dbFieldName = "ub.user_real_name")
    private String name;

    /**
     * 手机号码(唯一)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号码")
    @WhereLike(dbFieldName = "ub.mobile")
    private String mobile;

    /**
     * 审核状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核状态")
    @EndTime(dbFieldName = "ub.verify_state_key")
    private String verifyStateKey;

    /**
     * 审核人uid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核人uid")
    @WhereLike(dbFieldName = "ub.verify_uid")
    private Long verifyUid;

    @Override
    public String toString() {
        return "CusUserListReqVo{" +
                "registerDateEndTime='" + registerDateEndTime + '\'' +
                ", registerDateStartTime='" + registerDateStartTime + '\'' +
                ", channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getVerifyStateKey() {
        return verifyStateKey;
    }

    public void setVerifyStateKey(String verifyStateKey) {
        this.verifyStateKey = verifyStateKey;
    }

    public Long getVerifyUid() {
        return verifyUid;
    }

    public void setVerifyUid(Long verifyUid) {
        this.verifyUid = verifyUid;
    }

    public String getRegisterDateEndTime() {
        return registerDateEndTime;
    }

    public void setRegisterDateEndTime(String registerDateEndTime) {
        this.registerDateEndTime = registerDateEndTime;
    }

    public String getRegisterDateStartTime() {
        return registerDateStartTime;
    }

    public void setRegisterDateStartTime(String registerDateStartTime) {
        this.registerDateStartTime = registerDateStartTime;
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
}
