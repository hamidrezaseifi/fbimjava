package com.featurebim.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.featurebim.common.crypt.CryptionConfig;
import com.featurebim.common.rest.xml.XmlRestConfig;

@SpringBootApplication
public class CoreApp {

  private static final Logger logger = LoggerFactory.getLogger(CoreApp.class);

  @Configuration
  @Import(CryptionConfig.class)
  static class CoreCryptionConfig {

  }

  @Configuration
  @Import(XmlRestConfig.class)
  static class CoreXmlRestConfig {

  }

  public static void main(final String[] args) {
    CoreApp.logger.info("Starting Feature Bim Core application...");
    SpringApplication.run(CoreApp.class, args);

  }
}
