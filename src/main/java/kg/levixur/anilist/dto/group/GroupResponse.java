package kg.levixur.anilist.dto.group;

import lombok.Data;
import java.util.List;

@Data
public class GroupResponse {
    private Long id;
    private String name;
    private List<String> studentNames;
}
