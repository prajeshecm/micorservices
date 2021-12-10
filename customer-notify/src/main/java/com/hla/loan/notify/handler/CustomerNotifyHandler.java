package com.hla.loan.notify.handler;

import com.hla.loan.notify.model.Customer;
import com.hla.loan.notify.service.CustomerNotifyService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerNotifyHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerNotifyHandler.class);

    private CustomerNotifyService customerService;

    CustomerNotifyHandler(CustomerNotifyService customerService) {
        this.customerService = customerService;
    }

    @KafkaListener(topics = "${tpd.topic-name}",groupId = "Notify-process")
    public void listen(ConsumerRecord<String, Customer> wrappedData){
        LOGGER.info("Consumer data received  from partition {} offset{} and key {} value {}",wrappedData.partition(), wrappedData.offset(),wrappedData.key() , wrappedData.value());
    }

}
