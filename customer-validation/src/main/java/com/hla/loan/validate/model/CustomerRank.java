package com.hla.loan.validate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document("customerRank")
public class CustomerRank implements Serializable {

    @Id
    private long customerId ;

    private String customerName ;

    private long customerSsn ;

    private Date customerDOB ;

    private long customerScore ;

    private String custType ;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(long customerSsn) {
        this.customerSsn = customerSsn;
    }

    public Date getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(Date customerDOB) {
        this.customerDOB = customerDOB;
    }

    public long getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(long customerScore) {
        this.customerScore = customerScore;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }
}
