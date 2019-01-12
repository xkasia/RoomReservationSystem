package pl.hit.system.data.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @OneToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private Room room;

    //@OneToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private User user;

    @Column(name = "reservation_start", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime reservationStart;

    @Column(name = "reservation_end", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime reservationEnd;

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





