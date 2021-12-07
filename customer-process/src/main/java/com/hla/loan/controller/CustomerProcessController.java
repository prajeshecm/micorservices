package com.hla.loan.controller;

import com.hla.loan.dao.CustomerRepo;
import com.hla.loan.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerProcessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProcessController.class);

    private CustomerRepo customerRepo;

    CustomerProcessController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostMapping("/process")
    Customer processCustomer(@RequestBody Customer customer) {
        LOGGER.info("Customer details {} ", customer.toString());
        customerRepo.save(customer);
        LOGGER.info("Successfully saved Customer details ");
        return customer;
    }

    @GetMapping("/status/{id}")
    public Optional<Customer> getCustomerStatus(@PathVariable Long id) {
        LOGGER.info("Fetch Customer details  for {} ", id);
        Optional<Customer> customer =  customerRepo.findById(id);
        LOGGER.info("retrivied customer details are {}  ",customer);
        return customer;
    }
}
