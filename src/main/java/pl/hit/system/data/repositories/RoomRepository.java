package pl.hit.system.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pl.hit.system.data.model.Room;

@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    Room getRoomByName(String roomName);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE rooms SET name=?2,location= ?3, " +
            "number_of_seats = ?4, projector = ?5,  phone_number= ?6 WHERE id = ?1")
    void updateRoom(Long id, String name, String location, Integer numberOfSeats,
                    String projector, String phoneNumber);


    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM rooms WHERE id = ?1")
    void deleteRoom(Long id);


    @Query(nativeQuery = true, value =
            "SELECT CASE WHEN count(*) = 1  THEN 'true' ELSE 'false' END " +
                    "from rooms where name = ?1")
    boolean checkIfNameExists(String name);

    @Modifying
    @Query(nativeQuery = true, value =
            "Insert into rooms(name, location, number_of_seats, projector, phone_number)" +
                    "values(?1, ?2, ?3, ?4, ?5 )")
    void saveRoomInDb(String name, String location, Integer numberOfSeats,
                      Boolean projector, String phoneNumber);


    @Query(nativeQuery = true, value =
            "SELECT * from rooms where id = ?1")
    Room getRoomById(Long roomId);
}
