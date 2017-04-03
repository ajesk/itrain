package service;

import com.google.inject.AbstractModule;

/**
 * Created by Aaron on 2/3/17.
 *
 * Including the service module
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ServiceImpl.class).asEagerSingleton();
    }
}
