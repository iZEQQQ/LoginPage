package pl.edu.pjwstk.login;


import pl.edu.pjwstk.login.model.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;


@Named
@ViewScoped
public class Login implements Serializable {

    private User user = new User();
//    @PersistenceContext
//    EntityManager entityManager;


    @Inject
    private UserService userService;

    @Inject
    private UserContext userContext;

    public User getUser() {
        return user;
    }


    public String loginUser() {
        if (!(userService.login(user.getLoginLogin(), user.getLoginPass()))) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("wrong password or username"));
            return null;
        }
        userContext.setUser(userService.findByLogin(user.getLoginLogin()));
        return "logged_welcome?faces-redirect=true";

    }

}
