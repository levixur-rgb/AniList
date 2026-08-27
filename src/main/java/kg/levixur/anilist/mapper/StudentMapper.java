package kg.levixur.anilist.mapper;

import kg.levixur.anilist.dto.student.StudentResponse;
import kg.levixur.anilist.entity.Student;
import kg.levixur.anilist.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentMapper {

//    @Mapping(target = "groupName", source = "group.name")
    @Mapping(target = "gameNames", source = "games", qualifiedByName = "mapGames")
    StudentResponse toResponse(Student student);

    @Named("mapGames")
    default List<String> mapGames(List<Game> games) {
        if (games == null) {
            return null;
        }
        return games.stream()
                .map(Game::getTitle)
                .collect(Collectors.toList());
    }
}