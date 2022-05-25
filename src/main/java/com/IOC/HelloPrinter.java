package com.IOC;

import lombok.extern.slf4j.Slf4j;

@Bean("Hello")
@Slf4j
public class HelloPrinter {
    public void print() {
        log.info("Hello");
    }
}
