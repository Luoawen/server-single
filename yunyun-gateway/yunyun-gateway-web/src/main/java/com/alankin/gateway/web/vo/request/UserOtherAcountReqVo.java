package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "UserOtherAcountReqVo", description = "其他平台账号请求Vo")
public class UserOtherAcountReqVo extends BaseReqVO {

    /**
     * 账号类型（字典id）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号类型")
    private Integer acountTypeKey;

    @ApiModelProperty(value = "账号")
    private String acount;

    @ApiModelProperty(value = "账号密码")
    private String acountPassword;

    @Override
    public String toString() {
        return "UserOtherAcountReqVo{" +
                "acountTypeKey=" + acountTypeKey +
                ", acount='" + acount + '\'' +
                ", acountPassword='" + acountPassword + '\'' +
                '}';
    }

    public Integer getAcountTypeKey() {
        return acountTypeKey;
    }

    public void setAcountTypeKey(Integer acountTypeKey) {
        this.acountTypeKey = acountTypeKey;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getAcountPassword() {
        return acountPassword;
    }

    public void setAcountPassword(String acountPassword) {
        this.acountPassword = acountPassword;
    }
}
