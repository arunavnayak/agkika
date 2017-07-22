package com.arik.soft.view;

import com.arik.soft.service.UserService;
import com.arik.soft.service.representation.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/user")
public class UserViewController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/{id}")
    public String user(@PathVariable final Long id, Model model) {
        UserRepresentation userDetail = userService.getUserById(id);
        model.addAttribute("user", userDetail);
        return "UserView";
    }
}
