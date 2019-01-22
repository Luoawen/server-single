package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "EmergencyReqVo", description = "紧急联系人请求Vo")
public class EmergencyReqVo extends BaseReqVO {
    @ApiModelProperty(value = "联系人姓名")
    private String contactName;
    @ApiModelProperty(value = "联系人电话")
    private String contactMobile;

    /**
     * 联系人类型（字典id）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人类型")
    private Integer acountTypeKey;

    @Override
    public String toString() {
        return "EmergencyReqVo{" +
                "contactName='" + contactName + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", acountTypeKey=" + acountTypeKey +
                '}';
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getAcountTypeKey() {
        return acountTypeKey;
    }

    public void setAcountTypeKey(Integer acountTypeKey) {
        this.acountTypeKey = acountTypeKey;
    }
}
