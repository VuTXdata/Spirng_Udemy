package com.vuhocspring.demoonetoonerelationship.dao;

import com.vuhocspring.demoonetoonerelationship.entity.Course;
import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;
import com.vuhocspring.demoonetoonerelationship.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Course> findCourseByInstructorId(int theid) {
        TypedQuery<Course> query = manager.createQuery(
            "from Course where instructor.id=:theid", Course.class
        );
        query.setParameter("theid", theid);
        List<Course> courses = query.getResultList();
        return courses;
    }
    @Override
    @Transactional
    public void save(Course course) {
            manager.persist(course);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theid) {
        TypedQuery<Course> query = manager.createQuery(
            "select c from Course c " +
                    "join FETCH c.students " +
                    "where c.id = :theid", Course.class
        );
        query.setParameter("theid", theid);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseByStudentId(int theid) {
        TypedQuery<Student> query = manager.createQuery(
            "select s from Student s " +
            "join  fetch s.courses " +
            "where s.id = :theid", Student.class
        );
        query.setParameter("theid", theid);
        return query.getSingleResult();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theid) {
        TypedQuery<Instructor> query = manager.createQuery(
                "select i from Instructor i"
                        + " JOIN FETCH i.courses"
                        + " where i.id =:theid", Instructor.class
        );
        query.setParameter("theid", theid);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        manager.merge(student);
    }
}
