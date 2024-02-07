import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studentrelations.Dtos.CourseDTO;
import com.springboot.studentrelations.entity.Course;
import com.springboot.studentrelations.repository.CourseJpaRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseJpaRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseController(CourseJpaRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.map(course -> ResponseEntity.status(HttpStatus.FOUND).body(courseMapper.toDTO(course)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        return existingCourse.map(course -> {
            Course updatedCourse = courseRepository.save(courseMapper.toEntity(courseDTO));
            return ResponseEntity.status(HttpStatus.OK).body(courseMapper.toDTO(updatedCourse));
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
    }
}
