package com.springboot.studentrelations.serviceImpl;
import java.util.List;

import com.springboot.studentrelations.Dtos.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);
}
