package kg.levixur.anilist.mapper;

import kg.levixur.anilist.dto.group.GroupResponse;
import kg.levixur.anilist.entity.Group;
import kg.levixur.anilist.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target = "studentNames", source = "students", qualifiedByName = "mapStudents")
    GroupResponse toResponse(Group group);

    @Named("mapStudents")
    default List<String> mapStudents(List<Student> students) {
        if (students == null) {
            return null;
        }
        return students.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());
    }
}
