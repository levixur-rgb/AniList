package kg.levixur.anilist.controller;

import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.dto.student.request.StudentUpdateRequest;
import kg.levixur.anilist.dto.student.response.StudentResponse;
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
        student.setPassword(request.password());

        students.add(student);
        return "Студент успешно добавлен с ID: " + student.getId();
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> result = new ArrayList<>();
        for (Student student: students ) {
            StudentResponse response = new StudentResponse(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getAge());

            result.add(response);
        }

        return result;

    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody StudentUpdateRequest request) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setFirstName(request.firstName());
                student.setLastName((request.lastName()));
                student.setAge(request.age());
                return "Студент с ID " + id + " успешно обновлён!";
            }
        }

        return "Студент с ID " + id + " не найден!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            return "Студент с ID " + id + " успешно удалён!";
        } else {
            return "Студент с ID " + id + " не найден!";
        }
    }
}