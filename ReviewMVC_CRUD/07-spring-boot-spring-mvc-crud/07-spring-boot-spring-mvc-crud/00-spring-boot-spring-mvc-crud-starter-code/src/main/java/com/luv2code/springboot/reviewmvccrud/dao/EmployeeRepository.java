package com.luv2code.springboot.reviewmvccrud.dao;

import com.luv2code.springboot.reviewmvccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
