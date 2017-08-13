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
        return invoice();
    }

    @GetMapping(value = "/view/invoice")
    public String invoice() {
        return "invoice";
    }

    @GetMapping(value = "/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            return "invoice";
        }
        return "index";
    }


    @GetMapping(value = "/logout")
    public String logout() {
        return "";
    }
}
