package com.alankin.gateway.web.vo.request;

import com.alankin.common.annotation.WhereLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "ChannelAcountListReqVo", description = "渠道账号列表请求Vo")
public class ChannelAcountListReqVo extends BaseReqVO {
    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    @WhereLike(dbFieldName = "real_name")
    private String realName;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名")
    @WhereLike(dbFieldName = "user_name")
    private String userName;

    @Override
    public String toString() {
        return "ChannelAcountListReqVo{" +
                "realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
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
}
