package io.acode.spark_starter.service.routes;

import com.google.inject.Inject;
import io.acode.spark_starter.control.ControlResponse;
import io.acode.spark_starter.control.user.UserControl;
import io.acode.spark_starter.control.user.UserControlImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.models.User;
import spark.*;
import io.acode.spark_starter.util.JsonUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the basic implementation of a Spark route handler. Each call from the framework gets a Spark request and
 * response object. Additional calls can be added here and/or in the Route abstract class and called from the
 * HandlerProvider class.
 *
 * Try not to use this to handle any business logic as this should be treated more as a pass through to your Controller
 * classes. This here should be utilized just to handle the Spark internals regarding the request and response.
 */
@Path("/user")
@Slf4j
public class UserRoute extends Route {

    private UserControl userService;

    @Inject
    public UserRoute(UserControlImpl userService) {
        this.userService = userService;
    }

    @GET
    @Path("/")
    @ApiOperation(
            value = "get all users",
            notes = "gets all users"
    )
    @Override
    public List<User> get(Request request, Response response) {
        log.info("get all users called");

        try {
            ControlResponse<List<User>> controlResponse = userService.getAllUsers();
            if (!controlResponse.isSuccess()) {
                response.status(404);
                return new ArrayList<>();
            }

            response.status(200);
            return controlResponse.getResult();
        } catch (Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @GET
    @Path("/{userId}")
    @ApiOperation(
            value = "get user by id",
            notes = "get a single user by its ID"
    )
    @Override
    public User getById(Request request, Response response) {
        log.info("get user by id called");
        int id;

        try {
            id = Integer.parseInt(request.params("id"));
        } catch (Exception e) {
            log.error("invalid id provided");
            response.status(422);
            return new User();
        }

        ControlResponse controlResponse = userService.getUser(id);

        if (!controlResponse.isSuccess()) {
            log.warn("user not found");
            response.status(404);
            return null;
        }

        if (controlResponse.getResult() instanceof User) {
            response.status(200);
            return (User) controlResponse.getResult();
        }

        response.status(500);
        return new User();
    }

    @POST
    @Path("/")
    @Consumes()
    @Override
    public String create(Request request, Response response) {
        log.info("create user called");
        User user = JsonUtil.fromJson(request.body(), User.class);

        if (user == null) {
            response.status(422);
            return "unable to parse request body";
        }

        ControlResponse controlResponse = userService.createUser(user);

        if (!controlResponse.isSuccess()) {
            response.status(500);
            return "unable to create user";
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

            ControlResponse controlResponse = userService.updateUser(user);

            if (!controlResponse.isSuccess()) {
                response.status(404);
                return "user does not exist";
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

        ControlResponse controlResponse = userService.deleteUser(id);

        if (!controlResponse.isSuccess()) {
            log.warn("user not deleted");
            response.status(404);
            return "error";
        }

        response.status(200);
        return "ok";
    }
}
