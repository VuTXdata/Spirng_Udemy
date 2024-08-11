package com.vuhocspringboot.review_section6_springMVC.controller;

import com.vuhocspringboot.review_section6_springMVC.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Value("${listCv}")
    List<String> lsCv;

    @Value("${listLoaiCv}")
    List<String> lsLoaiCv;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping("/showInforEmpl")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("lsCv", lsCv);
        model.addAttribute("lsLoaiCv", lsLoaiCv);
        return "show-form";
    }

    @PostMapping("/processInforEmpl")
    public String processForm(
           @Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "show-form";
        }else return "process-form";
    }
}
