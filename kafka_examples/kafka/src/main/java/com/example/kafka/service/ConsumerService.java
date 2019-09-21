package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 17:21 2019/4/8
 */
@Service
public class ConsumerService {

    @KafkaListener(topics = "test3")
    public void listen (ConsumerRecord<?, ?> record) {
        System.out.printf("topic = %s, offset = %d, value = %s, key = %s%n", record.topic(), record.offset(), record.value(), record.key());
    }
}
