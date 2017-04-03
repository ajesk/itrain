package service.handlers;

import com.google.inject.AbstractModule;

public class HandlerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HandlerGrouping.class).toProvider(HandlerProvider.class);
    }
}
