package com.arik.soft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info(
                "Starting application with {} argument(s) {}",
                args.length == 0 ? "no" : args.length,
                Arrays.toString(args)
        );
        SpringApplication.run(Application.class, args);
    }
}