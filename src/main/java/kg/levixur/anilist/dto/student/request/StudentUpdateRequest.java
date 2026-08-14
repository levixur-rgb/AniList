package kg.levixur.anilist.dto.student.request;

public record StudentUpdateRequest (
        String firstName,
        String lastName,
        int age
){
}