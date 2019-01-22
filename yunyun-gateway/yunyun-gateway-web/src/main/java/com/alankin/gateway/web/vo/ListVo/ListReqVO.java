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

@ApiModel(value = "ListReqVO", description = "列表请求")
public class ListReqVO<T> extends BaseReqVO {
    /**
     * 分页页码
     */
    @ApiModelProperty(value = "分页页码", example = "1")
    private int pageNum = 1;

    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;

    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段 asc升序 desc降序", example = "asc")
    private String orderField = "desc";

    /**
     * 业务字段
     */
    @ApiModelProperty(value = "业务字段", required = false)
    private T condition;

    @Override
    public String toString() {
        return "ListReqVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderField='" + orderField + '\'' +
                ", condition=" + condition +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }
}
