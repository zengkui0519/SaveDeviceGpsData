package cn.com.odin.model;

import java.math.BigDecimal;

public class DeviceGpsInfo {
    private Integer dataId;

    private String deviceID;

    private BigDecimal revTime;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal marLongitude;

    private BigDecimal marLatitude;

    private BigDecimal speed;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID == null ? null : deviceID.trim();
    }

    public BigDecimal getRevTime() {
        return revTime;
    }

    public void setRevTime(BigDecimal revTime) {
        this.revTime = revTime;
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

    public BigDecimal getMarLongitude() {
        return marLongitude;
    }

    public void setMarLongitude(BigDecimal marLongitude) {
        this.marLongitude = marLongitude;
    }

    public BigDecimal getMarLatitude() {
        return marLatitude;
    }

    public void setMarLatitude(BigDecimal marLatitude) {
        this.marLatitude = marLatitude;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeviceGpsInfo{");
        sb.append("dataId=").append(dataId);
        sb.append(", deviceID='").append(deviceID).append('\'');
        sb.append(", revTime=").append(revTime);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", marLongitude=").append(marLongitude);
        sb.append(", marLatitude=").append(marLatitude);
        sb.append(", speed=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}