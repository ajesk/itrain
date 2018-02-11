package io.acode.spark_starter.service;

import com.google.inject.Inject;
import io.acode.spark_starter.service.routes.TaskRoute;
import io.acode.spark_starter.service.routes.UserRoute;
import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.util.JsonUtil;
import spark.ResponseTransformer;
import spark.Route;
import static spark.Spark.*;

/**
 * Created by Aaron on 2/3/17.
 *
 * This is the construction/implementation of the API make references to active calls here.
 */
@Slf4j
public class ServiceImpl implements Service {
    private UserRoute userRoute;
    private TaskRoute taskRoute;
    private ResponseTransformer jsonTransformer = JsonUtil.json();

    @Inject
    public ServiceImpl(UserRoute userRoute, TaskRoute taskRoute) {
        this.userRoute = userRoute;
        this.taskRoute = taskRoute;
    }

    @Override
    public void start() {
        userPaths();
        taskPaths();
    }

    private void userPaths() {
        // user
        buildRoute(Method.GET, "/users", userRoute::get);
        buildRoute(Method.GET, "/users/:id", userRoute::getById);
        buildRoute(Method.POST, "/users", userRoute::create);
        buildRoute(Method.PUT, "/users", userRoute::update);
        buildRoute(Method.DELETE, "/users/:id", userRoute::delete);
        buildRoute(Method.GET, "/users/:id/tasklists", userRoute::getTaskLists);
    }

    private void taskPaths() {
        buildRoute(Method.GET, "/tasks", taskRoute::get);
        buildRoute(Method.GET, "/tasks/:id", taskRoute::getById);
        buildRoute(Method.POST, "/tasks", taskRoute::create);
        buildRoute(Method.PUT, "/tasks/:id", taskRoute::update);
        buildRoute(Method.DELETE, "/tasks/:id", taskRoute::delete);

    }

    private void buildRoute(Method method, String path, Route route) {
        switch (method) {
            case GET:
                get(path, "GET", route, jsonTransformer);
                break;
            case POST:
                post(path, "POST", route, jsonTransformer);
                break;
            case PUT:
                put(path, "PUT", route, jsonTransformer);
                break;
            case DELETE:
                delete(path, "DELETE", route, jsonTransformer);
                break;
        }
    }

    @Override
    public void stop() {
        // todo: add shutdown hook
        log.error("need to put a shutdown hook :)");
    }
}
