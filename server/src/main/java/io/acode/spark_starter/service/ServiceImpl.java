package io.acode.spark_starter.service;

import com.google.inject.Inject;
import io.acode.spark_starter.service.routes.UserRoute;
import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.util.JsonUtil;
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

    @Inject
    public ServiceImpl(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    @Override
    public void start() {
        buildRoute("GET", "/user", userRoute::get);
        buildRoute("GET", "/user/:id", userRoute::getById);
        buildRoute("POST", "/user", userRoute::create);
        buildRoute("PUT", "/user", userRoute::update);
        buildRoute("DELETE", "/user/:id", userRoute::delete);
    }

    private void buildRoute(String method, String path, Route route) {
        switch (method.toUpperCase()) {
            case "GET":
                get(path, method, route, JsonUtil.json());
                break;
            case "POST":
                post(path, method, route, JsonUtil.json());
                break;
            case "PUT":
                put(path, method, route, JsonUtil.json());
                break;
            case "DELETE":
                delete(path, method, route, JsonUtil.json());
                break;
        }
    }

    @Override
    public void stop() {
        // todo: add shutdown hook
        log.error("need to put a shutdown hook :)");
    }
}
