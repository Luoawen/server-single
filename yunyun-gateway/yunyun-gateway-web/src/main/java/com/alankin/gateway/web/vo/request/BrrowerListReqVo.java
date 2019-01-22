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
@ApiModel(value = "BrrowerListReqVo", description = "出借人列表请求Vo")
public class BrrowerListReqVo extends BaseReqVO {
    /**
     * 用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名")
    @WhereLike(dbFieldName = "user_name")
    private String userName;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户姓名")
    @WhereLike(dbFieldName = "real_name")
    private String realName;

    @Override
    public String toString() {
        return "BrrowerListReqVo{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
