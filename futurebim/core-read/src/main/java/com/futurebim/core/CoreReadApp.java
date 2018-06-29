package com.futurebim.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreReadApp {

  private static final Logger logger = LoggerFactory.getLogger(CoreReadApp.class);

  public static void main(final String[] args) {
    CoreReadApp.logger.info("Starting Feature Bim Core application...");
    SpringApplication.run(CoreReadApp.class, args);

  }
}
