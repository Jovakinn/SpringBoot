package com.nasa.ioc;

import com.nasa.config.DemoAppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringIoCDemoApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoAppConfig.class)) {
        var nasaClient = context.getBean(NasaPicturesClient.class);
        nasaClient.getAllPictureUrl()
                .forEach(log::info);
        }
    }
}
