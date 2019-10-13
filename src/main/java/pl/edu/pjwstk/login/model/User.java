package pl.edu.pjwstk.login.model;

import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private String pass;
    private String login;
    private String surname;
    private String name;
    private String bday;
    private String email;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(pass, user.pass) &&
                Objects.equals(login, user.login) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(bday, user.bday) &&
                Objects.equals(email, user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "pass='" + pass + '\'' +
                ", login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", bday='" + bday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass, login, surname, name, bday, email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getBday() {
        return bday;
    }

    public String getEmail() {
        return email;
    }
}
