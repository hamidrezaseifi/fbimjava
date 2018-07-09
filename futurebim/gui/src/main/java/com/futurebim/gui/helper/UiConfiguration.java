package com.futurebim.gui.helper;

import java.net.URI;
import java.net.URISyntaxException;

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

    @Value("${core.rest.url.base}")
    private String baseUrlString;

    @Value("${core.rest.url.projects}")
    private String projectsPath;

    @Value("${core.rest.url.ifc}")
    private String ifcPath;


    public URI getBaseUri() {
      return URI.create(baseUrlString);
    }

    @PostConstruct
    private void init() {
      log.info("CORE Base URL: {}", baseUrlString);
      log.info("CORE Project URL: {}", getProjectsPath(""));
      log.info("CORE IFC URL: {}", getIfcPath());
      log.info(" German Date Format: {}", GERMAN_DATE_FORMAT);
      log.info(" ISO Date Format: {}", ISO_DATE_FORMAT);
      log.info(" ISO Date-Time Format: {}", ISO_DATE_TIME_FORMAT);
    }




    public String getProjectsPath(final String additionalPath) {
      return buildPath(projectsPath + additionalPath);
    }


    public void setProjectsPath(final String projectsPath) {
      this.projectsPath = projectsPath;
    }


    public String getIfcPath() {
      return buildPath(ifcPath);
    }


    public void setIfcPath(final String ifcPath) {
      this.ifcPath = ifcPath;
    }





    private URI buildUri(final String relativePath) {

      try {
        final String url = baseUrlString + "/" + relativePath;
        return new URI(url).normalize();
      }
      catch (final URISyntaxException e) {
        throw new RuntimeException(e);
      }
    }

    private String buildPath(final String relativePath) {

      return baseUrlString + "/" + relativePath;
    }

  }

}
