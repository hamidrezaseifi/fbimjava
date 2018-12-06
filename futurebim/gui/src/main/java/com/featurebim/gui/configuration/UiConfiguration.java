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
    
    @Value("${core.rest.url.user.save}")
    private String userSave;
    
    @Value("${core.rest.url.user.setpassword}")
    private String userSetPassword;
    
    @Value("${core.rest.url.company.read}")
    private String companyRead;
    
    @Value("${core.rest.url.company.update}")
    private String companyUpdate;
    
    @PostConstruct
    private void init() {
      
    }
    
    /**
     * @return the allProjectsReadPath
     */
    public String getAllProjectsReadPath() {
      return allProjectsReadPath;
    }
    
    /**
     * @param allProjectsReadPath the allProjectsReadPath to set
     */
    public void setAllProjectsReadPath(final String allProjectsReadPath) {
      this.allProjectsReadPath = allProjectsReadPath;
    }
    
    /**
     * @return the userAuthenticate
     */
    public String getUserAuthenticate() {
      return userAuthenticate;
    }
    
    /**
     * @param userAuthenticate the userAuthenticate to set
     */
    public void setUserAuthenticate(final String userAuthenticate) {
      this.userAuthenticate = userAuthenticate;
    }
    
    /**
     * @return the userSave
     */
    public String getUserSave() {
      return userSave;
    }

    /**
     * @param userSave the userSave to set
     */
    public void setUserSave(final String userSave) {
      this.userSave = userSave;
    }

    /**
     * @return the userSetPassword
     */
    public String getUserSetPassword() {
      return userSetPassword;
    }

    /**
     * @param userSetPassword the userSetPassword to set
     */
    public void setUserSetPassword(final String userSetPassword) {
      this.userSetPassword = userSetPassword;
    }
    
    /**
     * @return the companyRead
     */
    public String getCompanyRead() {
      return companyRead;
    }
    
    /**
     * @param companyRead the companyRead to set
     */
    public void setCompanyRead(final String companyRead) {
      this.companyRead = companyRead;
    }
    
    /**
     * @return the companyUpdate
     */
    public String getCompanyUpdate() {
      return companyUpdate;
    }
    
    /**
     * @param companyUpdate the companyUpdate to set
     */
    public void setCompanyUpdate(final String companyUpdate) {
      this.companyUpdate = companyUpdate;
    }

  }
  
}
