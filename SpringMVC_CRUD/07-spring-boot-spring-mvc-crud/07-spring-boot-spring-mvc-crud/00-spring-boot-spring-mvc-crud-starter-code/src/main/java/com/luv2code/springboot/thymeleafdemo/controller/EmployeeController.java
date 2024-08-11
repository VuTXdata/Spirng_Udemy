package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String showForm(Model model) {
        List<Employee> ls = employeeService.findAll();
        model.addAttribute("listEmpl", ls);
        return "employees/showForm";
    }
    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/showFormAdd";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
            employeeService.save(employee);
            return "redirect:/employee/list";
    }
    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employId") int employId, Model model) {
        Employee employee = employeeService.findById(employId);
        model.addAttribute("employee", employee);
        return "employees/showFormAdd";
    }
    @GetMapping("/showFormDelete")
    public String showFormDelete(@RequestParam("employId") int employId) {
        employeeService.deleteById(employId);
        return "redirect:/employee/list";
    }

}
