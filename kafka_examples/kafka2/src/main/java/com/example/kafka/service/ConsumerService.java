package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 17:02 2019/8/28
 */
@Service
public class ConsumerService {


    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "test4", groupId = "grouptest4")
    public void consumeServer1(ConsumerRecord<String, String> record) {
        System.out.printf("topic = %s, offset = %d, value = %s, key = %s%n", record.topic(), record.offset(), record.value(), record.key());
    }

    @KafkaListener(containerFactory = "server2ListenerContainerFactory", topics = "test666", groupId = "groups2")
    public void consumeServer2(ConsumerRecord<String, String> record) {
        System.out.printf("topic = %s, offset = %d, value = %s, key = %s%n", record.topic(), record.offset(), record.value(), record.key());
    }
}



