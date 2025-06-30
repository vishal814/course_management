package course_management.application.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course_management.application.DTO.EnrollmentDTO;
import course_management.application.Repository.CourseRepository;
import course_management.application.Repository.EnrollmentRepository;
import course_management.application.Repository.StudentRepository;
import course_management.application.models.Course;
import course_management.application.models.Enrollment;
import course_management.application.models.Student;

import java.util.*;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollStudent(Integer studentId, Long courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);

        if (student.isPresent() && course.isPresent()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student.get());
            enrollment.setCourse(course.get());
            return enrollmentRepository.save(enrollment);
        }

        return null; // or throw exception
    }

     public List<EnrollmentDTO> getEnrollments() {
        return enrollmentRepository.findAll().stream()
            .map(e -> new EnrollmentDTO(
                e.getId(),
                e.getStudent().getName(),
                e.getCourse().getName(), 
                e.getCourse().getFee()
            ))
            .toList();
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Object[]> countStudentsPerCourse() {
        return enrollmentRepository.countStudentsByCourse();
    }

    public List<Object[]> totalFeesByCourse() {
        return enrollmentRepository.totalFeesByCourse();
    }
}
