package com.alankin.gateway.web.vo.thirdReq;

import com.alankin.gateway.web.vo.request.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "OperateLoginReqVo", description = "运营商登录请求Vo")
public class OperateLoginReqVo extends BaseReqVO {
    @ApiModelProperty(value = "电话")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @Override
    public String toString() {
        return "OperateLoginReqVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
