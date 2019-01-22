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
@ApiModel(value = "IdsReqVO", description = "列表请求")
public class IdsReqVO extends BaseReqVO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String[] ids;

    @Override
    public String toString() {
        return "IdsReqVO{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
