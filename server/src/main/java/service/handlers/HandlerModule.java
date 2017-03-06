package service.handlers;

import com.google.inject.AbstractModule;

/**
 * Created by Aaron on 2/3/17.
 */
public class HandlerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HandlerGrouping.class).toProvider(HandlerProvider.class);
    }
}
