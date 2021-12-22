package com.hla.loan.service;

import com.hla.loan.config.KafkaProducerConfig;
import com.hla.loan.dao.CustomerRepo;
import com.hla.loan.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.RestTemplate;

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
        //String uri = "http://localhost:8183/customer/validate/customer";
        String uri = "http://localhost:8183/customer/validateTest";
        LOGGER.info("Calling a customer validate service ..");
        RestTemplate restTemplate = new RestTemplate();
        //Customer Customer =  restTemplate.getForObject(uri,Customer.class);
       // LOGGER.info("response from validate service  {} ..",Customer);
        saveCustomerToDB(customer);
       // produceCustomerDetailsToKafka(customer);
        sendMessageAsListenable(customer);

    }

    private void produceCustomerDetailsToKafka(Customer customer) {
        LOGGER.info("Sending to Kafka ....");
        kafkaTemplate.send(kafkaProducerConfig.getTopicName(),customer.getCustomerName(), customer);
        LOGGER.info("successfully sent to kafka");
    }

    public void sendMessageAsListenable(Customer customer) {
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(kafkaProducerConfig.getTopicName(), customer);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("Sent customer=[" + customer +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.info("Unable to send customer=["
                        + customer + "] due to : " + ex.getMessage());
            }
        });
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
