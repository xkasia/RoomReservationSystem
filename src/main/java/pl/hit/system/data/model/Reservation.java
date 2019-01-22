package pl.hit.system.data.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

    @Column(name = "reservation_start", nullable = false)
    private Timestamp reservationStart;
    @Column(name = "reservation_end", nullable = false)
    private Timestamp reservationEnd;

    public Reservation() {
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
        return reservationStart.toLocalDateTime();
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        this.reservationStart =  Timestamp.valueOf(reservationStart);
    }

    public LocalDateTime getReservationEnd() {
        return reservationEnd.toLocalDateTime();
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        this.reservationEnd =  Timestamp.valueOf(reservationEnd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return Objects.equals(id, reservation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", user=" + user +
                ", reservationStart=" + reservationStart +
                ", reservationEnd=" + reservationEnd +
                '}';
    }
}





