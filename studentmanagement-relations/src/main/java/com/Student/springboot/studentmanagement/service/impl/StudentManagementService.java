package com.Student.springboot.studentmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.springboot.studentmanagement.entity.CourseEntity;
import com.Student.springboot.studentmanagement.repository.CourseRepository;
import com.Student.springboot.studentmanagement.repository.StudentJpaRepo;
import com.Student.springboot.studentmanagement.repository.StudentRepository;

@Service
public class StudentManagementService implements StudentJpaRepo {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentManagementService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseEntity> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<CourseEntity> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public CourseEntity saveStudent(CourseEntity studentEntity) {
        return courseRepository.save(studentEntity);
    }

    @Override
    public CourseEntity updateStudent(CourseEntity studentEntity) {
        return courseRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
