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

    private final CustomerProcessService customerService;

    CustomerProcessController(CustomerProcessService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/process")
    public Customer processCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Customer details {} ", customer.toString());
       // cpuMonitor();
        customerService.processCustomer(customer);
        LOGGER.info("Successfully saved Customer details ");
        return customer;
    }

    /**
     * this method is just to monitor the CPU usage in grafana.
     *
     */
    private void cpuMonitor() {
        LOGGER.info("Please check CPU level :  ");
        while(true){
            Runnable runnable = () ->{
               while (true) {}
            };
            new Thread(runnable).start();
            LOGGER.info("runnable details {} :  ",runnable.toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }
    }

    @GetMapping("/status/{id}")
    public Optional<Customer> getCustomerStatus(@PathVariable Long id) {
        LOGGER.info("Fetch Customer details  for {} ", id);
        Optional<Customer> customer = customerService.findCustomerByid(id);
        LOGGER.info("retrivied customer details are {}  ", customer);
        return customer;
    }


    @GetMapping("/test")
    public String getApiStatus() {
        LOGGER.info("Called getApiStatus ");
        return "Successfully Called...";
    }
}
