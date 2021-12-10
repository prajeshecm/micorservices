package com.hla.loan.service;

import com.hla.loan.config.KafkaProducerConfig;
import com.hla.loan.dao.CustomerRepo;
import com.hla.loan.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerProcessService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(CustomerProcessService.class);

    private final CustomerRepo customerRepo;
    private final KafkaTemplate kafkaTemplate;
    private final KafkaProducerConfig kafkaProducerConfig;

    public CustomerProcessService(CustomerRepo customerRepo, KafkaTemplate kafkaTemplate, KafkaProducerConfig kafkaProducerConfig) {
        this.customerRepo = customerRepo;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProducerConfig = kafkaProducerConfig;
    }

    public void processCustomer(Customer customer) throws Exception {
        saveCustomerToDB(customer);
        produceCustomerDetailsToKafka(customer);

    }

    private void produceCustomerDetailsToKafka(Customer customer) {
        LOGGER.info("Sending to Kafka ....");
        kafkaTemplate.send(kafkaProducerConfig.getTopicName(),customer);
        LOGGER.info("successfully sent to kafka");

    }

    private void saveCustomerToDB(Customer customer) {
        LOGGER.info("saving to repo ....");
        customerRepo.save(customer);
        LOGGER.info("successfully saved to repo ....");
    }

    public Optional<Customer> findCustomerByid(Long customerId) {
        return customerRepo.findById(customerId);
    }
}
