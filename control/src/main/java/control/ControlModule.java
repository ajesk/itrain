package control;

import com.google.common.reflect.ClassPath;
import com.google.inject.AbstractModule;
import control.user.UserControlImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControlModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            for (ClassPath.ClassInfo classInfo:
                    ClassPath.from(getClass().getClassLoader()).getTopLevelClasses("control.*")) {
                if (!classInfo.getName().toLowerCase().contains("impl")) {
                    continue;
                }
                bind(classInfo.load()).asEagerSingleton();
            }
        } catch (Exception e) {
            log.error("issue during route class initialization");
        }
    }
}
