package com.vuhocspringboot.springboot_crud_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login_form")
    public String login() {
        return "fancy-login";
    }
}
