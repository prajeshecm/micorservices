package com.hla.loan.notify.dao;

import com.hla.loan.notify.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNotifyRepo extends JpaRepository<Customer,Long> {

  //  void notifyCustomer(Customer customer);

}
