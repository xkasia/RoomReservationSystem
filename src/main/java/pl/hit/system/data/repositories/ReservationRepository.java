package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Reservation;

import java.time.LocalDateTime;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Modifying
    @Query(nativeQuery = true, value =
            "insert into reservation (user_id, room_id, reservation_start, reservation_end) values " +
                    "(?1, ?2, ?3, ?4)")
    void addReservation(Long userId, Long roomId, LocalDateTime starTime,LocalDateTime endTime);




}
