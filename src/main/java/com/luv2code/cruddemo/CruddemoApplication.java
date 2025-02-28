package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
		//	createStudent(studentDAO);

			createMultipleStudents(studentDAO);

		//	readStudent(studentDAO);

		//	queryForStudents(studentDAO);

		//	queryForStudentsByLastName(studentDAO);

		//	updateStudent(studentDAO);

		//	deleteStudent(studentDAO);

		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 9;
		System.out.println("Deleting Student Id: " + studentId);
		studentDAO.Delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student with id: primary key
		int studentId = 8;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change firstname to scooby
		System.out.println("Updating the Student");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display updated student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudent = studentDAO.findByLastName("Doe");

		//		display list of students
		for (Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//	 get a list of students
		List<Student> theStudent = studentDAO.findAll();

		//	display list of students
		for(Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//	create a Student Object
		System.out.println("Creating new Student Object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		//	save the student
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent);

		//	display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated Id: " + theId);

		//	retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//	display student
		System.out.println("Found the Student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new Student ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student object
		System.out.println("Saving the Students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//	create the student object
		System.out.println("Creating new Student ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		//	save the student object
		System.out.println("Save the Student ...");
		studentDAO.save(tempStudent);

		//	display id of the saved student
		System.out.println("Saved student. Generated Id: " + tempStudent.getId());

	}
}
