package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/all")
	public List<StudentEntity> findAllStudents() {
		log.info("Fetching all students.");
		return studentService.findAllStudents();
	}

	@GetMapping()
	public ResponseEntity<Optional<StudentEntity>> findStudentById(@RequestParam("id") Long id) {
		log.info("Fetching student by ID: {}", id);
		Optional<StudentEntity> result = studentService.findStudentById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {
		log.info("Saving new student: {}", studentEntity);
		return studentService.saveStudent(studentEntity);
	}

	@PutMapping("/students")
	public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity) {
		log.info("Updating student: {}", studentEntity);
		return studentService.updateStudent(studentEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		log.info("Deleting student with ID: {}", id);
		studentService.deleteStudent(id);
	}
}
