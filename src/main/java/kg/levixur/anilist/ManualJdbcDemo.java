package kg.levixur.anilist;

import kg.levixur.anilist.entity.Student;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ManualJdbcDemo {

    private final DataSource dataSource;

    public ManualJdbcDemo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveStudentManual(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, age, password) VALUES (?, ?, ?, ?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, student.getFirstName());
                pstmt.setString(2, student.getLastName());
                pstmt.setInt(3, student.getAge());
                pstmt.setString(4, student.getPassword());

                pstmt.executeUpdate();
            }

            connection.commit();
            System.out.println("Студент успешно сохранён через ручной jdbc.");

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Транзакция откачена: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}
