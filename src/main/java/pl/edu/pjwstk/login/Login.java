package pl.edu.pjwstk.login;


import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.RequestScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;


@Named
@RequestScoped
public class Login implements Serializable {

    private User user = new User();
    private String login;
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Inject
    private UserService userService;

    public User getUser() {
        return user;
    }


public void loginUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (getLogin().equals(user.getLogin()) && getPass().equals(user.getPass())) {
            context.getExternalContext().getSessionMap().put("user", login);
            try {
                context.getExternalContext().redirect("loggedWelcome");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
                context.addMessage(null, new FacesMessage("Authentication Failed"));
        }
    }

}
