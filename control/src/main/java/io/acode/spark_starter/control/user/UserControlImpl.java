package io.acode.spark_starter.control.user;

import io.acode.spark_starter.control.ControlResponse;
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
    // Normally you would store to a database
    private Map<Integer, User> users = new HashMap<>();
    private int counter = 0;

    public ControlResponse getAllUsers() {
        List<User> userList = users.entrySet().stream()
                    .map(entry -> entry.getValue())
                    .collect(Collectors.toList());

        if (userList.isEmpty()) {
            return new ControlResponse(false, "no users found");
        }

        return new ControlResponse(userList);
    }

    public ControlResponse getUser(int id) {
        if (!users.containsKey(id)) {
            return new ControlResponse(false, "id does not exist");
        }
        return new ControlResponse(users.get(id));
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
