package io.java.net.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * 模拟一个客户端接收消息
 * @author rao
 *
 *  1、使用场景：
 *    1、不可靠、网络带宽小的网络
 *    2、运行的设备CPU、内存非常有限
 *     （我个人主要是用在服务端与嵌入式客户端进行消息和广告的通信）
 *
 * 2、特点：
 *      1、基于发布/订阅模型的协议
 *      2、他是二进制协议，二进制的特点就是紧凑、占用空间小。他的协议头只有2个字节
 *      3、提供了三种消息可能性保障（Qos）：0：最多一次 、1：最少一次 、2：只有一次
 *
 * 3、关键字
 *      1、HOST：搭载MQTT的服务器地址
 *      2、TOPIC：消息主题，可以被客户端订阅，实现对应消息的收发
 *      3、clientId：客户端ID，用于服务器对不同客户端的识别
 *      4、subscribe/unsubscribe：客户端对消息主题的订阅和取消订阅
 *      5、Qos：消息的服务质量，当网络过载或拥塞时，QoS 能确保重要业务量不受延迟或丢弃
 *      6、Callback：当客户端收到消息后对消息的处理（回调）
 *      7、KeepAliveInterval：客户端与服务器之间的连接是通过发送心跳包来保持存活
 *
 */
public class ClientMQTT {

    public static final String HOST = "tcp://dev.****.com.cn:1883";
    public static final String TOPIC1 = "pos_message_all";
    private static final String clientid = "client11";
    private MqttClient client;
    private MqttConnectOptions options;
    private String userName = "admin";    //非必须
    private String passWord = "password";  //非必须
    @SuppressWarnings("unused")
    private ScheduledExecutorService scheduler;

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);

            // 设置回调
            client.setCallback(new PushCallback());

            MqttTopic topic = client.getTopic(TOPIC1);

            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
//遗嘱        options.setWill(topic, "close".getBytes(), 2, true);
            client.connect(options);
            //订阅消息
            int[] Qos  = {1};
            String[] topic1 = {TOPIC1};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MqttException {
        ClientMQTT client = new ClientMQTT();
        client.start();
    }
}
