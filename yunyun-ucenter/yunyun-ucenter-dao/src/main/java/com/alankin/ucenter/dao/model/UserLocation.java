package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserLocation implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 所在地国
     *
     * @mbggenerated
     */
    private String currNation;

    /**
     * 所在地省
     *
     * @mbggenerated
     */
    private String currProvince;

    /**
     * 所在地市
     *
     * @mbggenerated
     */
    private String currCity;

    /**
     * 所在地地区
     *
     * @mbggenerated
     */
    private String currDistrict;

    /**
     * 具体地址
     *
     * @mbggenerated
     */
    private String location;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private BigDecimal longitude;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private BigDecimal latitude;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Integer updateTime;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCurrNation() {
        return currNation;
    }

    public void setCurrNation(String currNation) {
        this.currNation = currNation;
    }

    public String getCurrProvince() {
        return currProvince;
    }

    public void setCurrProvince(String currProvince) {
        this.currProvince = currProvince;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public String getCurrDistrict() {
        return currDistrict;
    }

    public void setCurrDistrict(String currDistrict) {
        this.currDistrict = currDistrict;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", currNation=").append(currNation);
        sb.append(", currProvince=").append(currProvince);
        sb.append(", currCity=").append(currCity);
        sb.append(", currDistrict=").append(currDistrict);
        sb.append(", location=").append(location);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", updateTime=").append(updateTime);
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
        UserLocation other = (UserLocation) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCurrNation() == null ? other.getCurrNation() == null : this.getCurrNation().equals(other.getCurrNation()))
            && (this.getCurrProvince() == null ? other.getCurrProvince() == null : this.getCurrProvince().equals(other.getCurrProvince()))
            && (this.getCurrCity() == null ? other.getCurrCity() == null : this.getCurrCity().equals(other.getCurrCity()))
            && (this.getCurrDistrict() == null ? other.getCurrDistrict() == null : this.getCurrDistrict().equals(other.getCurrDistrict()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCurrNation() == null) ? 0 : getCurrNation().hashCode());
        result = prime * result + ((getCurrProvince() == null) ? 0 : getCurrProvince().hashCode());
        result = prime * result + ((getCurrCity() == null) ? 0 : getCurrCity().hashCode());
        result = prime * result + ((getCurrDistrict() == null) ? 0 : getCurrDistrict().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}