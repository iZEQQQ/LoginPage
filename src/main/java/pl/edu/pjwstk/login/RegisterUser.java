package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class RegisterUser implements Serializable {
    private User user = new User();


    @Inject
    private UserService userService;

    public User getUser() {
        return user;
    }

    public boolean passCheck(){
        return userService.checkPass();
    }

    public String register() {
        if (userService.register(user) && passCheck()) {
            return "sign_done?faces-redirect=true";
        }
        return null;
    }

}
