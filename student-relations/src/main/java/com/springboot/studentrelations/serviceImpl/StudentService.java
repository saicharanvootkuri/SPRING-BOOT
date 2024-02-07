import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.entity.Student;
import com.springboot.studentrelations.repository.StudentJpaRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentJpaRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentJpaRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> result = studentRepository.findById(id);
        return result.map(studentMapper::toDTO).orElse(null);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        return existingStudent.map(student -> {
            student.setName(studentDTO.getName());
            Student updatedStudent = studentRepository.save(student);
            return studentMapper.toDTO(updatedStudent);
        }).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
