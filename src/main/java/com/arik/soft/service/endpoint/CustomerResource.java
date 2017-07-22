package com.arik.soft.service.endpoint;

import com.arik.soft.domain.Customer;
import com.arik.soft.service.CustomerService;
import com.arik.soft.service.representation.CustomerRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity customerDetails() {
        return new ResponseEntity(customerService.getCustomerDetails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerDetails(@PathVariable final Long id) {
        return new ResponseEntity(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity addNewCustomer(@NotNull @RequestBody final CustomerRepresentation customerRepresentation) {
        Customer customer = CustomerRepresentation.getCustomer(customerRepresentation);

        return new ResponseEntity(
                customerService.saveCustomer(new CustomerRepresentation(customer)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomerDetails(@PathVariable final Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity updateCustomerDetails(
            @NotNull @RequestBody final CustomerRepresentation representation){
        customerService.updateCustomer(representation);
        return new ResponseEntity(HttpStatus.OK);
    }

}
