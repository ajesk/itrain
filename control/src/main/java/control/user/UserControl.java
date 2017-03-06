package control.user;

import models.User;

import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 */
public interface UserControl {
    List<User> getAllUsers();
    User getUser(String id);
    User createUser(String name, String email);
    User updateUser(String id, String name, String email);
}
