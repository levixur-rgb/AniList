package kg.levixur.anilist.repository;

import kg.levixur.anilist.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.students WHERE g.id = :id")
    Optional<Group> findByIdWithStudents(@Param("id") Long id);
}
