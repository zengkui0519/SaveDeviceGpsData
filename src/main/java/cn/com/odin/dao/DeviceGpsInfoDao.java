package cn.com.odin.dao;

import cn.com.odin.model.DeviceGpsInfo;

public interface DeviceGpsInfoDao {

    int insertDeviceGpsCurrent(DeviceGpsInfo deviceGpsInfo);

    int updateCurrentByDeviceId(DeviceGpsInfo deviceGpsInfo);

}