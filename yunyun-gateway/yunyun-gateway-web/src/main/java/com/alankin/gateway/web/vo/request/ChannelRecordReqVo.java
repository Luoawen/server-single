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
@ApiModel(value = "ChannelRecordReqVo", description = "渠道记录请求Vo")
public class ChannelRecordReqVo extends BaseReqVO {
    @WhereEqual
    @ApiModelProperty(hidden = true)
    private Long uid;
    /**
     * 统计结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统计结束时间")
    @EndTime(dbFieldName = "cr.create_time")
    private String recordDateEndTime;

    /**
     * 统计开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统计开始时间")
    @StartTime(dbFieldName = "cr.create_time")
    private String recordDateStartTime;

    @Override
    public String toString() {
        return "ChannelRecordReqVo{" +
                "uid=" + uid +
                ", recordDateEndTime='" + recordDateEndTime + '\'' +
                ", recordDateStartTime='" + recordDateStartTime + '\'' +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getRecordDateEndTime() {
        return recordDateEndTime;
    }

    public void setRecordDateEndTime(String recordDateEndTime) {
        this.recordDateEndTime = recordDateEndTime;
    }

    public String getRecordDateStartTime() {
        return recordDateStartTime;
    }

    public void setRecordDateStartTime(String recordDateStartTime) {
        this.recordDateStartTime = recordDateStartTime;
    }
}
