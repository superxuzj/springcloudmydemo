package com.atguigu.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhijian.xu
 * @date 2021/1/8
 **/

@Configuration
public class RabbitmqTTLConfig {
    /**
     * 死信 延迟交换机
     *
     * @return
     */
    @Bean
    public DirectExchange userOrderDelayExchange() {
        return new DirectExchange("user.order.delay_exchange");
    }

    /**
     * 死信 延迟队列
     *
     * @return
     */
    @Bean
    public Queue userOrderDelayQueue() {
        Map<String, Object> map = new HashMap<>(16);
        //如果消息过时，则会被投递到当前对应的交换机
        map.put("x-dead-letter-exchange", "user.order.receive_exchange");
        //如果消息过时，user.order.receive_exchange交换机会根据user.order.receive_key投递消息到对应的队列
        map.put("x-dead-letter-routing-key", "user.order.receive_key");
        return new Queue("user.order.delay_queue", true, false, false, map);
    }

    /**
     * 给延迟队列绑定交换机
     *
     * @return
     */
    @Bean
    public Binding userOrderDelayBinding() {
        return BindingBuilder.bind(userOrderDelayQueue()).to(userOrderDelayExchange()).with("user.order.delay_key");
    }

    /**
     * 死信接收交换机
     *
     * @return
     */
    @Bean
    public DirectExchange userOrderReceiveExchange() {
        return new DirectExchange("user.order.receive_exchange");
    }

    /**
     * 死信接收队列
     *
     * @return
     */
    @Bean
    public Queue userOrderReceiveQueue() {

        return new Queue("user.order.receive_queue");
    }

    /**
     * 死信交换机绑定消费队列
     *
     * @return
     */
    @Bean
    public Binding userOrderReceiveBinding() {
        return BindingBuilder.bind(userOrderReceiveQueue()).to(userOrderReceiveExchange()).with("user.order.receive_key");
    }

}
