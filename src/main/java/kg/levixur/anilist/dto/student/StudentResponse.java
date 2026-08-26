package kg.levixur.anilist.dto.student;

import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
