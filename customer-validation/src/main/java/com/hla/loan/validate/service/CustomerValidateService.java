package com.hla.loan.validate.service;

import com.hla.loan.validate.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerValidateService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(CustomerValidateService.class);

  /*  private final CustomerRepo customerRepo;

    public CustomerValidateService(CustomerRepo customerRepo ) {
        this.customerRepo = customerRepo;
    }*/

    public void processCustomer(Customer customer) throws Exception {
        saveCustomerToDB(customer);

    }




    private void saveCustomerToDB(Customer customer) {
        LOGGER.info("saving to repo ....");
       // customerRepo.save(customer);
        LOGGER.info("successfully saved to repo ....");
    }

    public Optional<Customer> findCustomerByid(Long customerId) {
        //return customerRepo.findById(customerId);
        return null;
    }



}
