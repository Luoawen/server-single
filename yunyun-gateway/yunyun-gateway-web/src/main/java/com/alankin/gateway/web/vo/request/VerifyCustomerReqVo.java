package com.alankin.gateway.web.vo.request;

import com.alankin.gateway.web.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by alankin on 2019/1/19.
 */
@ApiModel(value = "VerifyCustomerReqVo", description = "审核申请人VO")
public class VerifyCustomerReqVo extends BaseReqVO {
    @ApiModelProperty(value = "申请人uid")
    Long userUid;
    @ApiModelProperty(value = "图片验证码")
    Long browerUid;
    @ApiModelProperty(value = "审核状态dict_key", example = "1")
    Integer verifyStateKey;

    @Override
    public String toString() {
        return "VerifyCustomerReqVo{" +
                "userUid=" + userUid +
                ", browerUid=" + browerUid +
                ", verifyStateKey=" + verifyStateKey +
                '}';
    }

    public Integer getVerifyStateKey() {
        return verifyStateKey;
    }

    public void setVerifyStateKey(Integer verifyStateKey) {
        this.verifyStateKey = verifyStateKey;
    }

    public Long getUserUid() {
        return userUid;
    }

    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    public Long getBrowerUid() {
        return browerUid;
    }

    public void setBrowerUid(Long browerUid) {
        this.browerUid = browerUid;
    }


}
