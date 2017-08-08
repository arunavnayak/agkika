package com.arik.soft.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebMvcConfig {

    @GetMapping(value = "/invoice")
    public String invoice() {
        return "invoice";
    }
}
