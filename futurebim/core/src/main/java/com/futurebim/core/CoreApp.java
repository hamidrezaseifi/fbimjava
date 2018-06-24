package com.futurebim.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.futurebim.core.hp.Company;

@SpringBootApplication
public class CoreApp {

	private static final Logger logger = LoggerFactory.getLogger(CoreApp.class);

	public static void main(String[] args) {
		CoreApp.logger.info("Starting Feature Bim Core application...");
		SpringApplication.run(CoreApp.class, args);
	    
	    /*System.out.println("---------------------- hello -----------------------");

	    TestHiber testHiber = ctx.getBean(TestHiber.class);
      
      System.out.println("---------------------- bean created ----------------");
	    
	    List<Company> list = testHiber.listCountries();
	    for(Company c : list){
		    System.out.println(c);
	    	
	    }*/
	    
	}

}
