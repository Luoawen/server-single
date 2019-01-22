package com.alankin.gateway.web.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: alankin
 * @Description: TODO
 * @date 创建时间：2019/1/3　14:23
 */
@ApiModel(value = "BaseTokenReqVo")
public class BaseTokenReqVo extends BaseReqVO {
    /**
     * 数据权限代码
     */
    @ApiModelProperty(value = "token 不能为空", example = "123")
    @NotBlank(message = "token不能为空")
    public String token;

    @Override
    public String toString() {
        return "BaseTokenReqVo{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
