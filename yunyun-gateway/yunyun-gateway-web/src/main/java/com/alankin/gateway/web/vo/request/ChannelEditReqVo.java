package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "ChannelEditReqVo", description = "渠道编辑请求Vo")
public class ChannelEditReqVo extends BaseReqVO {
    @ApiModelProperty(value = "渠道id")
    private String id;

    @ApiModelProperty(value = "渠道状态")
    private String state;

    @ApiModelProperty(value = "渠道名称")
    private String channelName;

    @ApiModelProperty(value = "广告商uid")
    private String adUid;

    @ApiModelProperty(value = "审核人uid")
    private String verifyUid;

    @ApiModelProperty(value = "logoId")
    private String logoId;

    @ApiModelProperty(value = "welcomeBgId")
    private String welcomeBgId;

    @Override
    public String toString() {
        return "ChannelEditReqVo{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", channelName='" + channelName + '\'' +
                ", adUid='" + adUid + '\'' +
                ", verifyUid='" + verifyUid + '\'' +
                ", logoId='" + logoId + '\'' +
                ", welcomeBgId='" + welcomeBgId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAdUid() {
        return adUid;
    }

    public void setAdUid(String adUid) {
        this.adUid = adUid;
    }

    public String getVerifyUid() {
        return verifyUid;
    }

    public void setVerifyUid(String verifyUid) {
        this.verifyUid = verifyUid;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public String getWelcomeBgId() {
        return welcomeBgId;
    }

    public void setWelcomeBgId(String welcomeBgId) {
        this.welcomeBgId = welcomeBgId;
    }
}
