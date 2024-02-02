package com.kiran.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.restapi.entity.Student;
import com.kiran.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;

	// Get - localhost:8000/student
	@GetMapping("/student")
	public List<Student> getAllStudent() {

		List<Student> students = repo.findAll();
		return students;

	}

	// Get - localhost:8000/student/1
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {

		Student student = repo.findById(id).get();
		return student;
	}

	// Post - localhost:8000/student/create
	@PostMapping("/student/create")
		@ResponseStatus(code= HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
			
			repo.save(student);
		}

	// Post - localhost:8000/student/2
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("kiran");
		student.setPercentage(86);
		repo.save(student);
		return student;
	}

	// Post - localhost:8000/student/delete
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
	    Student student = repo.findById(id).get();
	    repo.delete(student);
	}


}
