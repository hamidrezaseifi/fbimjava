package com.featurebim.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuiBackApp {

	  private static final Logger logger = LoggerFactory.getLogger(GuiBackApp.class);

	public static void main(String[] args) {
		GuiBackApp.logger.info("Starting Feature Bim GUI application...");
	    SpringApplication.run(GuiBackApp.class, args);
	}

}
