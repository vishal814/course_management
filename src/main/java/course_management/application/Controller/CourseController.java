package course_management.application.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import course_management.application.DTO.CourseDTO;
import course_management.application.Repository.CourseRepository;
import course_management.application.models.Course;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseRepository.save(course));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(),course.getFee()))
                .toList();
        return ResponseEntity.ok(courseDTOs);

    }

    
    }

