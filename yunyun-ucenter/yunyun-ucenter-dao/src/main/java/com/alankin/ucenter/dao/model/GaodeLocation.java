package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class GaodeLocation implements Serializable {
    private Long uid;

    /**
     * 用户uid
     *
     * @mbggenerated
     */
    private Long userUid;

    /**
     * 定位结果来源
     *
     * @mbggenerated
     */
    private Integer locationtype;

    /**
     * 获取纬度
     *
     * @mbggenerated
     */
    private String latitude;

    /**
     * 获取经度
     *
     * @mbggenerated
     */
    private String longitude;

    /**
     * 获取精度信息
     *
     * @mbggenerated
     */
    private String accuracy;

    /**
     * 地址
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 国家信息
     *
     * @mbggenerated
     */
    private String country;

    /**
     * 省信息
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 城市信息
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 城区信息
     *
     * @mbggenerated
     */
    private String district;

    /**
     * 街道信息
     *
     * @mbggenerated
     */
    private String street;

    /**
     * 街道门牌号信息
     *
     * @mbggenerated
     */
    private String streetnum;

    /**
     * 城市编码
     *
     * @mbggenerated
     */
    private String citycode;

    /**
     * 地区编码
     *
     * @mbggenerated
     */
    private String adcode;

    /**
     * 定位点的AOI信息
     *
     * @mbggenerated
     */
    private String aoiname;

    /**
     * 建筑物Id
     *
     * @mbggenerated
     */
    private String buildingid;

    /**
     * 楼层
     *
     * @mbggenerated
     */
    private String floor;

    /**
     * GPS的当前状态
     *
     * @mbggenerated
     */
    private Integer gpsaccuracystatus;

    private Integer createTime;

    private Integer updateTime;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUserUid() {
        return userUid;
    }

    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    public Integer getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(Integer locationtype) {
        this.locationtype = locationtype;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnum() {
        return streetnum;
    }

    public void setStreetnum(String streetnum) {
        this.streetnum = streetnum;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getAoiname() {
        return aoiname;
    }

    public void setAoiname(String aoiname) {
        this.aoiname = aoiname;
    }

    public String getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(String buildingid) {
        this.buildingid = buildingid;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getGpsaccuracystatus() {
        return gpsaccuracystatus;
    }

    public void setGpsaccuracystatus(Integer gpsaccuracystatus) {
        this.gpsaccuracystatus = gpsaccuracystatus;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
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
        sb.append(", userUid=").append(userUid);
        sb.append(", locationtype=").append(locationtype);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", accuracy=").append(accuracy);
        sb.append(", address=").append(address);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", street=").append(street);
        sb.append(", streetnum=").append(streetnum);
        sb.append(", citycode=").append(citycode);
        sb.append(", adcode=").append(adcode);
        sb.append(", aoiname=").append(aoiname);
        sb.append(", buildingid=").append(buildingid);
        sb.append(", floor=").append(floor);
        sb.append(", gpsaccuracystatus=").append(gpsaccuracystatus);
        sb.append(", createTime=").append(createTime);
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
        GaodeLocation other = (GaodeLocation) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserUid() == null ? other.getUserUid() == null : this.getUserUid().equals(other.getUserUid()))
            && (this.getLocationtype() == null ? other.getLocationtype() == null : this.getLocationtype().equals(other.getLocationtype()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getAccuracy() == null ? other.getAccuracy() == null : this.getAccuracy().equals(other.getAccuracy()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getStreet() == null ? other.getStreet() == null : this.getStreet().equals(other.getStreet()))
            && (this.getStreetnum() == null ? other.getStreetnum() == null : this.getStreetnum().equals(other.getStreetnum()))
            && (this.getCitycode() == null ? other.getCitycode() == null : this.getCitycode().equals(other.getCitycode()))
            && (this.getAdcode() == null ? other.getAdcode() == null : this.getAdcode().equals(other.getAdcode()))
            && (this.getAoiname() == null ? other.getAoiname() == null : this.getAoiname().equals(other.getAoiname()))
            && (this.getBuildingid() == null ? other.getBuildingid() == null : this.getBuildingid().equals(other.getBuildingid()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getGpsaccuracystatus() == null ? other.getGpsaccuracystatus() == null : this.getGpsaccuracystatus().equals(other.getGpsaccuracystatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserUid() == null) ? 0 : getUserUid().hashCode());
        result = prime * result + ((getLocationtype() == null) ? 0 : getLocationtype().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getAccuracy() == null) ? 0 : getAccuracy().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getStreet() == null) ? 0 : getStreet().hashCode());
        result = prime * result + ((getStreetnum() == null) ? 0 : getStreetnum().hashCode());
        result = prime * result + ((getCitycode() == null) ? 0 : getCitycode().hashCode());
        result = prime * result + ((getAdcode() == null) ? 0 : getAdcode().hashCode());
        result = prime * result + ((getAoiname() == null) ? 0 : getAoiname().hashCode());
        result = prime * result + ((getBuildingid() == null) ? 0 : getBuildingid().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getGpsaccuracystatus() == null) ? 0 : getGpsaccuracystatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}