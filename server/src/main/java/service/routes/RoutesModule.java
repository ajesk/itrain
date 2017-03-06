package service.routes;

import com.google.inject.AbstractModule;

public class RoutesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRoute.class).asEagerSingleton();
    }
}
