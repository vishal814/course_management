package course_management.application.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Primary key

    private String name;

    private double fee;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

  

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
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

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}