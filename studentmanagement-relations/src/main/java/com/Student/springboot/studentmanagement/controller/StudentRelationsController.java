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

import com.Student.springboot.studentmanagement.entity.CourseEntity;
import com.Student.springboot.studentmanagement.repository.StudentJpaRepo;

@RestController
@RequestMapping("/studentrelations")
public class StudentRelationsController {

	private final StudentJpaRepo studentService;

	public StudentRelationsController(StudentJpaRepo studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<CourseEntity> findAllStudents() {
		return studentService.findAllStudents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CourseEntity>> findStudentById(@PathVariable("id") Long id) {
		Optional<CourseEntity> result = studentService.findById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public CourseEntity saveStudent(@RequestBody CourseEntity studentEntity) {
		return studentService.updateStudent(studentEntity);

	}

	@PutMapping
	public CourseEntity updateStudent(@RequestBody CourseEntity studentEntity) {
		return studentService.updateStudent(studentEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
	}
}
