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

        if(userService.login(getLogin(),getPass()).equals(user)){
            context.getExternalContext().getSessionMap().put("user", user.getLogin());
            try {
                context.getExternalContext().redirect("loggedWelcome.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else  {
            context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));

        }
    }

}
