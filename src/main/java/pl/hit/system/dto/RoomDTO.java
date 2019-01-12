package pl.hit.system.dto;

import java.util.Objects;

public class RoomDTO {

    private Long id;
    private String name;
    private String location;
    private Integer numberOfSeats;
    private Boolean projector;
    private String phoneNumber;
    private Boolean available;
    private String owner;


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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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
                ", available=" + available +
                ", owner=" + owner +
                '}';
    }
}
