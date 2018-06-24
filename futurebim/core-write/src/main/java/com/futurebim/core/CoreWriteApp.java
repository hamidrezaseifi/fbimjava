package com.futurebim.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CoreWriteApp {

	private static final Logger logger = LoggerFactory.getLogger(CoreWriteApp.class);

	public static void main(String[] args) {
	  CoreWriteApp.logger.info("Starting Feature Bim Core application...");
		SpringApplication.run(CoreWriteApp.class, args);
	   
	    
	}

}
