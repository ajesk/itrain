package control.user;

import models.User;

import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 * Still working this guy out
 */
public interface UserControl {
    List<User> getAllUsers();
    User getUser(String id);
    User createUser(User user);
    User updateUser(User user);
}
