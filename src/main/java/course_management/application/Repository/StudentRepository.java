package course_management.application.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import course_management.application.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}