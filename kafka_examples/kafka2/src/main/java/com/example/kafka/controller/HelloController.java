package com.example.kafka.controller;

import com.example.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:52 2019/8/28
 */
@RestController
public class HelloController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/send")
    public String hello() {
        producerService.send();
        return "hello kafka";
    }
}
