package cn.com.odin.service.impl;

import cn.com.odin.model.DeviceGpsInfo;
import cn.com.odin.service.IDockingDataService;
import cn.com.odin.service.ISetDeviceGpsService;
import cn.com.odin.utils.ConnectionUtil;
import cn.com.odin.utils.JsonUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("dockingDataService")
public class DockingDataServiceImpl implements IDockingDataService {

    private static Logger logger = Logger.getLogger(DockingDataServiceImpl.class);

    private final static String QUEUE_NAME = "bosi.deviceGpsInfoQueue";

    private final static String EXCHANGE_NAME = "gpsDataDirectExchange";

    @Resource
    private ISetDeviceGpsService setDeviceGpsService;

    @Override
    public void dockingDataFromMq() throws Exception {
        logger.info("function dockingDataFromMq() in ");
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //消息队列声明或者绑定
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定队列到交换机
        String routingKey = "deviceGpsInfoKey";
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey);
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听消息队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody(), "utf-8");

            System.out.println(msg);
            DeviceGpsInfo deviceGpsInfo = JsonUtil.getObjectFromJson(msg, DeviceGpsInfo.class);

            setDeviceGpsService.setDeviceGpsToDB(deviceGpsInfo);
            //手动确认消息消费完成
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

}