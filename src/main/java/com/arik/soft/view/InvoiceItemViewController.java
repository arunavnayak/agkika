package com.arik.soft.view;

import com.arik.soft.service.UserService;
import com.arik.soft.service.representation.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/invoice-item")
public class InvoiceItemViewController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public String user(@PathVariable final Long id, Model model) {
        UserRepresentation userDetail = userService.getUserById(id);
        model.addAttribute("user", userDetail);
        return "userview";
    }
}
