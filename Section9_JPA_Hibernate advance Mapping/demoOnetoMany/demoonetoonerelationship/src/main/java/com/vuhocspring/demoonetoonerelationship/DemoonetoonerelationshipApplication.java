package com.vuhocspring.demoonetoonerelationship;

import com.vuhocspring.demoonetoonerelationship.dao.AppDao;
import com.vuhocspring.demoonetoonerelationship.entity.Course;
import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;
import com.vuhocspring.demoonetoonerelationship.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoonetoonerelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoonetoonerelationshipApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao app) {
		return runner -> {
			// creatCourseAndStudent(app);
			//findCourseAndStudentById(app);
			// findStudentAndCourseById(app);
			addMoreCourseForStudent(app);
		};
	}

	private void addMoreCourseForStudent(AppDao app) {
		int theId = 2;
		Student st = app.findStudentAndCourseByStudentId(theId);
		Course c1 = new Course("Algorithm");
		Course c2 = new Course("Data Structure");
		System.out.println("Before: " );
		System.out.println("Student: " + st);
		System.out.println("CourseS: " + st.getCourses());
		st.addCourse(c1);
		st.addCourse(c2);
		System.out.println("After: ");
		System.out.println("Student: " + st);
		System.out.println("CourseS: " + st.getCourses());
		app.update(st);
		System.out.println("Done!");
	}

	private void findStudentAndCourseById(AppDao app) {
		int theId = 6;
		Student s = app.findStudentAndCourseByStudentId(theId);
		System.out.println("Student: " + s);
		System.out.println("Courses: " + s.getCourses());
	}

	private void findCourseAndStudentById(AppDao app) {
		int theId = 11;
		Course c = app.findCourseAndStudentByCourseId(theId);
		System.out.println("Course: " + c);
		System.out.println("Student: " + c.getStudents());
	}

	private void creatCourseAndStudent(AppDao app) {
		Course course1 = new Course("Java For Everyone");
		Student s2 = new Student("Nga", "Pham", "Nga123@gmail.com");
		course1.addStudent(s2);
		// s2.addCourse(course1);
		System.out.println("Course: " + course1);
		System.out.println("Student join: " + course1.getStudents());
		// System.out.println("COurse of student: " + s2.getCourses());
		app.save(course1);
	}

	private void findInstructorByIdJoinFetch(AppDao app) {
		int theid = 1;
		Instructor instructor = app.findInstructorByIdJoinFetch(theid);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println(instructor.getInstructorDetail());
	}

	private void findCourseByInstructorId(AppDao app) {
		int theId = 1;
		Instructor instructor = app.findById(theId);
		System.out.println("instructor: " + instructor);
		List<Course> courses = app.findCourseByInstructorId(instructor.getId());
		instructor.setCourses(courses);
		System.out.println(courses);
	}

	private void findInstructorWithCourse(AppDao app) {
		int id = 1;
		System.out.println("Find Instructor with id: " + id);
		Instructor instructor = app.findById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Course" + instructor.getCourses());
	}

	private void createInstructorWithCourse(AppDao app) {
		Instructor instructor = new Instructor("Vu", "public", "vu@gmail.com");
		//
		InstructorDetail instructorDetail = new InstructorDetail("http://www.org.com", "LuV2Code");
		//
		instructor.setInstructorDetail(instructorDetail);
		//
		Course s1 = new Course("Java");
		Course s2 = new Course("Python");
		instructor.addCourse(s1);
		instructor.addCourse(s2);
		System.out.println("Instructor: " + instructor);
		System.out.println("Course 1" + instructor.getCourses());
		app.save(instructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDao app) {
		app.deleteInstructorDetailById(3);
	}

	private void findInstructorDetail(AppDao app) {
		int id = 3;
		InstructorDetail detail = app.findInstructorDetailById(id);
		System.out.println(detail);
		System.out.println(detail.getInstructor());
	}

	private void deleteInstructor(AppDao app) {
		int id = 2;
		app.deleteInstructorById(id);
	}

	private void findInstructor(AppDao app) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor in = app.findById(id);
		System.out.println("Found instructor: " + in);
		System.out.println("Detail " + in.getInstructorDetail());
	}

	private void createInstructor(AppDao app) {
		Instructor instructor = new Instructor("Vu", "Tran", "vu@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.org.com", "LuV2Code");

		instructor.setInstructorDetail(instructorDetail);

		app.save(instructor);
	}
}

