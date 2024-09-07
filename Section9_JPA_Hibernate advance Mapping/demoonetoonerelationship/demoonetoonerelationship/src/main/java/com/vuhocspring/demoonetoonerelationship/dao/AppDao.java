package com.vuhocspring.demoonetoonerelationship.dao;

import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
