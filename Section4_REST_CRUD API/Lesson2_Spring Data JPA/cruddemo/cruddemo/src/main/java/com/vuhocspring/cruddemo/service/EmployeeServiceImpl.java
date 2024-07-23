package com.vuhocspring.cruddemo.service;

import com.vuhocspring.cruddemo.dao.EmployeeRespository;
import com.vuhocspring.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeRespository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        Employee em = null;
        Optional<Employee> employeeOptional = employeeDAO.findById(id);
        if (employeeOptional.isPresent()) {
            em = employeeOptional.get();
        }
        else{
            throw new RuntimeException("Employee not found");
        }
        return em;
    }
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
