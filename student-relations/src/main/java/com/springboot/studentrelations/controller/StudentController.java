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

import com.springboot.studentrelations.entity.Student;
import com.springboot.studentrelations.repository.StudentJpaRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentJpaRepository studentRepository;

    public StudentController(StudentJpaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id) {
        Optional<Student> result = studentRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(result);
        }
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            student.setId(id);
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }
}
