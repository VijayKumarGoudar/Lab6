package com.greatlearning.lab6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.lab6.entity.Student;
import com.greatlearning.lab6.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	
	@GetMapping("/students")
	public String getStudents(Model model) {
		List<Student> studentList = studentService.getStudents();
		model.addAttribute("studentList", studentList);
		return "students";
	}
	
	@GetMapping("/showStudentForm")
	public String showNewStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/createStudent")
	public String createStudent(@ModelAttribute("student") Student student) {
		studentService.createStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/editStudentForm/{id}")
	public String editStudentForm(@PathVariable("id") long id, Model model) {

		Student student = studentService.getStudent(id);
		model.addAttribute("student", student);
		return "edit_student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteTicket(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
