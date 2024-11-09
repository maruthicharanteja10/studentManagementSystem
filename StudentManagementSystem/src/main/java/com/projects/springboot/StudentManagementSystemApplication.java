package com.projects.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projects.springboot.entity.Student;
import com.projects.springboot.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication {
//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Student student1 = new Student("charan", "Tej", "tej@gmail.com");
//		studentRepository.save(student1);
//		Student student2 = new Student("maruthi", "charan", "charan@gmail.com");
//		studentRepository.save(student2);
//		Student student3 = new Student("virat", "kohli", "kohli@gmail.com");
//		studentRepository.save(student3);
//		System.out.println("Students is saved succesfully");
//	}
}
