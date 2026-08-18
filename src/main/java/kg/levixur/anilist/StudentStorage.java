package kg.levixur.anilist.storage;

import kg.levixur.anilist.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class StudentStorage {
    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Student> getStudents() {
        return students;
    }

    public Long generateNextId() {
        return idCounter.getAndIncrement();
    }
}