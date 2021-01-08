package com.atguigu.springcloud.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhijian.xu
 * @date 2021/1/8
 **/

@Component
public class FanoutReceiver {
    @RabbitListener(queues = "fanout.A")
    @RabbitHandler
    public void processA(Map testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());
    }

    @RabbitListener(queues = "fanout.B")
    @RabbitHandler
    public void processB(Map testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
    }

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
    public void processC(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " +testMessage.toString());
    }

}
