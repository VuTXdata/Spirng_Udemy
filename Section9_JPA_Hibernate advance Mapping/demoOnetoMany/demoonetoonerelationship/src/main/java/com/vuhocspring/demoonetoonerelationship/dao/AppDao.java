package com.vuhocspring.demoonetoonerelationship.dao;

import com.vuhocspring.demoonetoonerelationship.entity.Course;
import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;
import com.vuhocspring.demoonetoonerelationship.entity.Student;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructorId(int theid);

    Instructor findInstructorByIdJoinFetch(int theid);

    void save(Course course);

    Course findCourseAndStudentByCourseId(int theid);

    Student findStudentAndCourseByStudentId(int theid);

    void update(Student student);
}
