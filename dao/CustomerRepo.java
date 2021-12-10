package com.hla.loan.dao;

import com.hla.loan.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer,Long> {

    void processCustomer(Customer customer);

}
