package com.futurebim.gui.model.futurebim;

import com.futurebim.common.model.edo.UserPasswordEdo;

public class GuiUserPassword {
  
  private GuiUserFull user;
  private String      password;
  
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
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * @param password the password to set
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  public UserPasswordEdo toEdo() {
    final UserPasswordEdo edo = new UserPasswordEdo();
    edo.setUser(user.toUser().toEdo());
    edo.setPassword(password);

    return edo;
  }
}
