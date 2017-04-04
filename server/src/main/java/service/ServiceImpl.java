package service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import service.handlers.Handler;
import service.handlers.HandlerGrouping;
import util.JsonUtil;

import static spark.Spark.*;

/**
 * Created by Aaron on 2/3/17.
 *
 * This is the construction/implementation of the API it takes all of the Routes created by the handler provider and
 * initializes them for active calls
 */
@Slf4j
public class ServiceImpl implements Service {
    private HandlerGrouping routes = null;

    @Inject
    public ServiceImpl(Provider<HandlerGrouping> handlerProvider) {
        this.routes = handlerProvider.get();
    }

    @Override
    public void start() {
        for (Handler route : routes.getHandlers()) {
            switch (route.getMethod().toUpperCase()) {
                case "GET":
                    get(route.getPath(), route.getMethod(), route.getRoute(), JsonUtil.json());
                    break;
                case "POST":
                    post(route.getPath(), route.getMethod(), route.getRoute(), JsonUtil.json());
                    break;
                case "PUT":
                    put(route.getPath(), route.getMethod(), route.getRoute(), JsonUtil.json());
                    break;
                case "DELETE":
                    delete(route.getPath(), route.getMethod(), route.getRoute(), JsonUtil.json());
                    break;
            }
        }
    }

    @Override
    public void stop() {
        // todo: add shutdown hook
        log.error("need to put a shutdown hook :)");
    }
}
