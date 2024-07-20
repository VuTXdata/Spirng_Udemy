package com.vuhocspringboot.demo.rest;

import com.vuhocspringboot.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<Student>();
        students.add(new Student("A", "A1"));
        students.add(new Student("B", "B1"));
        students.add(new Student("C", "C1"));
    }
    // define endpoint for "/students" return a lisf of student
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        // check student id
        if(studentId >= students.size() || studentId < 0)
        {
            throw new StudentNotFoundException("Student not found - " + studentId);
        }
        return students.get(studentId);
    }
}
