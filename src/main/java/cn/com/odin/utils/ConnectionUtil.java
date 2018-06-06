package cn.com.odin.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("bosiAdmin");
        factory.setPassword("bosi123");
        factory.setVirtualHost("/bosi");
        return factory.newConnection();
    }

}
