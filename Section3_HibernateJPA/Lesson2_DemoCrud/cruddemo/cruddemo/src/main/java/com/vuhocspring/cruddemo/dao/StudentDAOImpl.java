package com.vuhocspring.cruddemo.dao;

import com.vuhocspring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudenDAO{
    private EntityManager em;

    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("select s from Student s order by firstName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = em.createQuery("select s from Student s where firstName like :thedata", Student.class);
        query.setParameter("thedata", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student st) {
        em.merge(st);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(findById(id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        int row = em.createQuery("delete from Student").executeUpdate();
        return row;
    }
}
