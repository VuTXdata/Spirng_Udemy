package com.vuhocspringboot.springboot_crud_mvc_security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }
    @GetMapping("/leader")
    public String leader() {
        return "leader";
    }
    @GetMapping("/system")
    public String systemForm() {
        return "system";
    }
    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
