package pl.edu.pjwstk.login.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    private String login;
    private String pass;
    private String surname;
    private String name;
    private LocalDate bday;
    private String email;
    private String checkPass;
    private String loginLogin;
    private String loginPass;
    private Boolean isAdmin = false;

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

    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBday(LocalDate bday) {
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

    public LocalDate getBday() {
        return bday;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getLoginLogin() {
        return loginLogin;
    }

    public void setLoginLogin(String loginLogin) {
        this.loginLogin = loginLogin;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(pass, user.pass) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(bday, user.bday) &&
                Objects.equals(email, user.email) &&
                Objects.equals(checkPass, user.checkPass) &&
                Objects.equals(loginLogin, user.loginLogin) &&
                Objects.equals(loginPass, user.loginPass) &&
                Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pass, surname, name, bday, email, checkPass, loginLogin, loginPass, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", bday=" + bday +
                ", email='" + email + '\'' +
                ", checkPass='" + checkPass + '\'' +
                ", loginLogin='" + loginLogin + '\'' +
                ", loginPass='" + loginPass + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

