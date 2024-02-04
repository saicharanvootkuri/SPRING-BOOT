package com.Student.springboot.studentmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Student.springboot.studentmanagement.entity.StudentEntity;
import com.Student.springboot.studentmanagement.repository.StudentRepository;
import com.Student.springboot.studentmanagement.service.StudentManagementService;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {

	private final StudentRepository studentRepository;

	public StudentManagementServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentEntity> findAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<StudentEntity> findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
