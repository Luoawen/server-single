/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.alankin.gateway.web.vo.ListVo;

import com.alankin.gateway.web.vo.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * 查询视图基类
 * <p>
 *
 * @author alankin
 * @Date 2015年10月8日
 * @since 1.0
 */
@ApiModel(value = "StringReqVO", description = "请求")
public class StringReqVO extends BaseReqVO {
    /**
     * value
     */
    @ApiModelProperty(value = "value")
    private String value;

    @Override
    public String toString() {
        return "StringReqVO{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
