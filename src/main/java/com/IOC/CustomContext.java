package com.IOC;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class CustomContext {
    private final Map<String, Object> beanMap = new HashMap<>();

    public CustomContext() {
        init();
    }

    private void init() {
        var currentPackage = getClass().getPackage().getName();
        var reflections = new Reflections(currentPackage);
        reflections.getTypesAnnotatedWith(Bean.class)
                .forEach(this::registerBean);
    }

    @SneakyThrows
    private void registerBean(Class<?> type) {
        var beanAnnotation = type.getAnnotation(Bean.class);
        var beanId = beanAnnotation.value();
        var constructor = type.getConstructor();
        var newInstance = constructor.newInstance();
        beanMap.put(beanId, newInstance);
    }


    public <T> T getBean(Class<T> type) {
        return beanMap.values()
                .stream()
                .filter(type::isInstance)
                .findAny()
                .map(type::cast)
                .orElseThrow();
    }
}
