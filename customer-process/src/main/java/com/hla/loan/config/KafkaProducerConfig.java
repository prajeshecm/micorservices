package com.hla.loan.config;

import com.hla.loan.model.Customer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerConfig.class);

    private String bootstrapServer;
    private String topicName;
    KafkaProperties kafkaProperties;

    public KafkaProducerConfig(@Value("${spring.kafka.bootstrap-servers}") String bootstrapServer, @Value("${tpd.topic-name}") String topicName, KafkaProperties kafkaProperties) {
        this.bootstrapServer = bootstrapServer;
        this.kafkaProperties = kafkaProperties;
        this.topicName = topicName;
        LOGGER.info("details for :  {} and bootstrapServer {}", topicName , bootstrapServer);
    }

    public Map<String, Object> producerConfig() {
        Map<String, Object> producerConfigMap = new HashMap<String, Object>(kafkaProperties.buildProducerProperties());
        producerConfigMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfigMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
        producerConfigMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        return producerConfigMap;
    }

    @Bean
    public ProducerFactory<String, Customer> getProducerFactory() {
        return new DefaultKafkaProducerFactory<String, Customer>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Customer> getKafkaTemplate() {
        return new KafkaTemplate<String, Customer>(getProducerFactory());
    }

    @Bean
    public NewTopic createCustomerTopic() {
        return new NewTopic(topicName, 1, (short) 1);
    }

    public String getTopicName() {
        return topicName;
    }
}
