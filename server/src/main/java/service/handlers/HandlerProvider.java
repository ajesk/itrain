package service.handlers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import service.debug.Hello;
import service.debug.Hello2;
import service.routes.UserRoute;
import spark.Route;

/**
 * Created by Aaron on 2/3/17.
 */
@Slf4j
public class HandlerProvider implements Provider<HandlerGrouping> {
    HandlerGrouping handlerGrouping = new HandlerGrouping();
    UserRoute userRoute;

    @Inject
    HandlerProvider(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    private void buildNewHandler(String method, String path, Route route) {
        log.debug("adding route:");
        log.debug("\t" + method);
        log.debug("\t" + path);
        log.debug("\t" + route);
        handlerGrouping.handlers.add(new Handler(method, path, route));
    }

    @Override
    public HandlerGrouping get() {
        buildNewHandler("GET", "/hello", Hello::hello);
        buildNewHandler("GET", "/hello2", Hello2::hello);
        buildNewHandler("GET", "/user", userRoute::get);
        return handlerGrouping;
    }
}
