package com.springboot.studentrelations.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;
import com.springboot.studentrelations.entity.EnrollmentEntity;
import com.springboot.studentrelations.mapper.EnrollmentMapper;
import com.springboot.studentrelations.repository.EnrollmentRepository;
import com.springboot.studentrelations.repository.EnrollmentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired 
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentDTO> findAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollmentMapper::enrollmentToEnrollmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EnrollmentDTO> findEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .map(enrollmentMapper::enrollmentToEnrollmentDTO);
    }

    @Override
    public EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO) {
        EnrollmentEntity enrollmentEntity = enrollmentMapper.enrollmentDTOToEnrollment(enrollmentDTO);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);
        return enrollmentMapper.enrollmentToEnrollmentDTO(enrollmentEntity);
    }

    @Override
    public EnrollmentDTO updateEnrollment(EnrollmentDTO enrollmentDTO) {
        EnrollmentEntity enrollmentEntity = enrollmentMapper.enrollmentDTOToEnrollment(enrollmentDTO);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);
        return enrollmentMapper.enrollmentToEnrollmentDTO(enrollmentEntity);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
