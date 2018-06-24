package com.futurebim.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuiApp {

	  private static final Logger logger = LoggerFactory.getLogger(GuiApp.class);

	public static void main(String[] args) {
		GuiApp.logger.info("Starting Feature Bim GUI application...");
	    SpringApplication.run(GuiApp.class, args);
	}

}
