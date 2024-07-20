package com.vuhocspring.cruddemo.dao;

import com.vuhocspring.cruddemo.entity.Student;

import java.util.List;

public interface StudenDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void update(Student st);

    void delete(int id);

    int deleteAll();
}
