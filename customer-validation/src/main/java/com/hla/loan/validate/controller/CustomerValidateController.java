package com.hla.loan.validate.controller;

import com.hla.loan.validate.service.CustomerValidateService;
import com.hla.loan.validate.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerValidateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerValidateController.class);

    private CustomerValidateService customerService;

    CustomerValidateController(CustomerValidateService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/validate")
    Customer processCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Customer Validate details {} ", customer.toString());
        //  customerService.processCustomer(customer);
        LOGGER.info("Successfully saved Customer details ");
        return customer;
    }

    @GetMapping("/validateTest")
    Customer processCustomerTest() throws Exception {
        LOGGER.info("Customer Validate details ");
        //  customerService.processCustomer(customer);
        Customer customer = new Customer();
        customer.setCustomerName("dummy");
         LOGGER.info("Successfully saved Customer details ");
        return customer;
    }


    @PutMapping("/bkg")
    public String getCustomerStatus(@RequestBody List<Customer> customer) {
        customer.stream().forEach(customerVar -> System.out.println(customerVar));
        LOGGER.info("Fetch Customer details  for {} ", customer);
        return "Success";
    }
}
