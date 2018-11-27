package com.featurebim.gui.configuration;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * a class to collect gui configuration from property file
 *
 * @author rezasei
 *
 */
@Component
public class UiConfiguration {

  public final static String GERMAN_DATE_FORMAT = "dd.MM.yyyy";

  public final static String ISO_DATE_FORMAT = "yyyy-MM-dd'T'";

  public final static String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnn";

  /**
   * configs regarding core
   */
  @Component
  public static class CoreAccessConfig {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${core.rest.url.projects}")
    private String allProjectsReadPath;

    @Value("${core.rest.url.user.authenticate}")
    private String userAuthenticate;

    @PostConstruct
    private void init() {

    }

    public String getUserAuthenticate() {
      return userAuthenticate;
    }

    public void setUserAuthenticate(final String userAuthenticate) {
      this.userAuthenticate = userAuthenticate;
    }

    public String getAllProjectsReadPath() {
      return allProjectsReadPath;
    }

  }

}
