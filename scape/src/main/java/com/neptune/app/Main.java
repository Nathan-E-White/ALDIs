package com.neptune.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args) {
        log.info("Start Logging");
        System.out.println("Hello world!");
        log.info("End Logging");
    }
}
