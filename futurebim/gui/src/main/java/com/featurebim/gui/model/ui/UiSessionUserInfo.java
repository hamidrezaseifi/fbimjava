package com.featurebim.gui.model.ui;

import java.util.Date;

import org.springframework.context.annotation.Scope;

import com.featurebim.gui.model.futurebim.GuiCompany;
import com.featurebim.gui.model.futurebim.GuiUserFull;

/**
 * A class to encapsulate session user data
 *
 * @author rezasei
 *
 */
@Scope("session")
public class UiSessionUserInfo {
  
  public static String SESSION_LOGGEDUSERINFO_KEY = "fb-session-user";
  
  private Date        loginTime;
  private GuiUserFull user;
  private GuiCompany  company;
  
  public boolean isValid(final int timeOut) {
    
    final Date currect = new Date();
    long diff = currect.getTime() - this.loginTime.getTime();
    diff /= 1000;
    
    return diff <= timeOut;
  }
  
  public UiSessionUserInfo(final GuiUserFull user, final GuiCompany company) {
    this.user = user;
    this.company = company;
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
  
}
