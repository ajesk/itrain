package io.acode.spark_starter.control.user;

import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Aaron on 2/17/17.
 *
 * This is the business logic sector of the application. Here is where you would handle the results from DB calls and
 * manipulate data in the io.acode.spark_starter.control layer. To use a database in place of this you will need to create a DB handler and
 * inject it here for use.
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

    public User getUser(int id) {
        return users.get(id);
    }

    public boolean createUser(User user) {
        try {
            user.setId((++counter));
            users.put(user.getId(), user);
            return true;
        } catch (Exception e) {
            log.error("exception caught during creation " + e.getMessage());
            return false;
        }
    }

    public boolean updateUser(User user) {
        if (user.getId() < 0) {
            return false;
        }

        users.put(user.getId(), user);
        return true;
    }

    public boolean deleteUser(int id) {
        try {
            users.remove(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
