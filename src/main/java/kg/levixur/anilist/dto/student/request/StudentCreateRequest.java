package kg.levixur.anilist.dto.student.request;

public record StudentCreateRequest(
        String firstName,
        String lastName,
        int age
) {
}