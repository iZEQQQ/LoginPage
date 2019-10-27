package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;
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

    public void validatePass(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if (((String) object).length() <= 5) {
            System.out.println(user.toString());
            throw new ValidatorException(new FacesMessage("too short"));
        }


    }


    public String register() {
        System.out.println(user.toString());
        if (!user.getPass().equals(user.getCheckPass())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("not match"));
            return null;
        }


        if (userService.register(user)) {
            return "sign_done?faces-redirect=true";
        }
        return null;
    }

}
