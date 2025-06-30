package course_management.application.DTO;

import java.time.LocalDate;

public class StudentDTO {
    private int id;
    private String name;
    private LocalDate dob;

    public StudentDTO(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }
    

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }
}