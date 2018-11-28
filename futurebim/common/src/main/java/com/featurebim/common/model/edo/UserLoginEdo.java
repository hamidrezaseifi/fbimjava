package com.featurebim.common.model.edo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.featurebim.common.rest.json.JsonConstants;

/**
 * The persistent class for the users database table.
 *
 */
public class UserLoginEdo {

  private String username;

  private String password;

  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime created;

  public UserLoginEdo() {
    created = LocalDateTime.now();
  }

  public UserLoginEdo(final String username, final String password) {
    created = LocalDateTime.now();
    this.password = password;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

}
