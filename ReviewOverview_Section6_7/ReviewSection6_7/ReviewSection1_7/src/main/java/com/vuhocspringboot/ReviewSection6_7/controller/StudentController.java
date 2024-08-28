package com.vuhocspringboot.ReviewSection6_7.controller;

import com.vuhocspringboot.ReviewSection6_7.entity.Student;
import com.vuhocspringboot.ReviewSection6_7.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService service;
    @Value("${countries}")
    private List<String> countries;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", service.findAll());
        return "student/student_list_form";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries);
        return "student/student_add_form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", countries);
            return "student/student_add_form";
        }
        service.save(student);
        return "redirect:/student/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("temStu")int id, Model model) {
        model.addAttribute("student", service.findById(id));
        model.addAttribute("countries", countries);
        return "student/student_add_form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("temStu")int id) {
        service.delete(id);
        return "redirect:/student/list";
    }
}
