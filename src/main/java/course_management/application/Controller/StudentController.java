package course_management.application.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import course_management.application.DTO.StudentDTO;
import course_management.application.Repository.StudentRepository;
import course_management.application.Services.StudentService;
import course_management.application.models.Student;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
      private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping
   public List<StudentDTO> getAllStudents() {
    return studentService.getAllStudents().stream()
        .map(s -> new StudentDTO(s.getId(), s.getName(), s.getDob()))
        .toList();
}
}
