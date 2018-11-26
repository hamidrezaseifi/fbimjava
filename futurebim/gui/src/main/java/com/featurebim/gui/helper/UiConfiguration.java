package com.featurebim.gui.helper;

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

    @Value("${core.rest.url.ifc}")
    private String ifcReadPath;



    @PostConstruct
    private void init() {

    }

    public String getAllProjectsReadPath(final String additionalPath) {
      return allProjectsReadPath + additionalPath;
    }
    
    public void setAllProjectsReadPath(final String allProjectsReadPath) {
      this.allProjectsReadPath = allProjectsReadPath;
    }

    public String getIfcReadPath() {
      return ifcReadPath;
    }

    public void setIfcReadPath(final String ifcReadPath) {
      this.ifcReadPath = ifcReadPath;
    }
    


  }

}
