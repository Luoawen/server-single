/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.alankin.gateway.web.vo.ListVo;

import com.alankin.gateway.web.vo.BaseReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询视图基类
 * <p>
 *
 * @author alankin
 * @Date 2015年10月8日
 * @since 1.0
 */
@ApiModel(value = "IdReqVO", description = "列表请求")
public class IdReqVO extends BaseReqVO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    @Override
    public String toString() {
        return "IdReqVO{" +
                "id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
