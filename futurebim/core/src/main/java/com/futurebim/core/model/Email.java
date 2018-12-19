package com.futurebim.core.model;

import java.time.LocalDateTime;

/**
 * The persistent class for the emails database table.
 *
 */
public class Email {

  private Long id;

  private String comments;

  private LocalDateTime created;

  private String emailName;

  private String emailaddress;

  private LocalDateTime updated;

  private int version;

  public Email() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getEmailName() {
    return this.emailName;
  }

  public void setEmailName(final String emailName) {
    this.emailName = emailName;
  }

  public String getEmailaddress() {
    return this.emailaddress;
  }

  public void setEmailaddress(final String emailaddress) {
    this.emailaddress = emailaddress;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

}
