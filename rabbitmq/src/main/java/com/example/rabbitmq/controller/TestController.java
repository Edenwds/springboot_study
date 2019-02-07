package com.example.rabbitmq.controller;

import com.example.rabbitmq.sender.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Producer producer;

    @RequestMapping("/send")
    public String test() {
        producer.sendEmail();
        return "test";
    }
}
