package com.alankin.ucenter.dao.model;

import java.io.Serializable;

public class UserExtra implements Serializable {
    /**
     * 用户 ID
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * 手机厂商：apple|htc|samsung，很少用
     *
     * @mbggenerated
     */
    private String vendor;

    /**
     * 客户端名称，如hjskang
     *
     * @mbggenerated
     */
    private String clientName;

    /**
     * 客户端版本号，如7.0.1
     *
     * @mbggenerated
     */
    private String clientVersion;

    /**
     * 设备号:android|ios
     *
     * @mbggenerated
     */
    private String osName;

    /**
     * 系统版本号:2.2|2.3|4.0|5.1
     *
     * @mbggenerated
     */
    private String osVersion;

    /**
     * 设备型号，如:iphone6s、u880、u8800
     *
     * @mbggenerated
     */
    private String deviceName;

    /**
     * 设备ID
     *
     * @mbggenerated
     */
    private String deviceId;

    /**
     * 苹果设备的IDFA
     *
     * @mbggenerated
     */
    private String idfa;

    /**
     * 苹果设备的IDFV
     *
     * @mbggenerated
     */
    private String idfv;

    /**
     * 来源
     *
     * @mbggenerated
     */
    private String market;

    /**
     * 添加时间
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Integer updateTime;

    /**
     * 扩展字段1
     *
     * @mbggenerated
     */
    private String extend1;

    /**
     * 扩展字段2
     *
     * @mbggenerated
     */
    private String extend2;

    /**
     * 扩展字段3
     *
     * @mbggenerated
     */
    private String extend3;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
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

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", vendor=").append(vendor);
        sb.append(", clientName=").append(clientName);
        sb.append(", clientVersion=").append(clientVersion);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", idfa=").append(idfa);
        sb.append(", idfv=").append(idfv);
        sb.append(", market=").append(market);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", extend1=").append(extend1);
        sb.append(", extend2=").append(extend2);
        sb.append(", extend3=").append(extend3);
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
        UserExtra other = (UserExtra) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getVendor() == null ? other.getVendor() == null : this.getVendor().equals(other.getVendor()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getClientVersion() == null ? other.getClientVersion() == null : this.getClientVersion().equals(other.getClientVersion()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getIdfa() == null ? other.getIdfa() == null : this.getIdfa().equals(other.getIdfa()))
            && (this.getIdfv() == null ? other.getIdfv() == null : this.getIdfv().equals(other.getIdfv()))
            && (this.getMarket() == null ? other.getMarket() == null : this.getMarket().equals(other.getMarket()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExtend1() == null ? other.getExtend1() == null : this.getExtend1().equals(other.getExtend1()))
            && (this.getExtend2() == null ? other.getExtend2() == null : this.getExtend2().equals(other.getExtend2()))
            && (this.getExtend3() == null ? other.getExtend3() == null : this.getExtend3().equals(other.getExtend3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getVendor() == null) ? 0 : getVendor().hashCode());
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getClientVersion() == null) ? 0 : getClientVersion().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getIdfa() == null) ? 0 : getIdfa().hashCode());
        result = prime * result + ((getIdfv() == null) ? 0 : getIdfv().hashCode());
        result = prime * result + ((getMarket() == null) ? 0 : getMarket().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExtend1() == null) ? 0 : getExtend1().hashCode());
        result = prime * result + ((getExtend2() == null) ? 0 : getExtend2().hashCode());
        result = prime * result + ((getExtend3() == null) ? 0 : getExtend3().hashCode());
        return result;
    }
}