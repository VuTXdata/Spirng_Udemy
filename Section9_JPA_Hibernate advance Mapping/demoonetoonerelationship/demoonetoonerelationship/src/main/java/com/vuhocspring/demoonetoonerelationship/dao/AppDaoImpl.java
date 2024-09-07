package com.vuhocspring.demoonetoonerelationship.dao;

import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager manager;
    @Autowired
    public AppDaoImpl(EntityManager manager) {
        this.manager = manager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return manager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        manager.remove(findById(id));
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return manager.find(InstructorDetail.class, id);
    }

    @Override
    public void deleteInstructorDetailById(int id) {
        manager.remove(findInstructorDetailById(id));
    }
}
