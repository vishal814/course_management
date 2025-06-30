package course_management.application.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import course_management.application.DTO.EnrollmentDTO;
import course_management.application.Repository.CourseRepository;
import course_management.application.Repository.EnrollmentRepository;
import course_management.application.Repository.StudentRepository;
import course_management.application.Services.EnrollmentService;
import course_management.application.models.Course;
import course_management.application.models.Enrollment;
import course_management.application.models.Student;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestParam Integer studentId, @RequestParam Integer courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId.longValue());

        if (student.isPresent() && course.isPresent()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student.get());
            enrollment.setCourse(course.get());
            return ResponseEntity.ok(enrollmentRepository.save(enrollment));
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping
     public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
    List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
    List<EnrollmentDTO> enrollmentDTOs = enrollments.stream()
            .map(enrollment -> new EnrollmentDTO(
                    enrollment.getId(),
                    enrollment.getStudent().getName(),
                    enrollment.getCourse().getName(),
                    enrollment.getCourse().getFee()
            ))
            .collect(Collectors.toList());
    return ResponseEntity.ok(enrollmentDTOs);
}

    @GetMapping("/stats/students")
    public List<Map<String, Object>> getStudentStats() {
        List<Object[]> data = enrollmentRepository.countStudentsByCourse();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : data) {
            Map<String, Object> map = new HashMap<>();
            map.put("courseName", row[0]);
            map.put("studentCount", row[1]);
            result.add(map);
        }

        return result;
    }

    @GetMapping("/stats/fees")
    public List<Map<String, Object>> getFeeStats() {
        List<Object[]> data = enrollmentRepository.totalFeesByCourse();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : data) {
            Map<String, Object> map = new HashMap<>();
            map.put("courseName", row[0]);
            map.put("totalFee", row[1]);
            result.add(map);
        }

        return result;
    }
}
