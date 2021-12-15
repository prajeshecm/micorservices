package com.hla.loan.service;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id="customer")
@Component
public class CustomerActuatorEndpoint {

    @ReadOperation
    public Map<String,String> getCustomerDetails(){

        Map<String,String> customerMap = new HashMap<>();

        customerMap.put("CustomerName", "John");
        customerMap.put("CustomerLocation", "N.C");
        customerMap.put("CustomerZip", "27523");
        return customerMap;
    }
}
