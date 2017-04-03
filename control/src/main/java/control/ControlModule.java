package control;

import com.google.inject.AbstractModule;
import control.user.UserControlImpl;

public class ControlModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserControlImpl.class).asEagerSingleton();
    }
}
