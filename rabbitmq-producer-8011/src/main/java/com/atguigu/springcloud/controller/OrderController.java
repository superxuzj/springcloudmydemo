package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * RabbitMQ 死信队列与延时队列
 * @author zhijian.xu
 * @date 2021/1/8
 **/
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("ttltest")
    public String createOrderTest() {
        OrderMaster orderMaster = new OrderMaster();
        //未支付
        orderMaster.setOrderStatus(0);
        //未支付
        orderMaster.setPayStatus(0);
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerAddress("湖南长沙");
        orderMaster.setBuyerPhone("186981578424");
        orderMaster.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
        //TODO：设置超时，用mq处理已超时的下单记录（一旦记录超时，则处理为无效）
        rabbitTemplate.convertAndSend("user.order.delay_exchange", "user.order.delay_key", orderMaster, message -> {
            message.getMessageProperties().setExpiration("10000");
            return message;
        });
        System.out.println(new Date());
        return "创建订单成功";
    }

}
