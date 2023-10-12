package api.eventapp.infraestructure.out.jpa.repository;

import api.eventapp.infraestructure.out.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEventRepository extends JpaRepository<EventEntity, Long> {
    @Modifying
    @Query(
            "UPDATE EventEntity e SET " +
                    "e.title = COALESCE(:title, e.title), " +
                    "e.description = COALESCE(:description, e.description), " +
                    "e.maxPeoplePerEvent = COALESCE(:maxPeoplePerEvent, e.maxPeoplePerEvent) " +
                    "WHERE e.eventId = :eventId"
    )
    void updateEvent(
            @Param("eventId") Long eventId,
            @Param("title") String title,
            @Param("description") String description,
            @Param("maxPeoplePerEvent") int maxPeoplePerEvent
    );

    boolean existsByTitle(String title);
}
