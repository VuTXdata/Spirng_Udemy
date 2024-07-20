package com.vuhocspring.cruddemo.dao;

import com.vuhocspring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}
