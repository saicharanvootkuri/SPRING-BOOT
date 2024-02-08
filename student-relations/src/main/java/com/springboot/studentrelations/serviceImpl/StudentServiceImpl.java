package com.springboot.studentrelations.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.entity.StudentEntity;
import com.springboot.studentrelations.mapper.StudentMapper;
import com.springboot.studentrelations.repository.StudentRepository;
import com.springboot.studentrelations.repository.StudentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired 
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Override
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::studentEntityToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::studentEntityToStudentDTO);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.studentDTOToStudentEntity(studentDTO);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.studentEntityToStudentDTO(savedEntity);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.studentDTOToStudentEntity(studentDTO);
        StudentEntity updatedEntity = studentRepository.save(studentEntity);
        return studentMapper.studentEntityToStudentDTO(updatedEntity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
