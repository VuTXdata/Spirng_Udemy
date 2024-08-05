package com.vuhocspring.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", LocalDateTime.now());
        return "helloword";
    }

    @GetMapping("/homepage")
    public String homepage(Model model){
        model.addAttribute("theTime", LocalDateTime.now().getHour());
        return "homepage";
    }
}
