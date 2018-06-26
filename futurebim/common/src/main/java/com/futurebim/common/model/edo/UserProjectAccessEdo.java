package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccessEdo {

  protected Long projectid;

  protected Long userid;

  protected LocalDateTime created;

  protected EStatus status;

  protected ProjectAccessTypeEdo projectAccessType;

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

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
  }

  public ProjectAccessTypeEdo getProjectAccessType() {
    return this.projectAccessType;
  }

  public void setProjectAccessType(final ProjectAccessTypeEdo projectAccessType) {
    this.projectAccessType = projectAccessType;
  }

}
