/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.alankin.gateway.web.vo.response;

import com.github.pagehelper.PageInfo;

/**
 * 查询视图基类
 * <p>
 *
 * @author alankin
 * @Date 2015年10月8日
 * @since 1.0
 */
@SuppressWarnings("rawtypes")
public class ListResult extends Result {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * 响应分页页码
     */
    private int pageNum;

    /**
     * 响应每页记录数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long pageTotal;

    public ListResult(ResultConstant resultConstant, Object data) {
        super(resultConstant, data);
    }

    public ListResult(ResultConstant resultConstant, PageInfo pageInfo) {
        super(resultConstant, pageInfo.getList());
        if (pageInfo != null) {
            this.setPageNum(pageInfo.getPageNum());
            this.setPageSize(pageInfo.getSize());
            this.setPageTotal(pageInfo.getTotal());
        }
    }
    public ListResult(ResultConstant resultConstant) {
        super(resultConstant, null);
    }

    @Override
    public String toString() {
        return "ListResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
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

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }
}
