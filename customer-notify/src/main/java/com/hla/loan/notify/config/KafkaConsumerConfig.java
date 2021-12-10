package com.hla.loan.notify.config;

import com.hla.loan.notify.model.Customer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaConsumerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private String bootstrapServer;
    private String topicName;
    KafkaProperties kafkaProperties;

    public KafkaConsumerConfig(@Value("${spring.kafka.bootstrap-servers}") String bootstrapServer, @Value("${tpd.topic-name}") String topicName, KafkaProperties kafkaProperties) {
        this.bootstrapServer = bootstrapServer;
        this.kafkaProperties = kafkaProperties;
        this.topicName = topicName;
        LOGGER.info("details for :  {} and bootstrapServer {}", topicName , bootstrapServer);
    }

    public Map<String, Object> consumerConfig() {
        Map<String, Object> consumerConfigMap = new HashMap<String, Object>(kafkaProperties.buildProducerProperties());
        consumerConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        consumerConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
        consumerConfigMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        consumerConfigMap.put(ConsumerConfig.GROUP_ID_CONFIG, "Notify-process");
        return consumerConfigMap;
    }

    @Bean
    public ConsumerFactory<String, Customer> getConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Customer> getKafkaTemplate() {
        ConcurrentKafkaListenerContainerFactory<String, Customer> concurrentFatory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentFatory.setConsumerFactory(getConsumerFactory());
        return concurrentFatory;
    }

 }
