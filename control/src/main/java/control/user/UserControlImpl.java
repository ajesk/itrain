package control.user;

import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 */
public class UserControlImpl implements UserControl {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setEmail("adsf");
        user.setName("aaa");
        user.setId("1");
        users.add(user);
        return users;
    }

    public User getUser(String id) {
        return new User();
    }

    public User createUser(String name, String email) {
        return new User();
    }

    public User updateUser(String id, String name, String email) {
        return new User();
    }
}
