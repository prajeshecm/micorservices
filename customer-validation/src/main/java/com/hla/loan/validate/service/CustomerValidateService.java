package com.hla.loan.validate.service;

import com.hla.loan.validate.dao.CustomerRepo;
import com.hla.loan.validate.model.CustomerRank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerValidateService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(CustomerValidateService.class);

    private final CustomerRepo customerRepo;

    public CustomerValidateService(CustomerRepo customerRepo ) {
        this.customerRepo = customerRepo;
    }

    public void processCustomer(List<CustomerRank> customerRank) throws Exception {
        saveCustomerToDB(customerRank);

    }

    private void saveCustomerToDB(List<CustomerRank> customerRank) {
        LOGGER.info("saving to repo ....");
        customerRank.stream().forEach(rank -> customerRepo.save(rank));
        LOGGER.info("successfully saved to repo ....");
    }

    public Optional<CustomerRank> findCustomerByid(Long customerId) {
        //return customerRepo.findById(customerId);
        return null;
    }



}
