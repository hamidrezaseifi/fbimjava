package com.featurebim.gui.model.ui;

import java.util.Date;

import org.springframework.context.annotation.Scope;

/**
 * A class to encapsulate session user data
 *
 * @author rezasei
 *
 */
@Scope("session")
public class UiSessionUserInfo {

  public static String SESSION_LOGGEDUSERINFO_KEY = "fb-session-user";

  private Date   loginTime;
  private UiUser user;

  public boolean isValid(final int timeOut) {

    final Date currect = new Date();
    long diff = currect.getTime() - this.loginTime.getTime();
    diff /= 1000;

    return diff <= timeOut;
  }

  public UiSessionUserInfo() {

  }

  public UiSessionUserInfo(final UiUser user) {
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

  public UiUser getUser() {
    return user;
  }

  public void setUser(final UiUser user) {
    this.user = user;
  }

}
