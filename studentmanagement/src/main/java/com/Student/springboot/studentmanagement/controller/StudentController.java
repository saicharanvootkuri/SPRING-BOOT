package com.Student.springboot.studentmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.springboot.studentmanagement.entity.Student;
import com.Student.springboot.studentmanagement.repository.StudentJpaRepo;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentJpaRepo studentService;

	public StudentController(StudentJpaRepo studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> findAllStudents() {
		return studentService.findAllStudents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id) {
		Optional<Student> result = studentService.findById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student studentEntity) {
		return studentService.updateStudent(studentEntity);

	}

	@PutMapping
	public Student updateStudent(@RequestBody Student studentEntity) {
		return studentService.updateStudent(studentEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
	}
}
