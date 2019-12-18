package pl.edu.pjwstk.login.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.login.model.User;
import pl.edu.pjwstk.login.operators.Login;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {


    @PersistenceContext
    private EntityManager em;


    @Transactional
    public boolean register(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        if (em.find(User.class, user.getLogin()) == null) {
            em.persist(user);
            return true;
        }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("user with that login already exists"));
        return false;
    }

    public User findByLogin(String login) {
        return em.find(User.class, login);
    }

    public boolean login(String login, String pass) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = findByLogin(login);
        if (user != null) {

            return bCryptPasswordEncoder
                    .matches(pass, user.getPass());
        }
        return false;
    }

}
