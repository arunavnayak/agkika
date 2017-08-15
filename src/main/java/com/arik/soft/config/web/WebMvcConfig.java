package com.arik.soft.config.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
