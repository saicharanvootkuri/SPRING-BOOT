import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;
import com.springboot.studentrelations.entity.Enrollment;
import com.springboot.studentrelations.repository.EnrollmentJpaRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentJpaRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(EnrollmentJpaRepository enrollmentRepository, EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentDTO getEnrollmentById(Long id) {
        Optional<Enrollment> result = enrollmentRepository.findById(id);
        return result.map(enrollmentMapper::toDTO).orElse(null);
    }

    @Override
    public EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDTO(savedEnrollment);
    }

    @Override
    public EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(id);
        return existingEnrollment.map(enrollment -> {
            enrollment.setStudent(enrollmentDTO.getStudent());
            enrollment.setCourse(enrollmentDTO.getCourse());
            Enrollment updatedEnrollment = enrollmentRepository.save(enrollment);
            return enrollmentMapper.toDTO(updatedEnrollment);
        }).orElse(null);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
