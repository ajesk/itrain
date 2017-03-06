package service.routes;

import com.google.inject.Inject;
import control.user.UserControl;
import control.user.UserControlImpl;
import lombok.extern.slf4j.Slf4j;
import spark.*;

@Slf4j
public class UserRoute extends Route {

    UserControl userService;

    @Inject
    public UserRoute(UserControlImpl userService) {
        this.userService = userService;
    }

    @Override
    public Object get(Request request, Response response) {
        return userService.getAllUsers();
    }
}
