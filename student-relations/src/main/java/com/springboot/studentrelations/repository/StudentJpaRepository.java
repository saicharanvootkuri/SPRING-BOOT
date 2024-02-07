package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.entity.Student;

public interface StudentJpaRepository {
	List<Student> findAllStudents();
	Optional<Student> findById(Long id);
	Student saveStudent(Student studentEntity);
	Student updateStudent(Student studentEntity);
	void deleteStudent(Long id);
}
