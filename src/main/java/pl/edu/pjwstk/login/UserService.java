package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class UserService {
    private List<User> users = new ArrayList<>();

    public boolean register(User user) {
        if (users.stream().noneMatch(u -> u.getLogin().equals(user.getLogin()))) {
            users.add(user);
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
