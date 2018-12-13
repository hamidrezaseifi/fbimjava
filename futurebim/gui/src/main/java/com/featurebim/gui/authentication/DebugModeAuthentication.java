package com.featurebim.gui.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DebugModeAuthentication {
  
  @Value("${fb.ui.debuglogin.profile}")
  private String debugLoginProfile;
  
  @Value("${fb.ui.debuglogin.profile.admin.user}")
  private String debugLoginAdministratorUsername;
  
  @Value("${fb.ui.debuglogin.profile.user.user}")
  private String debugLoginUserUsername;
  
  private List<String> validProfiles;
  
  @PostConstruct
  public void init() {
    validProfiles = new ArrayList<>();
    validProfiles.add("admin");
    validProfiles.add("user");
  }
  
  public String getDebugLoginProfile() {
    return debugLoginProfile;
  }
  
  public String getDebugLoginAdministratorUsername() {
    return debugLoginAdministratorUsername;
  }
  
  public String getDebugLoginUserUsername() {
    return debugLoginUserUsername;
  }
  
  public String getCurrentDebugLoginUsername() {
    if (debugLoginProfile.toLowerCase().equals("admin")) {
      return debugLoginAdministratorUsername;
    }
    if (debugLoginProfile.toLowerCase().equals("user")) {
      return debugLoginUserUsername;
    }
    
    return "";
  }
  
  public boolean isDebugLoginEnabled() {
    return debugLoginProfile != null && !debugLoginProfile.equals("")
        && validProfiles.contains(debugLoginProfile)
        && !getCurrentDebugLoginUsername().isEmpty();
  }
  
}
