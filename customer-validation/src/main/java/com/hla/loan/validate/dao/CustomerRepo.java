package com.hla.loan.validate.dao;

import com.hla.loan.validate.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  {

    void processCustomer(Customer customer);

}
