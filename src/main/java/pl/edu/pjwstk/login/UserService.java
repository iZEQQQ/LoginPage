package pl.edu.pjwstk.login;

import pl.edu.pjwstk.login.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.util.ArrayList;
import java.util.List;

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
    public boolean checkPass(String pass){
        return (users.stream().filter(u -> u.getPass().equals(pass))).equals(true);
    }


    public User login(String login, String pass) {
        return users.stream().filter(u -> u.getLogin().equals(login) && u.getPass().equals(pass)).findFirst().orElse(null);
    }
}
