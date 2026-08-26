package kg.levixur.anilist.mapper;

import kg.levixur.anilist.dto.student.StudentResponse;
import kg.levixur.anilist.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponse toResponse(Student student);
}