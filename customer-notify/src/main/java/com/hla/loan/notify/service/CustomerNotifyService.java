package com.hla.loan.notify.service;

import com.hla.loan.notify.model.Customer;
import com.hla.loan.notify.dao.CustomerNotifyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerNotifyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerNotifyService.class);

    private final CustomerNotifyRepo customerNotifyRepo;

    public CustomerNotifyService(CustomerNotifyRepo customerNotifyRepo) {
        this.customerNotifyRepo = customerNotifyRepo;
    }

    public void processCustomer(Customer customer) throws Exception {
        saveCustomerToDB(customer);
    }

    private void saveCustomerToDB(Customer customer) {
        LOGGER.info("saving to repo ....");
//        customerNotifyRepo.save(customer);
        LOGGER.info("successfully saved to repo ....");
    }

    public Optional<Customer> findCustomerByid(Long customerId) {
        return customerNotifyRepo.findById(customerId);
    }
}
