package com.example.rabbitmq.sender;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Resource(name = "proExchange")
    private TopicExchange proExchange;

    public void sendEmail() {
        String message = "this is a email";
        String routingKey = "email";
        rabbitTemplate.convertAndSend(proExchange.getName(),routingKey,message);
        System.out.println("send successfully");
    }
}
