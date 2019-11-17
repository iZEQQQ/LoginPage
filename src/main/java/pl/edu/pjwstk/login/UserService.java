package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class UserService {


    //private List<User> users = new ArrayList<>();

    @PersistenceContext
    private EntityManager em;


    
    @Transactional
    public boolean register(User user) {
        if (em.find(User.class, user.getLogin()) == null ) {
            em.persist(user);
            return true;
        }
        return false;
    }

    public User findByLogin(String login){
        return em.find(User.class,login);
    }

    public boolean login(String login, String pass) {
        User user = findByLogin(login);
        if(user!=null){
            if (user.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
