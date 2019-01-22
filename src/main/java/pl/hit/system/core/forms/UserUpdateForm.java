package pl.hit.system.core.forms;

import org.hibernate.validator.constraints.Length;

public class UserUpdateForm {

    @Length(max = 50, message = "{firstName.length}")
    private String firstName;

    @Length(max = 100, message = "{lastName.length}")
    private String lastName;

    @Length(min = 6, max = 100, message = "{password.length}")
    private String password;

    public UserUpdateForm() {
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

    @Override
    public String toString() {
        return "UserUpdateForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
