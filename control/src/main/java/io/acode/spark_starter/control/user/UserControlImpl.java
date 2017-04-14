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

    public ControlResponse<List<User>> getAllUsers() {
        List<User> userList = users.entrySet().stream()
                    .map(entry -> entry.getValue())
                    .collect(Collectors.toList());

        if (userList.isEmpty()) {
            return new ControlResponse<>(false, "no users found");
        }

        return new ControlResponse<>(userList);
    }

    public ControlResponse<User> getUser(int id) {
        if (!users.containsKey(id)) {
            return new ControlResponse<>(false, "id does not exist");
        }
        return new ControlResponse<>(users.get(id));
    }

    public ControlResponse createUser(User user) {
        try {
            user.setId((++counter));
            users.put(user.getId(), user);
            return new ControlResponse();
        } catch (Exception e) {
            log.error("exception caught during creation " + e.getMessage());
            return new ControlResponse(false, "user not created");
        }
    }

    public ControlResponse updateUser(User user) {
        if (user.getId() < 0) {
            return new ControlResponse(false);
        }

        users.put(user.getId(), user);
        return new ControlResponse();
    }

    public ControlResponse deleteUser(int id) {
        try {
            users.remove(id);
        } catch (Exception e) {
            return new ControlResponse(false);
        }
        return new ControlResponse();
    }
}
