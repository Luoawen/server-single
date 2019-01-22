package com.alankin.gateway.web.vo.thirdReq;

import com.alankin.gateway.web.vo.request.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by alankin on 2018/12/29.
 */
@ApiModel(value = "CheckCodeReqVo", description = "运营商验证码请求Vo")
public class CheckCodeReqVo extends BaseSidReqVo {
    @ApiModelProperty(value = "验证码")
    private String checkcode;

    @Override
    public String toString() {
        return "CheckCodeReqVo{" +
                "checkcode='" + checkcode + '\'' +
                '}';
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
}
