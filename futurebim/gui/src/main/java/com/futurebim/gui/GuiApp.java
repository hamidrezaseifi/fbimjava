package com.futurebim.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.futurebim.common.rest.xml.XmlRestConfig;

@SpringBootApplication
public class GuiApp {

  private static final Logger logger = LoggerFactory.getLogger(GuiApp.class);

  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {

  }

  public static void main(final String[] args) {
    GuiApp.logger.info("Starting Feature Bim GUI application...");
    SpringApplication.run(GuiApp.class, args);
  }

}
