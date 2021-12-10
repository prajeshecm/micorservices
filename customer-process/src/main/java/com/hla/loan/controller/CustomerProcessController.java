package com.hla.loan.controller;

import com.hla.loan.model.Customer;
import com.hla.loan.service.CustomerProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerProcessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProcessController.class);

    private CustomerProcessService customerService;

    CustomerProcessController(CustomerProcessService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/process")
    Customer processCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Customer details {} ", customer.toString());
        customerService.processCustomer(customer);
        LOGGER.info("Successfully saved Customer details ");
        return customer;
    }

    @GetMapping("/status/{id}")
    public Optional<Customer> getCustomerStatus(@PathVariable Long id) {
        LOGGER.info("Fetch Customer details  for {} ", id);
        Optional<Customer> customer = customerService.findCustomerByid(id);
        LOGGER.info("retrivied customer details are {}  ", customer);
        return customer;
    }
}
