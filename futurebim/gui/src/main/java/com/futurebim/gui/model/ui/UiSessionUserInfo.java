package com.futurebim.gui.model.ui;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.futurebim.gui.model.futurebim.GuiCompany;
import com.futurebim.gui.model.futurebim.GuiProjectRole;
import com.futurebim.gui.model.futurebim.GuiUserFull;

/**
 * A class to encapsulate session user data
 *
 * @author rezasei
 *
 */
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UiSessionUserInfo {

  public static String SESSION_LOGGEDUSERINFO_KEY = "fb-session-user";

  @Value("${server.session.timeout}")
  private int sessionTimeOut;

  private Date                 loginTime;
  private GuiUserFull          user;
  private GuiCompany           company;
  private List<GuiProjectRole> projectRoles;

  public boolean isLoggedIn() {
    return user != null && company != null;
  }
  
  public boolean isValid() {
    
    return isLoggedIn() && isNotOld();
  }
  
  public boolean isNotOld() {

    final Date currect = new Date();
    long       diff    = currect.getTime() - this.loginTime.getTime();
    diff /= 1000;

    return diff <= sessionTimeOut;
  }
  
  public UiSessionUserInfo() {
    this.user = null;
    this.company = null;
    this.projectRoles = null;
    this.loginTime = new Date();
  }
  
  public void update() {
    this.loginTime = new Date();
  }
  
  /**
   * @return the loginTime
   */
  public Date getLoginTime() {
    return loginTime;
  }
  
  /**
   * @param loginTime the loginTime to set
   */
  public void setLoginTime(final Date loginTime) {
    this.loginTime = loginTime;
  }
  
  /**
   * @return the user
   */
  public GuiUserFull getUser() {
    return user;
  }
  
  /**
   * @param user the user to set
   */
  public void setUser(final GuiUserFull user) {
    this.user = user;
  }
  
  /**
   * @return the company
   */
  public GuiCompany getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final GuiCompany company) {
    this.company = company;
  }

  /**
   * @return the projectRoles
   */
  public List<GuiProjectRole> getProjectRoles() {
    return projectRoles;
  }
  
  /**
   * @return the projectRoles
   */
  public GuiProjectRole getProjectRoleById(final Long id) {
    
    for (final GuiProjectRole role : projectRoles) {
      if (role.getId() == id) {
        return role;
      }
    }
    return null;
  }

  /**
   * @param projectRoles the projectRoles to set
   */
  public void setProjectRoles(final List<GuiProjectRole> projectRoles) {
    this.projectRoles = projectRoles;
  }

}
