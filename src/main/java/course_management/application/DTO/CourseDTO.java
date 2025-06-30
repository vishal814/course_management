package course_management.application.DTO;

public class CourseDTO {
    private int id;
    private String name;
    private double fee;

    public CourseDTO(int id, String name, double fee) {
        this.id = id;
        this.name = name;
        this.fee = fee; 
    
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getFee() {
        return fee;
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
    

}
