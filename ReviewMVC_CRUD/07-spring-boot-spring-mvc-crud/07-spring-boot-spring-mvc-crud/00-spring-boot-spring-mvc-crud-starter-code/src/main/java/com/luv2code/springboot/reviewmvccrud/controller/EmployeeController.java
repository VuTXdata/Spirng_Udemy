package com.luv2code.springboot.reviewmvccrud.controller;

import com.luv2code.springboot.reviewmvccrud.entity.Employee;
import com.luv2code.springboot.reviewmvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/listemployee_form";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/addemployee_form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("temEmpl") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/updateemployee_form";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("temEmpl") int id) {
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}
