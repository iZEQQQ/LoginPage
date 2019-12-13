package pl.edu.pjwstk.login.controllers;

import pl.edu.pjwstk.login.model.User;
import pl.edu.pjwstk.login.operators.Login;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserContext implements Serializable {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public boolean isLogged() {
        return user != null;
    }


}
