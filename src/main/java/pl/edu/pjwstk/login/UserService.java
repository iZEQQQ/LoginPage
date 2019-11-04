package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class UserService {
    private List<User> users = new ArrayList<>();

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
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
    }

    public boolean login(String login, String pass) {
        return users.stream().anyMatch(u -> u.getLogin().equals(login) && u.getPass().equals(pass));
    }
}
