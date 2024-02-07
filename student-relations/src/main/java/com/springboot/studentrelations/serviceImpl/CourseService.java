import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.studentrelations.entity.Course;
import com.springboot.studentrelations.repository.CourseJpaRepository;

public interface CourseService {
    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO saveCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);
}

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseJpaRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseJpaRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.map(courseMapper::toDTO).orElse(null);
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        return existingCourse.map(course -> {
            Course updatedCourse = courseRepository.save(courseMapper.toEntity(courseDTO));
            return courseMapper.toDTO(updatedCourse);
        }).orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
