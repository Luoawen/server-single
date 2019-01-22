package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysModule implements Serializable {
    private Long id;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String iconCls;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String caption;

    /**
     * 父节点
     *
     * @mbggenerated
     */
    private Long parentid;

    private List<SysModule> children = new ArrayList<SysModule>();//这里为了防止后面空指针，初始化了children实例
    /**
     * 排序
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private Integer sysId;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    private static final long serialVersionUID = 1L;

    public List<SysModule> getChildren() {
        return children;
    }

    public void setChildren(List<SysModule> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", iconCls=").append(iconCls);
        sb.append(", caption=").append(caption);
        sb.append(", parentid=").append(parentid);
        sb.append(", sort=").append(sort);
        sb.append(", sysId=").append(sysId);
        sb.append(", createTime=").append(createTime);
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
        SysModule other = (SysModule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIconCls() == null ? other.getIconCls() == null : this.getIconCls().equals(other.getIconCls()))
            && (this.getCaption() == null ? other.getCaption() == null : this.getCaption().equals(other.getCaption()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getSysId() == null ? other.getSysId() == null : this.getSysId().equals(other.getSysId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIconCls() == null) ? 0 : getIconCls().hashCode());
        result = prime * result + ((getCaption() == null) ? 0 : getCaption().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getSysId() == null) ? 0 : getSysId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}