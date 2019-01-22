package com.alankin.gateway.web.vo.request;

import com.alankin.ucenter.dao.model.DataDic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alankin on 2019/1/19.
 */
@ApiModel(value = "UpdateApplySettingReqVo", description = "修改申请单设置VO")
public class UpdateApplySettingReqVo extends BaseReqVO {
    @ApiModelProperty(value = "最小申请金额")
    Long min;
    @ApiModelProperty(value = "最大申请金额")
    Long max;
    @ApiModelProperty(value = "周期数组")
    List<Integer> durationList;

    @Override
    public String toString() {
        return "UpdateApplySettingReqVo{" +
                "min=" + min +
                ", max=" + max +
                ", durationList=" + durationList +
                '}';
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public List<Integer> getDurationList() {
        return durationList;
    }

    public void setDurationList(List<Integer> durationList) {
        this.durationList = durationList;
    }
}
