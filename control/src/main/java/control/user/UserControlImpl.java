package control.user;

import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 */
public class UserControlImpl implements UserControl {
    private List<User> users = new ArrayList<>();
    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String id) {
        return new User();
    }

    public User createUser(String name, String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setId((users.size() + 1) + "");
        users.add(user);
        return user;
    }

    public User updateUser(String id, String name, String email) {
        return new User();
    }
}
