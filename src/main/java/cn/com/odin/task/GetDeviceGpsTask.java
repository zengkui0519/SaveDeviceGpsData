package cn.com.odin.task;

import cn.com.odin.service.IDockingDataService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class GetDeviceGpsTask {

    private static Logger logger = Logger.getLogger(GetDeviceGpsTask.class);

    private static boolean flag = true;

    @Resource
    private IDockingDataService dockingDataService;

    public  void dockingDataFromKeda() throws Exception {
        logger.info("function dockingDataFromKeda() in, flag is  " + flag);
        if (flag) {
            flag = false;
            dockingDataService.dockingDataFromMq();
        }
    }

}
