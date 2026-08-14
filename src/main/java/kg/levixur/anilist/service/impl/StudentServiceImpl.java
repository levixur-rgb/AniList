package kg.levixur.anilist.service.impl;

import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.dto.student.request.StudentUpdateRequest;
import kg.levixur.anilist.dto.student.response.StudentResponse;
import kg.levixur.anilist.entity.Student;
import kg.levixur.anilist.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class StudentServiceImpl implements StudentService {
    private List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public String addStudent(StudentCreateRequest request) {
        Student student = new Student();
        student.setId(idCounter.getAndIncrement());
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setAge(request.age());
        student.setPassword(request.password());

        students.add(student);
        return "Студент успешно добавлен с ID: " + student.getId();
    }

    @Override
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

    @Override
    public String updateStudent(Long id, StudentUpdateRequest request) {
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

    @Override
    public String deleteStudent(Long id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            return "Студент с ID " + id + " успешно удалён!";
        } else {
            return "Студент с ID " + id + " не найден!";
        }
    }
}