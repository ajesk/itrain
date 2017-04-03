package service.routes;

import com.google.inject.Inject;
import control.user.UserControl;
import control.user.UserControlImpl;
import lombok.extern.slf4j.Slf4j;
import models.User;
import spark.*;

@Slf4j
public class UserRoute extends Route {

    private UserControl userService;

    @Inject
    public UserRoute(UserControlImpl userService) {
        this.userService = userService;
    }

    @Override
    public Object get(Request request, Response response) {
        log.info("get all users called");
        return userService.getAllUsers();
    }

    @Override
    public String create(Request request, Response response) {
        if (userService.createUser(request.queryParams("name"), request.queryParams("email")) != null) {
            response.status(200);
            return "ok";
        } else {
            response.status(500);
            return "error";
        }

    }
}
