package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by alankin on 2019/1/19.
 */
@ApiModel(value = "CreateApplyOrderReqVo", description = "用户申请VO")
public class CreateApplyOrderReqVo extends BaseReqVO {
    @ApiModelProperty(value = "申请金额")
    Long applyMoney;
    @ApiModelProperty(value = "还款周期")
    Integer duration;

    public Long getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(Long applyMoney) {
        this.applyMoney = applyMoney;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
