package com.IOC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        var context = new CustomContext();
        var printer = context.getBean(HelloPrinter.class);
        var morningPrinter = context.getBean(MorningGreetingExmpl.class);
        log.info(morningPrinter.morning("Max"));
        printer.print();
    }
}
