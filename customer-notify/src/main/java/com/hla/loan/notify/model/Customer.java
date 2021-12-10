package com.hla.loan.notify.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cust_details")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId ;

    @Column(name = "Cust_name")
    private String customerName ;

    @Column(name = "Cust_pay_month")
    private long customerSalary ;

    @Column(name = "Cust_dob")
    private Date customerDOB ;

    @Column(name = "Cust_ssn")
    private long customerSsn ;

    @Column(name = "Cust_address")
    private String custAddress ;

    @Column(name = "Cust_city")
    private String customerCity ;

    @Column(name = "Cust_state")
    private String customerState ;

    @Column(name = "Cust_loan_Amount")
    private long loanAmount ;

    @Column(name = "Cust_loan_Years")
    private long loanYears ;

    @Column(name = "Cust_email")
    private String customerEmail ;

    @Column(name = "Cust_phone")
    private long customerPhone ;

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

    public long getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(long customerSalary) {
        this.customerSalary = customerSalary;
    }

    public Date getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(Date customerDOB) {
        this.customerDOB = customerDOB;
    }

    public long getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(long customerSsn) {
        this.customerSsn = customerSsn;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public long getLoanYears() {
        return loanYears;
    }

    public void setLoanYears(long loanYears) {
        this.loanYears = loanYears;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(long customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerDOB=" + customerDOB +
                ", customerSsn=" + customerSsn +
                ", custAddress='" + custAddress + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerState='" + customerState + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanYears=" + loanYears +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone=" + customerPhone +
                '}';
    }
}
