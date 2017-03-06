package service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import service.debug.Hello2;
import service.handlers.Handler;
import service.handlers.HandlerGrouping;
import util.JsonUtil;

import static spark.Spark.*;

/**
 * Created by Aaron on 2/3/17.
 */
public class ServiceImpl implements Service {
    HandlerGrouping routes = null;

    @Inject
    public ServiceImpl(Provider<HandlerGrouping> handlerProvider) {
        this.routes = handlerProvider.get();
    }

    @Override
    public void start() {
        for (Handler route : routes.getHandlers()) {
            get(route.getPath(), route.getMethod(), route.getRoute(), JsonUtil.json());
        }
    }
}
