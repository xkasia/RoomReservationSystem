package pl.hit.system.core.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class UserLoginForm {

    @NotEmpty(message = "{password.notEmpty}")
    @Length(min = 6, max = 100, message = "{password.length}")
    private String password;

    @NotEmpty(message = "{login.notEmpty}")
    @Length(max = 100, message = "{login.length}")
    private String login;

    public UserLoginForm() {
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
    public String toString() {
        return "UserLoginForm{" +
                "password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
