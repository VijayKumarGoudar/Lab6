package com.greatlearning.lab6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lab6.entity.Student;
import com.greatlearning.lab6.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	public void createStudent(Student student) {
		studentRepo.save(student);
	}

	public Student getStudent(long id) {
		return studentRepo.findById(id).orElse(null);
	}

	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
		
	}

}
