package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Reservation;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Modifying
    @Query(nativeQuery = true, value =
            "insert into reservations (user_id, room_id, reservation_start, " +
                    "reservation_end) values (?1, ?2, ?3, ?4)")
    void addReservation(Long userId, Long roomId, LocalDateTime starTime,
                        LocalDateTime endTime);
    @Modifying
    @Query(nativeQuery = true, value =
            "SELECT reservation_start from reservations where " +
                    "reservation_start > ?1 and room_id = ?2")
    List<Timestamp> giveStartTimesGreaterThanWantedToBook(LocalDateTime startTime,
                                                          Long roomId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where user_id = ?1")
    List<Reservation> getUserReservations(Long userId);

    Reservation getReservationById(Long reservationId);

    @Modifying
    @Query(nativeQuery = true, value =
            "SELECT reservation_start from reservations where " +
                    "reservation_start > ?1 and reservation_start <?2 and room_id = ?3")
    List<Timestamp> giveStartTimesDuringPeriodToBook(LocalDateTime startTime, LocalDateTime endTime, Long roomId);


    @Modifying
    @Query(nativeQuery = true, value =
            "SELECT reservation_end from reservations where " +
                    "reservation_end > ?1 and reservation_end <?2 and room_id = ?3")
    List<Timestamp> giveEndTimesDuringPeriodToBook(LocalDateTime startTime, LocalDateTime endTime, Long roomId);

    @Modifying
    @Query(nativeQuery = true, value =
            "SELECT reservation_start from reservations where " +
                    "reservation_start < ?1 and reservation_end >?2 and room_id = ?3")
    List<Timestamp> giveTimesSmallerThanStartTimeAndBiggerThanEndTimeToBook(LocalDateTime startTime, LocalDateTime endTime, Long roomId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1 and reservation_end <=?2")
    List<Reservation> getReservationsInTimeFrame(LocalDateTime startTime, LocalDateTime endTime);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1")
    List<Reservation> getReservationsFromDate(LocalDateTime startTime);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_end <=?1")
    List<Reservation> getReservationsToDate(LocalDateTime endTime);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1 and reservation_end <=?2 and user_id=?3")
    List<Reservation> getUserReservationsInTimeFrame(LocalDateTime start, LocalDateTime end, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1 and user_id=?2")
    List<Reservation> getUserReservationsFromDate(LocalDateTime start, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_end <=?1 and user_id=?2")
    List<Reservation> getUserReservationsToDate(LocalDateTime end, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1 and reservation_end <=?2 and room_id=?3")
    List<Reservation> getRoomReservationsInTimeFrame(LocalDateTime start, LocalDateTime end, Long roomId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_start>= ?1 and room_id=?2")
    List<Reservation> getRoomReservationsFromDate(LocalDateTime start, Long roomId);

    @Query(nativeQuery = true, value =
            "SELECT * from reservations where reservation_end <=?1 and room_id=?2")
    List<Reservation> getRoomReservationsToDate(LocalDateTime end, Long roomId);
}
