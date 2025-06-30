package course_management.application.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Student {

    @Id
    @JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Primary key, auto-incremented

    private String name;

    private LocalDate dob;  // Date of birth

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
