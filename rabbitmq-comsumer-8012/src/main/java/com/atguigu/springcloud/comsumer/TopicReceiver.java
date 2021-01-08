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
public class TopicReceiver {

    @RabbitListener(queues = "topic.man")
    @RabbitHandler
    public void processman(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }


    @RabbitListener(queues = "topic.woman")
    @RabbitHandler
    public void processTotal(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }

}
