package com.springboot.studentrelations.controller;

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

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.repository.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	@GetMapping
	public List<StudentDTO> findAllStudents() {
		return studentService.findAllStudents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<StudentDTO>> findStudentById(@PathVariable("id") Long id) {
		Optional<StudentDTO> result = studentService.findStudentById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.saveStudent(studentDTO);
	}

	@PutMapping
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.updateStudent(studentDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
	}
}
