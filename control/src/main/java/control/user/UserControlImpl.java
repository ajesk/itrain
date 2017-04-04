package control.user;

import lombok.extern.slf4j.Slf4j;
import models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Aaron on 2/17/17.
 *
 * This is the business logic sector of the application. Here is where you would handle the results from DB calls and
 * manipulate data in the control layer. To use a database in place of this you will need to create a DB handler and
 * inject it here for use.
 *
 */

@Slf4j
public class UserControlImpl implements UserControl {
    //private List<User> users = new ArrayList<>();
    private Map<Integer, User> users = new HashMap<>();
    private int counter = 0;

    public List<User> getAllUsers() {
        return users.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    public User getUser(String id) {
        int numericalId = Integer.parseInt(id);

        return users.get(numericalId);
    }

    public User createUser(User user) {
        user.setId((++counter));
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(String id) {
        try {
            int numericalId = Integer.parseInt(id);
            users.remove(numericalId);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
