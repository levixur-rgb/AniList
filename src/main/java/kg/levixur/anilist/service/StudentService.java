package kg.levixur.anilist.service;

import kg.levixur.anilist.dto.student.StudentResponse;
import kg.levixur.anilist.dto.student.request.StudentCreateRequest;
import kg.levixur.anilist.dto.student.request.StudentUpdateRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    String addStudent(StudentCreateRequest request);
    List<StudentResponse> getAllStudents();
    String updateStudent(@PathVariable Long id, @RequestBody StudentUpdateRequest request);
    String deleteStudent(@PathVariable Long id);
}
