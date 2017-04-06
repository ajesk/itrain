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
    User getUser(int id);
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
