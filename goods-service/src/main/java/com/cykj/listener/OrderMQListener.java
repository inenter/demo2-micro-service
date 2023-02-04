package com.cykj.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/2/3 11:44
 */
@Component
@RocketMQMessageListener(topic = "order-test", consumerGroup = "producer-demo1")
public class OrderMQListener implements RocketMQListener<String> {

    // 监听是否有消息到达
    public void onMessage(String s) {
        // 收到消息后 减库存
        System.out.println("接收的消息：" + s);
    }

}
