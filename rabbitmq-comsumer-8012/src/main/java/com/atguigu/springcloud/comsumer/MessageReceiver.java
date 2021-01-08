package com.atguigu.springcloud.comsumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MessageReceiver {
    //创建queue exchange 和绑定关系，要是mq里面没有，会自动添加
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "springboot",durable = "true"),
            exchange = @Exchange(name = "springboot-exchange",durable = "true",type = "fanout")
    )
    )
    //注解的方式监听 @Payload对应消息体 @Headers对应properties 配置文件是手动签收，依赖channel
    @RabbitHandler
    public void onMessage(@Payload String message, @Headers Map<String,Object> heads,
                          Channel channel)throws Exception{
        System.out.println("收到消息 --- "+ message);
        System.out.println("收到消息 head-- "+ heads.get("send_time"));
        Long  tag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("tag: "+tag);
        //手工签收 要是配置文件设置手工签收，没有下面的代码，那么队列里的消息一直存在
        channel.basicAck(tag,true);
    }




    @RabbitListener(queues = "TestDirectQueue")
    //注解的方式监听 @Payload对应消息体 @Headers对应properties 配置文件是手动签收，依赖channel
    @RabbitHandler
    public void process1(Map testMessage, @Headers Map<String,Object> heads,Channel channel) throws IOException {
        System.out.println("DirectReceiver消费者收到消息1  : " + testMessage.toString());
        Long  tag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag,true);
    }

    @RabbitListener(queues = "TestDirectQueue")
    //注解的方式监听 @Payload对应消息体 @Headers对应properties 配置文件是手动签收，依赖channel
    @RabbitHandler
    public void process2(Map testMessage, @Headers Map<String,Object> heads,Channel channel) throws IOException {
        System.out.println("DirectReceiver消费者收到消息2  : " + testMessage.toString());
        Long  tag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag,true);
    }

    @RabbitListener(queues = "TestDirectQueue")
    //注解的方式监听 @Payload对应消息体 @Headers对应properties 配置文件是手动签收，依赖channel
    @RabbitHandler
    public void process3(Map testMessage, @Headers Map<String,Object> heads,Channel channel) throws IOException {
        System.out.println("DirectReceiver消费者收到消息3  : " + testMessage.toString());
        Long  tag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag,true);
    }

}