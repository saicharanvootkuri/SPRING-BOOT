package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.entity.StudentEntity;

public interface StudentService {
	List<StudentEntity> findAllStudents();

	Optional<StudentDTO> findStudentById(Long id);

	StudentDTO saveStudent(StudentDTO studentDTO);

	StudentDTO updateStudent(StudentDTO studentDTO);

	void deleteStudent(Long id);
}
