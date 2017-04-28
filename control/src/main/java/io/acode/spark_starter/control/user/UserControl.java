package io.acode.spark_starter.control.user;

import io.acode.spark_starter.control.ControlResponse;
import io.acode.spark_starter.models.User;

import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 */
public interface UserControl {
    ControlResponse<List<User>> getAllUsers();
    ControlResponse<User> getUser(int id);
    ControlResponse createUser(User user);
    ControlResponse updateUser(User user);
    ControlResponse deleteUser(int id);
}
