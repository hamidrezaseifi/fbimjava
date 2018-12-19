package com.futurebim.common.model.edo;

public class UserPasswordEdo {

  private UserEdo user;
  private String  password;

  /**
   * @return the user
   */
  public UserEdo getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(final UserEdo user) {
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
  
}
