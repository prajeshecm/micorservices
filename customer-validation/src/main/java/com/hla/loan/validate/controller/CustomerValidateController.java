package com.hla.loan.validate.controller;

import com.hla.loan.validate.model.CustomerRank;
import com.hla.loan.validate.model.CustomerRankList;
import com.hla.loan.validate.service.CustomerValidateService;
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
    CustomerRank processCustomer(@RequestBody CustomerRank customerRank) throws Exception {
        LOGGER.info("Customer Validate details {} ", customerRank.toString());
        //  customerService.processCustomer(customer);
        LOGGER.info("Successfully saved Customer details ");
        return customerRank;
    }

    @GetMapping("/validateTest")
    CustomerRank processCustomerTest() throws Exception {
        LOGGER.info("Customer Validate details ");
        //  customerService.processCustomer(customer);
        CustomerRank customerRank = new CustomerRank();
        customerRank.setCustomerName("dummy");
         LOGGER.info("Successfully saved Customer details ");
        return customerRank;
    }


    @PutMapping("/bkg")
    public String getCustomerStatus(@RequestBody CustomerRankList customerRank) throws Exception {
        LOGGER.info("customerRank {} ",customerRank);
       // customerRank.stream().forEach(customerRankVar -> System.out.println(customerRankVar));
        LOGGER.info("Fetch Customer details  for {} ", customerRank);
        customerService.processCustomer(null);
        return "Success";
    }

    @PutMapping("/bkg2")
    public String getCustomerStatus2(@RequestBody List<CustomerRank> customerRank) throws Exception {
        LOGGER.info("customerRank {} ",customerRank);
        customerRank.stream().forEach(customerRankVar -> System.out.println(customerRankVar));
        LOGGER.info("Fetch Customer details  for {} ", customerRank);
        customerService.processCustomer(customerRank);
        return "Success";
    }
}
