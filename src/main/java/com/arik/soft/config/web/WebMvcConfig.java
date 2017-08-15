package com.arik.soft.config.web;

import com.arik.soft.service.representation.UserRepresentation;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WebMvcConfig {

    @GetMapping(value = "/")
    public String index() {
        return login();
    }

    @GetMapping(value = "/login")
    public String login() {
        if (isUserAuthenticated()) {
            return invoice();
        } else {
            return "login";
        }
    }

    private boolean isUserAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return !(auth instanceof AnonymousAuthenticationToken);
    }

    @GetMapping(value = "/invoice")
    public String invoice() {
        return "invoice";
    }


    @GetMapping(value = "/logout")
    public String logout() {
        return "";
    }
}
