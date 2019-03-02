package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class StorageImage implements Serializable {
    private Long uid;

    /**
     * 图片原名称
     *
     * @mbggenerated
     */
    private String originalName;

    /**
     * 图片大小
     *
     * @mbggenerated
     */
    private Long size;

    /**
     * 图片存储名称
     *
     * @mbggenerated
     */
    private String storageName;

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    private String storagePath;

    private String fullPath;

    private String storageGroup;

    private String thumbImagePath;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getStorageGroup() {
        return storageGroup;
    }

    public void setStorageGroup(String storageGroup) {
        this.storageGroup = storageGroup;
    }

    public String getThumbImagePath() {
        return thumbImagePath;
    }

    public void setThumbImagePath(String thumbImagePath) {
        this.thumbImagePath = thumbImagePath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", originalName=").append(originalName);
        sb.append(", size=").append(size);
        sb.append(", storageName=").append(storageName);
        sb.append(", createTime=").append(createTime);
        sb.append(", storagePath=").append(storagePath);
        sb.append(", fullPath=").append(fullPath);
        sb.append(", storageGroup=").append(storageGroup);
        sb.append(", thumbImagePath=").append(thumbImagePath);
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
        StorageImage other = (StorageImage) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getOriginalName() == null ? other.getOriginalName() == null : this.getOriginalName().equals(other.getOriginalName()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getStorageName() == null ? other.getStorageName() == null : this.getStorageName().equals(other.getStorageName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStoragePath() == null ? other.getStoragePath() == null : this.getStoragePath().equals(other.getStoragePath()))
            && (this.getFullPath() == null ? other.getFullPath() == null : this.getFullPath().equals(other.getFullPath()))
            && (this.getStorageGroup() == null ? other.getStorageGroup() == null : this.getStorageGroup().equals(other.getStorageGroup()))
            && (this.getThumbImagePath() == null ? other.getThumbImagePath() == null : this.getThumbImagePath().equals(other.getThumbImagePath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOriginalName() == null) ? 0 : getOriginalName().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getStorageName() == null) ? 0 : getStorageName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStoragePath() == null) ? 0 : getStoragePath().hashCode());
        result = prime * result + ((getFullPath() == null) ? 0 : getFullPath().hashCode());
        result = prime * result + ((getStorageGroup() == null) ? 0 : getStorageGroup().hashCode());
        result = prime * result + ((getThumbImagePath() == null) ? 0 : getThumbImagePath().hashCode());
        return result;
    }
}