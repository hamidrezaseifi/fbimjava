package com.featurebim.common.model.edo;

import java.time.LocalDateTime;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyEdo {

  private Long id;

  private String comments;

  private String companyName;

  private int status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  public CompanyEdo() {
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

  public String getCompanyName() {
    return this.companyName;
  }

  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = status;
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

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
