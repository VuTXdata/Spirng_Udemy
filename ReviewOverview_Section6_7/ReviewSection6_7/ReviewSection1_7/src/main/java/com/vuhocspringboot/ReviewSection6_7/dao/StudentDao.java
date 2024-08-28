package com.vuhocspringboot.ReviewSection6_7.dao;

import com.vuhocspringboot.ReviewSection6_7.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    void update(Student student);

    void delete(int id);

    int deleteAll();

    List<Student> findByAddress(String address);
}
