package com.vuhocspring.demoonetoonerelationship;

import com.vuhocspring.demoonetoonerelationship.dao.AppDao;
import com.vuhocspring.demoonetoonerelationship.entity.Instructor;
import com.vuhocspring.demoonetoonerelationship.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoonetoonerelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoonetoonerelationshipApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao app) {
		return runner -> {
			//createInstructor(app);
			// findInstructor(app);
			// deleteInstructor(app);
			// findInstructorDetail(app);
			deleteInstructorDetail(app);
		};
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

