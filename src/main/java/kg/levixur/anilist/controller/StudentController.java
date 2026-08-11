package kg.levixur.anilist.controller;

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
    public String addStudent(@RequestBody Student student) {
        student.setId(idCounter.getAndIncrement());
        students.add(student);
        return "Студент успешно добавлен с ID: " + student.getId();
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
}