package io.acode.spark_starter.service.handlers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.service.routes.UserRoute;
import spark.Route;

/**
 * Created by Aaron on 2/3/17.
 *
 * This is where the API route themselves are built. When creating new functionality you need to add another Route to the
 * routes package, a new Injection for that route in the Routes module, the injection point down below, and lastly a
 * buildNewHandler call down below. You can follow either example below to make your method reference (either static or
 * a call to a Route object)
 */
@Slf4j
public class HandlerProvider implements Provider<HandlerGrouping> {
    private HandlerGrouping handlerGrouping = new HandlerGrouping();
    private UserRoute userRoute;

    @Inject
    HandlerProvider(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    private void buildNewHandler(String method, String path, Route route) {
        log.debug("adding route: \t" + method + "\t" + path + "\t" + route);
        handlerGrouping.handlers.add(new Handler(method, path, route));
    }

    @Override
    public HandlerGrouping get() {
        buildNewHandler("GET", "/user", userRoute::get);
        buildNewHandler("GET", "/user/:id", userRoute::getById);
        buildNewHandler("PUT", "/user", userRoute::create);
        buildNewHandler("DELETE", "/user/:id", userRoute::delete);
        return handlerGrouping;
    }
}
