package pl.hit.system.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class LoggedUserDTO {

    @NotNull
    private Long id;

    @NotEmpty(message = "{firstName.notEmpty}") @Length(max=50, message = "{firstName.length}")
    private String firstName;

    @NotEmpty(message = "{lastName.notEmpty}") @Length(max=100, message = "{lastName.length}")
    private String lastName;

    @NotEmpty(message = "{password.notEmpty}") @Length(min=6, max=100, message = "{password.length}")
    private String password;

    @NotEmpty(message = "{login.notEmpty}") @Length(max=100, message = "{login.length}")
    private String login;

    public LoggedUserDTO() {
    }

//    public LoggedUserDTO(String firstName, String lastName, String password, String login) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.login = login;
//    }

    public LoggedUserDTO(Long id, String firstName, String lastName, String password, String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.login = login;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoggedUserDTO that = (LoggedUserDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login);
    }

    @Override
    public String toString() {
        return "LoggedUserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
