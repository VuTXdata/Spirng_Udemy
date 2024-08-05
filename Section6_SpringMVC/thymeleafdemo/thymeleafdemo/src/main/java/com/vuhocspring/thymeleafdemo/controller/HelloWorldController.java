package com.vuhocspring.thymeleafdemo.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/login")
    public String login() {
        return "login-form";
    }
    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }
    @RequestMapping("/homepageversion1")
    public String homepage(HttpServletRequest request, Model model) {
        String name = request.getParameter("stdName");
        name = name.toUpperCase() + "Welcome to Spring MVC";
        model.addAttribute("mesage", name);
        return homepage();
    }
    @RequestMapping("/homepageversion2")
    public String homepage(@RequestParam("stdName") String name, Model model) {
        name = name.toUpperCase() + "Welcome to Spring MVC version3 of adding date model";
        model.addAttribute("mesage", name);
        return homepage();
    }
}
