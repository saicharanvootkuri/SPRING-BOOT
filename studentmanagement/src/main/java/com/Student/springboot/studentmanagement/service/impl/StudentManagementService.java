package com.Student.springboot.studentmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Student.springboot.studentmanagement.entity.Student;
import com.Student.springboot.studentmanagement.repository.StudentJpaRepo;
import com.Student.springboot.studentmanagement.repository.StudentRepository;

@Service
public class StudentManagementService implements StudentJpaRepo {

	private final StudentRepository studentRepository;

	public StudentManagementService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student saveStudent(Student studentEntity) {
		return studentRepository.save(studentEntity);
	}

	@Override
	public Student updateStudent(Student studentEntity) {
		return studentRepository.save(studentEntity);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
