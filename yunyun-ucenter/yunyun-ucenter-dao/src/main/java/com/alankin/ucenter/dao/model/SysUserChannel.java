package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class SysUserChannel implements Serializable {
    private Long id;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private Long chanelId;

    /**
     * id
     *
     * @mbggenerated
     */
    private Long sysUserId;

    /**
     * 关联类型 1渠道审核人关联（一对多）   2推广人渠道关联
     *
     * @mbggenerated
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChanelId() {
        return chanelId;
    }

    public void setChanelId(Long chanelId) {
        this.chanelId = chanelId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chanelId=").append(chanelId);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", type=").append(type);
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
        SysUserChannel other = (SysUserChannel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChanelId() == null ? other.getChanelId() == null : this.getChanelId().equals(other.getChanelId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChanelId() == null) ? 0 : getChanelId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}