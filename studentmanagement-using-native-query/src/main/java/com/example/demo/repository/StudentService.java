package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.StudentEntity;

public interface StudentService {
	List<StudentEntity> findAllStudents();

	Optional<StudentEntity> findStudentById(Long id);

	StudentEntity saveStudent(StudentEntity studentEntity);

	StudentEntity updateStudent(StudentEntity studentEntity);

	void deleteStudent(Long id);
}
