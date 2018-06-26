package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccessEdo {

  private int projectid;

  private int userid;

  private LocalDateTime created;

  private EStatus status;

  private ProjectAccessTypeEdo projectAccessType;

  private ProjectEdo project;

  private UserEdo user;

  public UserProjectAccessEdo() {
  }

  public int getUserid() {
    return this.userid;
  }

  public void setUserid(final int userid) {
    this.userid = userid;
  }

  public int getProjectid() {
    return this.projectid;
  }

  public void setProjectid(final int projectid) {
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

  public ProjectEdo getProject() {
    return this.project;
  }

  public void setProject(final ProjectEdo project) {
    this.project = project;
  }

  public UserEdo getUser() {
    return this.user;
  }

  public void setUser(final UserEdo user) {
    this.user = user;
  }

}
