package com.vuhocspring.cruddemo.rest;

import com.vuhocspring.cruddemo.entity.Employee;
import com.vuhocspring.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Tương tự như trong JpaRepository chúng ta cos thể tạo nhiều API liên quan đến các Entity mà không cần cài đặt chi tiết từng cái
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = service.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found" + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return service.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee newEmployee = service.save(employee);
        return newEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
       Employee employee = service.findById(employeeId);
       if (employee == null) {
           throw new RuntimeException("Employee not found" + employeeId);
       }
       service.delete(employeeId);
       return "Employee deleted";
    }
}
