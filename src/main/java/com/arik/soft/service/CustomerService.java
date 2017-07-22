package com.arik.soft.service;

import com.arik.soft.service.representation.CustomerRepresentation;

import java.util.List;

public interface CustomerService {
    List<CustomerRepresentation> getCustomerDetails();

    CustomerRepresentation saveCustomer(CustomerRepresentation userData);

    List<CustomerRepresentation> getCustomersByFirstNameOrLastNameOrEmailOrPhoneNumber(
            String fName, String lName, String email, String phoneNumber
    );

    CustomerRepresentation getCustomerById(Long customerId);

    void deleteCustomerById(Long customerId);

    CustomerRepresentation updateCustomer(CustomerRepresentation userData);
}
