package control;

import com.google.inject.AbstractModule;
import control.user.UserControlImpl;

/**
 * Created by Aaron on 2/18/17.
 */
public class ControlModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserControlImpl.class).asEagerSingleton();
    }
}
