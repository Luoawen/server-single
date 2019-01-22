package com.alankin.gateway.web.vo.thirdReq;

import com.alankin.gateway.web.vo.request.BaseReqVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by alankin on 2019/1/16.
 */
public class MutiReqVo extends BaseReqVO {
    @ApiModelProperty(value = "身份证号")
    private String idNo;

    @ApiModelProperty(value = "姓名")
    private String name;

    @Override
    public String toString() {
        return "MutiReqVo{" +
                "idNo='" + idNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
