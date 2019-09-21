package com.example.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Arrays;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 17:08 2019/8/28
 */
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers1}")
    private String servers1;
    @Value("${spring.kafka.consumer.bootstrap-servers2}")
    private String servers2;

    @Autowired
    private KafkaProperties kafkaProperties;

    // server1 consumer config
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        KafkaProperties.Consumer consumer = kafkaProperties.getConsumer();
        consumer.setBootstrapServers(Arrays.asList(servers1.split(",")));
        return new DefaultKafkaConsumerFactory<>(consumer.buildProperties());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(consumerFactory());
        return containerFactory;
    }

    // server2 consumer config
    @Bean
    public ConsumerFactory<String, String> server2ConsumerFactory() {
        KafkaProperties.Consumer consumer = kafkaProperties.getConsumer();
        consumer.setBootstrapServers(Arrays.asList(servers2.split(",")));
        return new DefaultKafkaConsumerFactory<>(consumer.buildProperties());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory server2ListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(server2ConsumerFactory());
        return containerFactory;
    }
}
