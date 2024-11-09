package com.projects.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.projects.springboot.entity.Student;
import com.projects.springboot.service.StudentService;

@Controller
public class StudentController {
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

//Display list of students 
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "list_students";

	}

//Create student form
	@GetMapping("/students/new")
	public String createStudentform(Model model) {
		Student stu = new Student();
		model.addAttribute("student", stu);
		return "create_students";

	}

//saving the student data
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";

	}

//Edit student form
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";

	}

//update the existing student by id 
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from database by id
		Student updatestudent = studentService.getStudentById(id);
		updatestudent.setId(id);
		updatestudent.setFirstName(student.getFirstName());
		updatestudent.setLastName(student.getLastName());
		updatestudent.setEmail(student.getEmail());

		// save updated student object
		studentService.updateStudent(updatestudent);
		return "redirect:/students";
	}

//deleting the existing student by id 
	@GetMapping("/students/{id}")
	public String deleteStudents(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";

	}
}
