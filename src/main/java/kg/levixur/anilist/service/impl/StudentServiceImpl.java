package kg.levixur.anilist.service.impl;

import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.dto.student.request.StudentUpdateRequest;
import kg.levixur.anilist.dto.student.StudentResponse;
import kg.levixur.anilist.entity.Student;
import kg.levixur.anilist.repository.StudentRepository;
import kg.levixur.anilist.service.StudentService;
import kg.levixur.anilist.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    @Override
    public String addStudent(StudentCreateRequest request) {
        Student student = new Student();
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setAge(request.age());
        student.setPassword(request.password());

        Student savedStudent = studentRepository.save(student);
        return "Студент успешно добавлен с ID: " + savedStudent.getId();
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> result = new ArrayList<>();

        for (Student student : studentRepository.findAll()) {
            StudentResponse response = studentMapper.toResponse(student);
            result.add(response);
        }

        return result;
    }


    @Override
    public String updateStudent(Long id, StudentUpdateRequest request) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(request.firstName());
            student.setLastName(request.lastName());
            student.setAge(request.age());
            return "Студент с ID " + id + " успешно обновлён!";
        }

        return "Студент с ID " + id + " не найден!";
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Студент с ID " + id + " успешно удалён!";
    }
}