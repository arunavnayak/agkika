package com.arik.soft.service.representation;

import com.arik.soft.domain.Customer;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerRepresentation {

    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String address;

    public CustomerRepresentation(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.firstName = customer.getFirstName();
        this.middleName = customer.getMiddleName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.phoneNo = customer.getPhoneNo();
        this.address = customer.getAddress();
    }

    public static Customer getCustomer(CustomerRepresentation representation){
        Customer customer = new Customer();
        customer.setFirstName(representation.getFirstName());
        customer.setMiddleName(representation.getMiddleName());
        customer.setLastName(representation.getLastName());
        customer.setAddress(representation.getAddress());
        customer.setEmail(representation.getEmail());
        customer.setPhoneNo(representation.getPhoneNo());
        return customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
