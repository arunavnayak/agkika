package com.arik.soft.view;

import com.arik.soft.service.CustomerService;
import com.arik.soft.service.representation.CustomerRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/customer")
public class CustomerViewController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/{id}")
    public String customer(@PathVariable final Long id, Model model) {
        CustomerRepresentation customerDetail = customerService.getCustomerById(id);
        model.addAttribute("customer", customerDetail);
        return "CustomerView";
    }
}
