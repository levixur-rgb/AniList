package kg.levixur.anilist.repository;

import kg.levixur.anilist.entity.Student;
import kg.levixur.anilist.storage.StudentStorage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final StudentStorage studentStorage;

    public StudentRepository(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(studentStorage.generateNextId());
            studentStorage.getStudents().add(student);
        }
        return student;
    }

    public List<Student> findAll() {
        return studentStorage.getStudents();
    }

    public Optional<Student> findById(Long id) {
        return studentStorage.getStudents().stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return studentStorage.getStudents().removeIf(student -> student.getId().equals(id));
    }
}