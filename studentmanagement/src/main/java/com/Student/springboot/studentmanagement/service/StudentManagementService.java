package com.Student.springboot.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import com.Student.springboot.studentmanagement.entity.StudentEntity;

public interface StudentManagementService {
	List<StudentEntity> findAllStudents();

	Optional<StudentEntity> findById(Long id);

	StudentEntity saveStudent(StudentEntity studentEntity);

	StudentEntity updateStudent(StudentEntity studentEntity);

	void deleteStudent(Long id);
}
