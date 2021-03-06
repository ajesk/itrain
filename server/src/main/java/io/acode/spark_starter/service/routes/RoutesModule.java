package io.acode.spark_starter.service.routes;

import com.google.common.reflect.ClassPath;
import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoutesModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            for (ClassPath.ClassInfo classInfo:
                    ClassPath.from(getClass().getClassLoader()).getTopLevelClasses("io.acode.spark_starter.service.routes")) {
                if (classInfo.getName().equalsIgnoreCase("io.acode.spark_starter.service.routes.Route") ||
                        classInfo.getName().equalsIgnoreCase("io.acode.spark_starter.service.routes.RoutesModule")) {
                    continue;
                }
                bind(classInfo.load()).asEagerSingleton();
            }
        } catch (Exception e) {
            log.error("issue during route class initialization");
        }
    }
}
