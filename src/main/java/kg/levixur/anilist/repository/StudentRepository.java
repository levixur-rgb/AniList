package kg.levixur.anilist.repository;

import kg.levixur.anilist.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

//
//import kg.levixur.anilist.entity.Student;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class StudentRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//    private final StudentRowMapper studentRowMapper;
//
//    public StudentRepository(JdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.studentRowMapper = studentRowMapper;
//    }
//
//    public Student save(Student student) {
//        String sql = "INSERT INTO students (first_name, last_name, age, password) VALUES (?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, student.getFirstName());
//            ps.setString(2, student.getLastName());
//            ps.setInt(3, student.getAge());
//            ps.setString(4, student.getPassword());
//            return ps;
//        }, keyHolder);
//
//        if (keyHolder.getKeys() != null && keyHolder.getKeys().containsKey("id")) {
//            student.setId(((Number) keyHolder.getKeys().get("id")).longValue());
//        }
//
//        return student;
//    }
//
//    public Optional<Student> findById(Long id) {
//        String sql = "SELECT * FROM students WHERE id = ?";
//        try {
//            Student student = jdbcTemplate.queryForObject(sql, studentRowMapper, id);
//            return Optional.ofNullable(student);
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
//    }
//
//    public List<Student> findAll() {
//        String sql = "SELECT * FROM students";
//        return jdbcTemplate.query(sql, studentRowMapper);
//    }
//
//    public void update(Student student) {
//        String sql = "UPDATE students SET first_name = ?, last_name = ?, age = ?, password = ? WHERE id = ?";
//        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getAge(), student.getPassword(), student.getId());
//    }
//
//    public void deleteById(Long id) {
//        String sql = "DELETE FROM students WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//}