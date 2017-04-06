package service.routes;

import com.google.inject.Inject;
import control.user.UserControl;
import control.user.UserControlImpl;
import lombok.extern.slf4j.Slf4j;
import models.User;
import spark.*;
import util.JsonUtil;

import java.util.List;

/**
 * This is the basic implementation of a Spark route handler. Each call from the framework gets a Spark request and
 * response object. Additional calls can be added here and/or in the Route abstract class and called from the
 * HandlerProvider class.
 *
 * Try not to use this to handle any business logic as this should be treated more as a pass through to your Controller
 * classes. This here should be utilized just to handle the Spark internals regarding the request and response.
 */
@Slf4j
public class UserRoute extends Route {

    private UserControl userService;

    @Inject
    public UserRoute(UserControlImpl userService) {
        this.userService = userService;
    }

    @Override
    public List<User> get(Request request, Response response) {
        log.info("get all users called");
        List<User> users = userService.getAllUsers();

        if (users.size() == 0) {
            response.status(404);
        } else {
            response.status(200);
        }
        return users;
    }

    @Override
    public User getById(Request request, Response response) {
        log.info("get user by id called");
        int id;

        try {
            id = Integer.parseInt(request.params("id"));
        } catch (Exception e) {
            log.error("invalid id provided");
            response.status(500);
            return new User();
        }

        User user = userService.getUser(id);

        if (user == null) {
            log.warn("user not found");
            response.status(404);
            return null;
        }

        response.status(200);
        return user;
    }

    @Override
    public String create(Request request, Response response) {
        log.info("create user called");
        try {
            User user = JsonUtil.fromJson(request.body(), User.class);

            if (user == null) {
                response.status(400);
                return "unable to parse request body";
            }

            if (!userService.createUser(user)) {
                response.status(500);
                return "issue creating user";
            }
        } catch (Exception e) {
            log.error("exception caught in handling: " + e.getMessage());
            response.status(500);
            return "error";
        }

        response.status(200);
        return "ok";
    }

    @Override
    public String update(Request request, Response response) {
        log.info("update user called");
        try {
            User user = JsonUtil.fromJson(request.body(), User.class);

            if (user == null) {
                response.status(400);
                return "unable to parse request body";
            }

            if (!userService.updateUser(user)) {
                response.status(500);
                return "issue updating user";
            }
        } catch (Exception e) {
            log.error("exception caught in handling update: " + e.getMessage());
            response.status(500);
            return "error";
        }

        response.status(200);
        return "ok";
    }

    @Override
    public String delete(Request request, Response response) {
        log.info("delete user called");
        int id;

        try {
            id = Integer.parseInt(request.params("id"));
        } catch (Exception e) {
            log.error("invalid id provided");
            response.status(500);
            return "error";
        }

        if (!userService.deleteUser(id)) {
            log.warn("user not deleted");
            response.status(404);
            return "error";
        }

        response.status(200);
        return "ok";
    }
}
