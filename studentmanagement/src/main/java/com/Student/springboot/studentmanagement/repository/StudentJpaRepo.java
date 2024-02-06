package com.Student.springboot.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.Student.springboot.studentmanagement.entity.Student;

public interface StudentJpaRepo {
	List<Student> findAllStudents();
	Optional<Student> findById(Long id);
	Student saveStudent(Student studentEntity);
	Student updateStudent(Student studentEntity);
	void deleteStudent(Long id);
}
