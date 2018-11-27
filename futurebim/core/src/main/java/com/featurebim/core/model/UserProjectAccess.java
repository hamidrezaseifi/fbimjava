package com.featurebim.core.model;

import java.time.LocalDateTime;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccess {

  private Long id;

  private LocalDateTime created;

  private int status;

  private ProjectAccessType projectAccessType;

  public UserProjectAccess() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public ProjectAccessType getProjectAccessType() {
    return this.projectAccessType;
  }

  public void setProjectAccessType(final ProjectAccessType projectAccessType) {
    this.projectAccessType = projectAccessType;
  }

}
