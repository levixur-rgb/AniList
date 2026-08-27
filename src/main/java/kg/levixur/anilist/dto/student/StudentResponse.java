package kg.levixur.anilist.dto.student;

import lombok.Data;
import java.util.List;

@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    private String groupName;
    private List<String> gameNames;
}
