package com.arik.soft.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> getByFirstNameOrLastNameOrEmailOrPhoneNo(
            String fName, String lName, String email, String phoneNumber
    );
}
