package com.vuhocspring.thymeleafdemo.controller;

import com.vuhocspring.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${lsSystem}")
    private List<String> os;

    @GetMapping("/showStudentForm")
    public  String showForm(Model model)
    {
        Student st = new Student();
        model.addAttribute("student", st);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("os", os);
        return "studentform";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student st)
    {
        System.out.println(st.firstName + " " + st.lastName);
        return "confirmStudentForm";
    }
}
