package cn.com.odin.service.impl;

import cn.com.odin.dao.CommonGpsHistoryDao;
import cn.com.odin.dao.DBTableDao;
import cn.com.odin.dao.DeviceGpsInfoDao;
import cn.com.odin.model.DeviceGpsInfo;
import cn.com.odin.service.ISetDeviceGpsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("setDeviceGpsService")
public class SetDeviceGpsServiceImpl implements ISetDeviceGpsService {

    private static Logger logger = Logger.getLogger(SetDeviceGpsServiceImpl.class);

    @Resource
    private DBTableDao dbTableDao;

    @Resource
    private DeviceGpsInfoDao deviceGpsInfoDao;

    @Resource
    private CommonGpsHistoryDao commonGpsHistoryDao;

    @Override
    public void setDeviceGpsToDB(DeviceGpsInfo deviceGpsInfo) {
        logger.info("function setDeviceGpsMain() in, deviceGpsInfo is " + deviceGpsInfo);
        if (null == deviceGpsInfo) return;
        String tableName = "T_INFO_GPS_" + deviceGpsInfo.getDeviceID().substring(0,15).toUpperCase();
        logger.info("the table name is" + tableName);
        Map<String, String> map = new HashMap<String, String>();
        map.put("tableName", tableName);
        boolean result = dbTableDao.existTable(map);
        logger.info("the table " + tableName + " existTable result is " + result);
        if (result) {
            deviceGpsInfoDao.updateCurrentByDeviceId(deviceGpsInfo);
        } else {
            dbTableDao.createTable(map);
            deviceGpsInfoDao.insertDeviceGpsCurrent(deviceGpsInfo);
        }
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("tableName", tableName);
        map1.put("deviceGpsInfo", deviceGpsInfo);
        commonGpsHistoryDao.insertDeviceGpsHistory(map1);
    }

}