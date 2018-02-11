package io.acode.itrain.db;

import com.google.common.reflect.ClassPath;
import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            for (ClassPath.ClassInfo classInfo:
                    ClassPath.from(getClass().getClassLoader()).getTopLevelClasses("io.acode.itrain.db.*")) {
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
