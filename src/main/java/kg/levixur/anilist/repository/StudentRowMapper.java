//package kg.levixur.anilist.repository;
//
//import kg.levixur.anilist.entity.Student;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class StudentRowMapper implements RowMapper<Student> {
//
//    @Override
//    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Student student = new Student();
//        student.setId(rs.getLong("id"));
//        student.setFirstName(rs.getString("first_name"));
//        student.setLastName(rs.getString("last_name"));
//        student.setAge(rs.getInt("age"));
//        student.setPassword(rs.getString("password"));
//        return student;
//    }
//}
