package io.acode.spark_starter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.acode.spark_starter.control.ControlModule;
import lombok.extern.slf4j.Slf4j;
import io.acode.spark_starter.service.Service;
import io.acode.spark_starter.service.ServiceImpl;
import io.acode.spark_starter.service.ServiceModule;
import io.acode.spark_starter.service.handlers.HandlerModule;
import io.acode.spark_starter.service.routes.RoutesModule;

/**
 * Created by Aaron on 12/19/16.
 *
 * The crux!
 */
@Slf4j
public class App {

    public static void main(String ... args) {
        //System.setProperty("logback.configurationFile", "logback.xml");
        log.info("starting application");
        App app = new App();
        app.start();
    }

    private void start() {
        Injector injector = Guice.createInjector(
            new ServiceModule(),
            new HandlerModule(),
            new RoutesModule(),
            new ControlModule()
        );

        Service server = injector.getInstance(ServiceImpl.class);
        server.start();
    }

}
