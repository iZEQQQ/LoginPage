package pl.edu.pjwstk.login;


import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;


@Named
@RequestScoped
public class Login implements Serializable {

    private User user = new User();


    @Inject
    private UserService userService;

    public User getUser() {
        return user;
    }


    public String loginUser() {
        if (!(userService.login(user.getLogin(),user.getPass()).equals(getUser()))) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("not match"));
            return null;
        }
        if (userService.login(user.getLogin(),user.getPass()).equals(getUser())) {
            return "logged_welcome?faces-redirect=true";
        }
        return null;

    }

}
