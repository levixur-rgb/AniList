package kg.levixur.anilist.controller;

import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.dto.student.request.StudentUpdateRequest;
import kg.levixur.anilist.dto.student.response.StudentResponse;
import kg.levixur.anilist.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String addStudent(@RequestBody StudentCreateRequest request) {
        return studentService.addStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
            return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody StudentUpdateRequest request) {
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}