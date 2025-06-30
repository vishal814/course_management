package course_management.application.DTO;
public class EnrollmentDTO {

    private int id;
    private String studentName;
    private String courseName;
    private double courseFee;   // Optional if you want fee in response

    public EnrollmentDTO(int id, String studentName, String courseName, double courseFee) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseFee = courseFee;
    }

    // Getters
    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getCourseName() { return courseName; }
    public double getCourseFee() { return courseFee; }
}