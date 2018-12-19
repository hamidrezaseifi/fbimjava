package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccessEdo {

  private Long projectid;

  private Long userid;

  private LocalDateTime created;

  private int status;

  private ProjectAccessTypeEdo projectAccessType;

  public UserProjectAccessEdo() {
  }

  public Long getUserid() {
    return this.userid;
  }

  public void setUserid(final Long userid) {
    this.userid = userid;
  }

  public Long getProjectid() {
    return this.projectid;
  }

  public void setProjectid(final Long projectid) {
    this.projectid = projectid;
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

  public ProjectAccessTypeEdo getProjectAccessType() {
    return this.projectAccessType;
  }

  public void setProjectAccessType(final ProjectAccessTypeEdo projectAccessType) {
    this.projectAccessType = projectAccessType;
  }

}
