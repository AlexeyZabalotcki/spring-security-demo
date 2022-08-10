package com.alexey.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showHome(){

        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showExceptionPage(){

        return "access-denied";
    }
}
