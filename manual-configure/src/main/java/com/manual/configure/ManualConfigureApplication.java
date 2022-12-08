package com.manual.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManualConfigureApplication {
    private final Logger LOGGER = LoggerFactory.getLogger(ManualConfigureApplication.class);


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ManualConfigureApplication.class, args);
    }
}
