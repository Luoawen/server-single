package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class DataDic implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 创建者Id
     *
     * @mbggenerated
     */
    private Integer sysUserId;

    /**
     * 数据类型
     *
     * @mbggenerated
     */
    private String dataTypeName;

    /**
     * 数据类型码
     *
     * @mbggenerated
     */
    private Integer dataTypeCode;

    /**
     * 键
     *
     * @mbggenerated
     */
    private String dicKey;

    /**
     * 值
     *
     * @mbggenerated
     */
    private String dicValue;

    /**
     * 描述
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * 扩展属性值
     *
     * @mbggenerated
     */
    private String extendVal;

    /**
     * 是否启用 0禁用 1启用 
     *
     * @mbggenerated
     */
    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public Integer getDataTypeCode() {
        return dataTypeCode;
    }

    public void setDataTypeCode(Integer dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExtendVal() {
        return extendVal;
    }

    public void setExtendVal(String extendVal) {
        this.extendVal = extendVal;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", dataTypeName=").append(dataTypeName);
        sb.append(", dataTypeCode=").append(dataTypeCode);
        sb.append(", dicKey=").append(dicKey);
        sb.append(", dicValue=").append(dicValue);
        sb.append(", comment=").append(comment);
        sb.append(", extendVal=").append(extendVal);
        sb.append(", enabled=").append(enabled);
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
        DataDic other = (DataDic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getDataTypeName() == null ? other.getDataTypeName() == null : this.getDataTypeName().equals(other.getDataTypeName()))
            && (this.getDataTypeCode() == null ? other.getDataTypeCode() == null : this.getDataTypeCode().equals(other.getDataTypeCode()))
            && (this.getDicKey() == null ? other.getDicKey() == null : this.getDicKey().equals(other.getDicKey()))
            && (this.getDicValue() == null ? other.getDicValue() == null : this.getDicValue().equals(other.getDicValue()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getExtendVal() == null ? other.getExtendVal() == null : this.getExtendVal().equals(other.getExtendVal()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getDataTypeName() == null) ? 0 : getDataTypeName().hashCode());
        result = prime * result + ((getDataTypeCode() == null) ? 0 : getDataTypeCode().hashCode());
        result = prime * result + ((getDicKey() == null) ? 0 : getDicKey().hashCode());
        result = prime * result + ((getDicValue() == null) ? 0 : getDicValue().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getExtendVal() == null) ? 0 : getExtendVal().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        return result;
    }
}