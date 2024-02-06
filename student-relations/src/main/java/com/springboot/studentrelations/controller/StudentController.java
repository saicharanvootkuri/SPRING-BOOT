package com.springboot.studentrelations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springboot.studentrelations.entity.Student;
import com.springboot.studentrelations.serviceImpl.StudentService;

	@RestController
	@RequestMapping("/students")
	public class StudentController {

	    @Autowired
	    private StudentService studentService;

	    // Get all students
	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    // Get student by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        Optional<Student> student = studentService.getStudentById(id);
	        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
