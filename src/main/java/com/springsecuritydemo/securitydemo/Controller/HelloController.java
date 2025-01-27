package com.springsecuritydemo.securitydemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(HttpServletRequest httpServletRequest){
        return "HEllo welcome " + httpServletRequest.getSession().getId();
    }
}
