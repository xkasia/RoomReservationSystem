package pl.hit.system.dto;

import pl.hit.system.data.model.Room;
import pl.hit.system.data.model.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationDTO {


    private Long id;
    private Room room;
    private User user;

    @NotEmpty(message = "{reservationStart.notEmpty}")
    private LocalDateTime reservationStart;

    @NotEmpty(message = "{reservationEnd.notEmpty}")
    private LocalDateTime reservationEnd;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Room room, User user, LocalDateTime reservationStart, LocalDateTime reservationEnd) {
        this.id = id;
        this.room = room;
        this.user = user;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        this.reservationEnd = reservationEnd;
    }
}
