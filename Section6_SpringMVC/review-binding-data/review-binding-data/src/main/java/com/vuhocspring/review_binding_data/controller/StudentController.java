package com.vuhocspring.review_binding_data.controller;


import com.vuhocspring.review_binding_data.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${languages}")
    List<String> favorLanguages;

    @Value("${operatingSystem}")
    List<String> operSystems;

    @Value("${countries}")
    List<String> countries;

    @GetMapping("/InforStudentForm")
    public String showInfoStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("favorLanguages", favorLanguages);
        model.addAttribute("operatingSystems", operSystems);
        model.addAttribute("countries", countries);
        return "inforStudentForm";
    }
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        return "processStudentForm";
    }
}
