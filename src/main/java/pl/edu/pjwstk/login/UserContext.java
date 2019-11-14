package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.SessionScoped;
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




}
