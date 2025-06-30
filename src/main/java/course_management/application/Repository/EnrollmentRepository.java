package course_management.application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import course_management.application.models.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Query("SELECT e.course.name, COUNT(e.student) FROM Enrollment e GROUP BY e.course.name")
    List<Object[]> countStudentsByCourse();

    @Query("SELECT e.course.name, SUM(e.course.fee) FROM Enrollment e GROUP BY e.course.name")
    List<Object[]> totalFeesByCourse();
}
