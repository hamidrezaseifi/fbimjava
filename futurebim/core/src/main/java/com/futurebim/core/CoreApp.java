package com.futurebim.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApp {

  private static final Logger logger = LoggerFactory.getLogger(CoreApp.class);

  public static void main(final String[] args) {
    CoreApp.logger.info("Starting Feature Bim Core application...");
    SpringApplication.run(CoreApp.class, args);

  }
}
