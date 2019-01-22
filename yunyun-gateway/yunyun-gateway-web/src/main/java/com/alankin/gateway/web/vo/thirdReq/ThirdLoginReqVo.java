package com.alankin.gateway.web.vo.thirdReq;

import com.alankin.gateway.web.vo.request.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "ThirdLoginReqVo", description = "三方登录请求Vo")
public class ThirdLoginReqVo extends BaseReqVO {
    @ApiModelProperty(value = "电话")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;

    @Override
    public String toString() {
        return "ThirdLoginReqVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
