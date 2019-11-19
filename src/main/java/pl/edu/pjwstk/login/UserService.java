package pl.edu.pjwstk.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
