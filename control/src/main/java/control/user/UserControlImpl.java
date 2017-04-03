package control.user;

import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 * This is the business logic sector of the application. Here is where you would handle the results from DB calls and
 * manipulate data in the control layer. To use a database in place of this you will need to create a DB handler and
 * inject it here for use.
 *
 * todo: fix this ish putting stuff still don't work fam.
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
