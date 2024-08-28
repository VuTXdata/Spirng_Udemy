package com.vuhocspringboot.ReviewSection6_7.service;

import com.vuhocspringboot.ReviewSection6_7.dao.StudentDao;
import com.vuhocspringboot.ReviewSection6_7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentServiceImpl implements  StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public int deleteAll() {
        return studentDao.deleteAll();
    }

    @Override
    public List<Student> findByAddress(String address) {
        return studentDao.findByAddress(address);
    }
}
