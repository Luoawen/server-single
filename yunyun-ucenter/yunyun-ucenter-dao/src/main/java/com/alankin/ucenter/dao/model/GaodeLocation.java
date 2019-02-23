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
    private Integer locationType;

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
    private String streetNum;

    /**
     * 城市编码
     *
     * @mbggenerated
     */
    private String cityCode;

    /**
     * 地区编码
     *
     * @mbggenerated
     */
    private String adCode;

    /**
     * 定位点的AOI信息
     *
     * @mbggenerated
     */
    private String aoiName;

    /**
     * 建筑物Id
     *
     * @mbggenerated
     */
    private String buildingId;

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
    private Integer gpsAccuracyStatus;

    /**
     * 1为h5   2为安卓  3为苹果
     *
     * @mbggenerated
     */
    private Integer loacationDataSource;

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

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
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

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getAoiName() {
        return aoiName;
    }

    public void setAoiName(String aoiName) {
        this.aoiName = aoiName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getGpsAccuracyStatus() {
        return gpsAccuracyStatus;
    }

    public void setGpsAccuracyStatus(Integer gpsAccuracyStatus) {
        this.gpsAccuracyStatus = gpsAccuracyStatus;
    }

    public Integer getLoacationDataSource() {
        return loacationDataSource;
    }

    public void setLoacationDataSource(Integer loacationDataSource) {
        this.loacationDataSource = loacationDataSource;
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
        sb.append(", locationType=").append(locationType);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", accuracy=").append(accuracy);
        sb.append(", address=").append(address);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", street=").append(street);
        sb.append(", streetNum=").append(streetNum);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", adCode=").append(adCode);
        sb.append(", aoiName=").append(aoiName);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", floor=").append(floor);
        sb.append(", gpsAccuracyStatus=").append(gpsAccuracyStatus);
        sb.append(", loacationDataSource=").append(loacationDataSource);
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
            && (this.getLocationType() == null ? other.getLocationType() == null : this.getLocationType().equals(other.getLocationType()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getAccuracy() == null ? other.getAccuracy() == null : this.getAccuracy().equals(other.getAccuracy()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getStreet() == null ? other.getStreet() == null : this.getStreet().equals(other.getStreet()))
            && (this.getStreetNum() == null ? other.getStreetNum() == null : this.getStreetNum().equals(other.getStreetNum()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getAdCode() == null ? other.getAdCode() == null : this.getAdCode().equals(other.getAdCode()))
            && (this.getAoiName() == null ? other.getAoiName() == null : this.getAoiName().equals(other.getAoiName()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getGpsAccuracyStatus() == null ? other.getGpsAccuracyStatus() == null : this.getGpsAccuracyStatus().equals(other.getGpsAccuracyStatus()))
            && (this.getLoacationDataSource() == null ? other.getLoacationDataSource() == null : this.getLoacationDataSource().equals(other.getLoacationDataSource()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserUid() == null) ? 0 : getUserUid().hashCode());
        result = prime * result + ((getLocationType() == null) ? 0 : getLocationType().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getAccuracy() == null) ? 0 : getAccuracy().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getStreet() == null) ? 0 : getStreet().hashCode());
        result = prime * result + ((getStreetNum() == null) ? 0 : getStreetNum().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getAdCode() == null) ? 0 : getAdCode().hashCode());
        result = prime * result + ((getAoiName() == null) ? 0 : getAoiName().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getGpsAccuracyStatus() == null) ? 0 : getGpsAccuracyStatus().hashCode());
        result = prime * result + ((getLoacationDataSource() == null) ? 0 : getLoacationDataSource().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}