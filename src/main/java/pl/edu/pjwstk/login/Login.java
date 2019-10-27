package pl.edu.pjwstk.login;


import pl.edu.pjwstk.login.model.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
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


    public String loginUser() {
        System.out.println("Hi, please log in.");
        if (!(login.equals(getLogin()) && pass.equals(getPass()))) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("invalid login or password"));
            return null;
        }

        if (userService.login(user.getLogin(), user.getPass()).equals(getUser())) {
            return "sign_done?faces-redirect=true";

        }
        return null;
    }

}
