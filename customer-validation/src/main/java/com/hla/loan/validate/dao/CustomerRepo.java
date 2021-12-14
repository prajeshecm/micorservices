package com.hla.loan.validate.dao;

import com.hla.loan.validate.model.CustomerRank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends MongoRepository<CustomerRank, String> {
    void processCustomer(CustomerRank customerRank);

}
