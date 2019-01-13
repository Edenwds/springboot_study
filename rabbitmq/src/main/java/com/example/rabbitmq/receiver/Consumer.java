package com.example.rabbitmq.receiver;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

public class Consumer {

    @Autowired
    private FanoutExchange conExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {"proQueue"})
    public void receiveEmail(String email) throws UnsupportedEncodingException {
        System.out.println("receive a email " + email);
        String routingKey = "email";
        MessageProperties messageProperties = getMessageProperties();
        rabbitTemplate.convertAndSend(conExchange.getName(), routingKey, new Message((email + " try again").getBytes("utf-8"),messageProperties));
    }

    /**
     * 设置消息的相关参数
     * @return
     */
    private MessageProperties getMessageProperties() {
        MessageProperties messageProperties = new MessageProperties();
        //设置消息的有效期 ms为单位
        messageProperties.setExpiration("5000");
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        return messageProperties;
    }
}
