package com.arik.soft.view;

import com.arik.soft.service.UserService;
import com.arik.soft.service.representation.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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


    @PostMapping(value = "/register")
    public String registerUser(@Valid @ModelAttribute("user") UserRepresentation user,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        UserRepresentation userRepresentation = userService.saveUser(user);

        model.addAttribute("id", userRepresentation.getUserId());
        model.addAttribute("name", userRepresentation.getUserName());
        model.addAttribute("email", userRepresentation.getEmail());
        return "UserCreated";
    }
}
