package io.acode.itrain.control.user;

import com.google.inject.Inject;
import io.acode.itrain.control.ControlResponse;
import io.acode.itrain.db.HibernateConnection;
import io.acode.itrain.db.HibernateConnectionImpl;
import lombok.extern.slf4j.Slf4j;
import io.acode.itrain.models.User;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 * This is the business logic sector of the application. Here is where you would handle the results from DB calls and
 * manipulate data in the io.acode.spark_starter.control layer. To use a database in place of this you will need to create a DB handler and
 * inject it here for use.
 */

@Slf4j
public class UserControlImpl implements UserControl {

    private HibernateConnection db;

    @Inject
    UserControlImpl(HibernateConnectionImpl hibernateConnection) {
        db = hibernateConnection;
    }

    public ControlResponse<List<User>> getAllUsers() {
        List users = db.get("from User");
        if (users.isEmpty()) {
            return new ControlResponse<>(false, "user result set empty");
        }

        if (!(users.get(0) instanceof User)) {
            return new ControlResponse<>(false, "non-user results returned from query");
        }

        return new ControlResponse<>((List<User>) users);
    }

    public ControlResponse<User> getUser(int id) {
        return new ControlResponse<>((User) db.get(id, User.class));
    }

    public ControlResponse createUser(User user) {
        try {
            db.save(user);
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
        db.update(user);
        return new ControlResponse();
    }

    public ControlResponse deleteUser(int id) {
        try {
            User user = new User();
            user.setId(id);
            db.delete(user);
        } catch (Exception e) {
            return new ControlResponse(false);
        }
        return new ControlResponse();
    }
}
