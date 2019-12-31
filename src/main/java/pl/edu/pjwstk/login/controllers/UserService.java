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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {


    @Inject
    private HttpServletRequest httpServletRequest;

    @PersistenceContext
    private EntityManager em;

    public List<User> findAllUsers(){
        return em.createQuery("SELECT u FROM User u",User.class).getResultList();
    }


    @Transactional
    public boolean register(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        // mechanizm tworzacy admina gdy baza danych uzytkownikow jest pusta
        if(findAllUsers().isEmpty()){
            user.setAdmin(true);
        }
        if (em.find(User.class, user.getLogin()) == null) {
            em.persist(user);
            return true;
        }

            return false;
    }

    public User findByLogin(String login) {
        return em.find(User.class, login);
    }

    public boolean login(String login, String pass) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = findByLogin(login);

        if (user != null) {
            HttpSession session = httpServletRequest.getSession(true);

            return bCryptPasswordEncoder
                    .matches(pass, user.getPass());
        }
        return false;
    }


    public void logout() {
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }


}
