package com.vuhocspring.cruddemo;

import com.vuhocspring.cruddemo.dao.StudenDAO;
import com.vuhocspring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudenDAO studenDAO) {
		return runner -> {
			createStudent(studenDAO);

			// readStudent(studenDAO);

			// queryForStudent(studenDAO);

			// queryForStudentByFirstName(studenDAO);

			// updateStudent(studenDAO);

			// deleteStudent(studenDAO);

			//deleteAllStudent(studenDAO);
		};
	}

	private void deleteAllStudent(StudenDAO studenDAO) {
		int row = studenDAO.deleteAll();
		System.out.println("Deleted " + row + " students");
	}

	private void deleteStudent(StudenDAO studenDAO) {
		int studentId = 3;
		Student st = studenDAO.findById(studentId);
		System.out.println(st);
		studenDAO.delete(studentId);
		st = studenDAO.findById(studentId);
		System.out.println(st);
	}

	private void updateStudent(StudenDAO studenDAO) {
		// Find student update
		int studentId = 1;
		System.out.println("Getting student with id");
		Student st = studenDAO.findById(studentId);
		System.out.println(st);
		System.out.println("Updating student");
		st.setFirstName("Test updating");
		studenDAO.update(st);
		System.out.println(st);
	}

	private void queryForStudentByFirstName(StudenDAO studenDAO) {
		List<Student> students = studenDAO.findByName("Vu");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudent(StudenDAO studenDAO) {
		// display result
		List<Student> students = studenDAO.findAll();
		for (Student student2 : students) {
			System.out.println(student2);
		}
	}

	private void readStudent(StudenDAO studenDAO) {
		System.out.println("Create new student test");
		Student student = new Student("A", "B", "C");
		System.out.println("Saving...");
		studenDAO.save(student);
		System.out.println("ID: " + student.getId());
		Student result = studenDAO.findById(7);
		if (result != null) {
			System.out.println("Successfully saved student with ID: " + student.getId());
		}
		else
		{
			System.out.println("Student not found");
		}
	}

	private void createStudent(StudenDAO studenDAO) {
		// Create student object
		System.out.println("Creating new student object.....");
		Student student = new Student("Nga", "Pham" ,"Pham Tuyet Nga");
		// Save infor student
		System.out.println("Saving student object.....");
		studenDAO.save(student);
		// display result
		System.out.println("Student object created successfully...." + " ID: " + student.getId());
	}
}
