package service;

import com.google.inject.AbstractModule;

/**
 * Created by Aaron on 2/3/17.
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ServiceImpl.class).asEagerSingleton();
    }
}
