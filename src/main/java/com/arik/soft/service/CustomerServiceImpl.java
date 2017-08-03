package com.arik.soft.service;

import com.arik.soft.domain.Customer;
import com.arik.soft.domain.CustomerRepository;
import com.arik.soft.service.representation.CustomerRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<CustomerRepresentation> getCustomerDetails() {
        return StreamSupport
                .stream(customerRepository.findAll().spliterator(), false)
                .map(CustomerRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerRepresentation saveCustomer(CustomerRepresentation userData) {
        return new CustomerRepresentation(
                customerRepository.save(CustomerRepresentation.getCustomer(userData))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerRepresentation> getCustomersByFirstNameOrLastNameOrEmailOrPhoneNumber(
            String fName, String lName, String email, String phoneNumber) {
        List<Customer> customerList =
                customerRepository.getByFirstNameOrLastNameOrEmailOrPhoneNo(fName, lName, email, phoneNumber);
        if (customerList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return StreamSupport
                    .stream(
                            customerList.spliterator(),
                            false
                    )
                    .map(CustomerRepresentation::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerRepresentation getCustomerById(Long customerId) {
        return new CustomerRepresentation(customerRepository.findOne(customerId));
    }

    @Override
    @Transactional
    public void deleteCustomerById(Long customerId) {
        customerRepository.delete(customerId);
    }

    @Override
    @Transactional
    public CustomerRepresentation updateCustomer(CustomerRepresentation userData) {
        return new CustomerRepresentation(
                customerRepository.save(CustomerRepresentation.getCustomer(userData))
        );
    }
}
