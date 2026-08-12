package kg.levixur.anilist.controller;

import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @PostMapping
    public String addStudent(@RequestBody StudentCreateRequest request) {
        Student student = new Student();
        student.setId(idCounter.getAndIncrement());
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setAge(request.age());

        students.add(student);
        return "Студент успешно добавлен с ID: " + student.getId();
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
}