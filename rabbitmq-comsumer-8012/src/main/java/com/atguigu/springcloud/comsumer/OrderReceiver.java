package com.atguigu.springcloud.comsumer;

import com.atguigu.springcloud.entities.OrderMaster;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhijian.xu
 * @date 2021/1/8
 **/

@Component
public class OrderReceiver {


    //监听消息队列
    @RabbitListener(queues = "user.order.receive_queue")
    public void consumeMessage(OrderMaster order) throws IOException {
        try {
            //如果订单状态不是0 说明订单已经被其他消费队列改动过了 加一个状态用来判断集群状态的情况
            if (Objects.equals(0,order.getOrderStatus())) {
                //设置订单过去状态
                order.setOrderStatus(-1);
                System.out.println(order.getBuyerName());
                System.out.println(new Date());
                //orderMasterService.updateByPrimaryKeySelective(order);
            }
        } catch (Exception e) {
        }
    }

}
