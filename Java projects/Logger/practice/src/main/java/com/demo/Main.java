package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Entering application.");
        logger.debug("Hello from Logback");
        logger.debug("getNumber() : {}", getNumber());
        logger.info("Exiting application.");
    }

    private static int getNumber() {
        return 5;
    }
}
