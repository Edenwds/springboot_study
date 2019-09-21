package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:54 2019/8/28
 */
@Service
public class ProducerService {

    @Value("${spring.kafka.topic}")
    private String topic;

    private AtomicInteger counter = new AtomicInteger(1);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send() {
        kafkaTemplate.send(topic, "hello kafka" + counter.getAndIncrement());
        return "all send";
    }
}
