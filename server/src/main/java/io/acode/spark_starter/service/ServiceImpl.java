package io.acode.spark_starter.service;

import com.google.inject.Inject;
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
    private UserRoute userRoute = null;
    private ResponseTransformer jsonTransformer = JsonUtil.json();

    @Inject
    public ServiceImpl(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    @Override
    public void start() {
        buildRoute("GET", "/users", userRoute::get);
        buildRoute("GET", "/users/:id", userRoute::getById);
        buildRoute("POST", "/users", userRoute::create);
        buildRoute("PUT", "/users", userRoute::update);
        buildRoute("DELETE", "/users/:id", userRoute::delete);
    }

    private void buildRoute(String method, String path, Route route) {
        switch (method.toUpperCase()) {
            case "GET":
                get(path, method, route, jsonTransformer);
                break;
            case "POST":
                post(path, method, route, jsonTransformer);
                break;
            case "PUT":
                put(path, method, route, jsonTransformer);
                break;
            case "DELETE":
                delete(path, method, route, jsonTransformer);
                break;
        }
    }

    @Override
    public void stop() {
        // todo: add shutdown hook
        log.error("need to put a shutdown hook :)");
    }
}
