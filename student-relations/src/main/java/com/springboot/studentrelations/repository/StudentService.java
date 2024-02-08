package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.Dtos.StudentDTO;

public interface StudentService {
	List<StudentDTO> findAllStudents();

	Optional<StudentDTO> findStudentById(Long id);

	StudentDTO saveStudent(StudentDTO studentDTO);

	StudentDTO updateStudent(StudentDTO studentDTO);

	void deleteStudent(Long id);
}
