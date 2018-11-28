package com.featurebim.gui.model.ui;

import java.util.Date;

import org.springframework.context.annotation.Scope;

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

  public boolean isValid(final int timeOut) {

    final Date currect = new Date();
    long diff = currect.getTime() - this.loginTime.getTime();
    diff /= 1000;

    return diff <= timeOut;
  }

  public UiSessionUserInfo() {

  }

  public UiSessionUserInfo(final GuiUserFull user) {
    this.user = user;
    this.loginTime = new Date();

  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(final Date loggedDate) {
    this.loginTime = loggedDate;
  }

  public void update() {
    this.loginTime = new Date();
  }

  public GuiUserFull getUser() {
    return user;
  }

  public void setUser(final GuiUserFull user) {
    this.user = user;
  }

}
