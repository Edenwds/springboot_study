package com.example.rabbitmq.config;

import com.example.rabbitmq.receiver.Consumer;
import com.example.rabbitmq.sender.Producer;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MQConfig {

    //创建消费者
    @Bean
    public Consumer consumer() {
        return new Consumer();
    }

    //创建生产者
    @Bean
    public Producer producer() {
        return new Producer();
    }

    //创建生产者的topic exchange
    @Bean
    public TopicExchange proExchange() {
        return new TopicExchange("proExc");
    }

    //创建消费者的fanout exchange
    @Bean
    public FanoutExchange conExchange() {
        return new FanoutExchange("conExc");
    }

    //创建缓冲队列的dead letter exchange (死信路由)
    @Bean
    public TopicExchange dlxExchange() {
        return new TopicExchange("dlxExc");
    }

    //创建普通(生产者)对列
    @Bean
    public Queue proQueue() {
        return new Queue("proQueue");
    }

    //创建缓冲队列, 声明dlx
    @Bean
    public Queue cacheQueue() {
        Map<String, Object> args = new HashMap<>();
        //dlx的名称必须与创建exchange的名称相同
        args.put("x-dead-letter-exchange","dlxExc");
        return QueueBuilder.nonDurable("delayqueue").withArguments(args).build();
    }

    //普通队列与生产者的 topic exchage 绑定
    @Bean
    public Binding bindingPtoP(@Qualifier("proQueue") Queue proQueue, @Qualifier("proExchange") TopicExchange proExchange) {
        return BindingBuilder.bind(proQueue).to(proExchange).with("email.#");
    }

    //缓冲队列与消息者的 fanout exchange 绑定
    @Bean
    public Binding bindingCtoF(@Qualifier("cacheQueue") Queue cacheQueue, @Qualifier("conExchange") FanoutExchange conExchange) {
        return BindingBuilder.bind(cacheQueue).to(conExchange);
    }

    //普通队列与死信路由 dlx 绑定
    @Bean
    public Binding bindingPtoD(@Qualifier("proQueue") Queue proQueue, @Qualifier("dlxExchange") TopicExchange dlxExchange) {
        return BindingBuilder.bind(proQueue).to(dlxExchange).with("email.#");
    }

}
