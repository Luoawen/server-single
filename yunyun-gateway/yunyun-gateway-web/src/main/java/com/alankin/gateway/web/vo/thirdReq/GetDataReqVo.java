package com.alankin.gateway.web.vo.thirdReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "CheckCodeReqVo", description = "运营商验证码请求Vo")
public class GetDataReqVo extends BaseSidReqVo {
    @ApiModelProperty(value = "电话")
    private String username;

    @Override
    public String toString() {
        return "GetDataReqVo{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
