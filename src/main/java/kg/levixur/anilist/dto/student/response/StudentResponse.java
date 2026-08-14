package kg.levixur.anilist.dto.student.response;

public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        int age
) {
}
