package com.vuhocspring.cruddemo.dao;

import com.vuhocspring.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
// Sử dụng JpaReponsitory thì không cần triển khai class Impl này nữa
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager em;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> theQuery = em.createQuery("from Employee", Employee.class);

        // Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
