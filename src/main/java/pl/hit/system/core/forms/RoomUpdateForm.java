package pl.hit.system.core.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class RoomUpdateForm {

    @Length(max = 258, message = "{location.length}")
    private String location;

    @Max(value = 100, message = ("{numberOfSeats.max}"))
    @Min(value = 0, message = ("{numberOfSeats.min}"))
    private Integer numberOfSeats;

    private Boolean projector;

    @Pattern(message="{phoneNumber.pattern}", regexp="^[0-9]*$")
    @Length(max = 100, message = "{phoneNumber.length}")
    private String phoneNumber;

    public RoomUpdateForm() {
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
    public String toString() {
        return "RoomUpdateForm{" +
                "location='" + location + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", projector=" + projector +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
