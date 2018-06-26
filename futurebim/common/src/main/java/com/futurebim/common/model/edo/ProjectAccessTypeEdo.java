package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the project_access_type database table.
 *
 */
public class ProjectAccessTypeEdo {

  private int id;

  private LocalDateTime created;

  private EStatus status;

  private String typeName;

  private LocalDateTime updated;

  // private List<UserProjectAccess> userProjectAccesses;

  public ProjectAccessTypeEdo() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
  }

  public String getTypeName() {
    return this.typeName;
  }

  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  /*
   * public List<UserProjectAccess> getUserProjectAccesses() { return this.userProjectAccesses; } public void
   * setUserProjectAccesses(List<UserProjectAccess> userProjectAccesses) { this.userProjectAccesses = userProjectAccesses; } public
   * UserProjectAccess addUserProjectAccess(UserProjectAccess userProjectAccess) { getUserProjectAccesses().add(userProjectAccess);
   * userProjectAccess.setProjectAccessType(this); return userProjectAccess; } public UserProjectAccess
   * removeUserProjectAccess(UserProjectAccess userProjectAccess) { getUserProjectAccesses().remove(userProjectAccess);
   * userProjectAccess.setProjectAccessType(null); return userProjectAccess; }
   */

}
