package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class AfuGuize implements Serializable {
    private Integer id;

    /**
     * 规则编码
     *
     * @mbggenerated
     */
    private String gzCode;

    /**
     * 规则名称
     *
     * @mbggenerated
     */
    private String gzName;

    /**
     * 规则解析
     *
     * @mbggenerated
     */
    private String gzJiexi;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGzCode() {
        return gzCode;
    }

    public void setGzCode(String gzCode) {
        this.gzCode = gzCode;
    }

    public String getGzName() {
        return gzName;
    }

    public void setGzName(String gzName) {
        this.gzName = gzName;
    }

    public String getGzJiexi() {
        return gzJiexi;
    }

    public void setGzJiexi(String gzJiexi) {
        this.gzJiexi = gzJiexi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gzCode=").append(gzCode);
        sb.append(", gzName=").append(gzName);
        sb.append(", gzJiexi=").append(gzJiexi);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AfuGuize other = (AfuGuize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGzCode() == null ? other.getGzCode() == null : this.getGzCode().equals(other.getGzCode()))
            && (this.getGzName() == null ? other.getGzName() == null : this.getGzName().equals(other.getGzName()))
            && (this.getGzJiexi() == null ? other.getGzJiexi() == null : this.getGzJiexi().equals(other.getGzJiexi()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGzCode() == null) ? 0 : getGzCode().hashCode());
        result = prime * result + ((getGzName() == null) ? 0 : getGzName().hashCode());
        result = prime * result + ((getGzJiexi() == null) ? 0 : getGzJiexi().hashCode());
        return result;
    }
}