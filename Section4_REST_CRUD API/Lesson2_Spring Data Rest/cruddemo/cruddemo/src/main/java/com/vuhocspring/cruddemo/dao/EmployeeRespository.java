package com.vuhocspring.cruddemo.dao;

import com.vuhocspring.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
