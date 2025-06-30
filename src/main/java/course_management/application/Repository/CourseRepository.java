package course_management.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import course_management.application.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}