package com.IOC;

@Bean("morning")
public class MorningGreetingExmpl {
    String morning(String name) {
        return "Good morning " + name;
    }
}
