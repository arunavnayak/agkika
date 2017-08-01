package com.arik.soft.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class TestMvcController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        String str = "Hello World!";
        mav.addObject("message", str);
        return mav;
    }
}
