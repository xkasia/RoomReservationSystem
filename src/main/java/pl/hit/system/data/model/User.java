package pl.hit.system.data.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name", length=50, columnDefinition="VARCHAR")
    private String firstName;


    @Column(nullable = false, name = "last_name", length=100, columnDefinition="VARCHAR")
    private String lastName;


    @Column(nullable = false, columnDefinition="VARCHAR", length = 100)
    private String password;

    @Column(unique = true, nullable = false, length=100, columnDefinition="VARCHAR")
    private String login;

    @OneToMany (mappedBy = "user")
    private List<Reservation> reservation;
   // private Reservation reservation;

//    @Cascade({org.hibernate.annotations.CascadeType.ALL})
//    @ManyToMany
//    @JoinTable(name = "user_rooms",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns =@JoinColumn(name = "room_id"))
//    Set<Room> rooms = new HashSet<>();


    public User() {
    }

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.login = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
