package com.alexey.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    @GetMapping("/admins")
    public String showAdminsPage() {

        return "admins";
    }

    @GetMapping("/userplus")
    public String showUserPlusPage() {

        return "userPlus";
    }
}
