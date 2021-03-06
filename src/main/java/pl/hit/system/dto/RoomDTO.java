package pl.hit.system.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Objects;

public class RoomDTO {

    private Long id;

    @NotEmpty(message = "{name.notEmpty}")
    @Length(max = 50, message = "{name.lenght}")
    private String name;

    @Length(max = 258, message = "{location.length}")
    private String location;

    @NotNull(message = "{numberOfSeats.notNull}")
    @Max(value = 100, message = ("{numberOfSeats.max}"))
    @Min(value = 0, message = ("{numberOfSeats.min}"))
    private Integer numberOfSeats;

    private Boolean projector;

    @Pattern(message="{phoneNumber.pattern}", regexp="^[0-9]*$")
    @Length(max = 100, message = "{phoneNumber.length}")
    private String phoneNumber;


    public RoomDTO() {
    }

    public RoomDTO(Long id, String name, String location, Integer numberOfSeats, Boolean projector, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.numberOfSeats = numberOfSeats;
        this.projector = projector;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO room = (RoomDTO) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", projector=" + projector +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
