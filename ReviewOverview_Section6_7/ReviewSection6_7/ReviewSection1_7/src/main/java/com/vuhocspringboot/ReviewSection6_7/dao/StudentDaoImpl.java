package com.vuhocspringboot.ReviewSection6_7.dao;

import com.vuhocspringboot.ReviewSection6_7.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    private EntityManager manager;
    @Autowired
    public StudentDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            this.manager.persist(student); // Thêm mới sinh viên
        } else {
            this.manager.merge(student); // Cập nhật sinh viên đã tồn tại
        }
    }

    @Override
    public Student findById(int id) {
        return manager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = manager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public void update(Student student) {
        manager.merge(student);
    }

    @Override
    public void delete(int id) {
        manager.remove(findById(id));
    }

    @Override
    public int deleteAll() {
        int r = manager.createQuery("delete from Student").executeUpdate();
        return r;
    }

    @Override
    public List<Student> findByAddress(String address) {
        TypedQuery<Student> query = manager.createQuery("select s from Student s where address like :tem", Student.class);
        query.setParameter("tem", "%" + address + "%");
        return query.getResultList();
    }
}
