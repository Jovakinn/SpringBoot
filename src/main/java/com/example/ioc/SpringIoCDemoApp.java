package com.example.ioc;

import com.example.config.DemoAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

public class SpringIoCDemoApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        var nasaClient = context.getBean(NasaPicturesClient.class);
        var restTemplate = context.getBean(RestTemplate.class);
    }
}
