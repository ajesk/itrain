import com.google.inject.Guice;
import com.google.inject.Injector;
import control.ControlModule;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import service.ServiceImpl;
import service.ServiceModule;
import service.handlers.HandlerModule;
import service.routes.RoutesModule;

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
