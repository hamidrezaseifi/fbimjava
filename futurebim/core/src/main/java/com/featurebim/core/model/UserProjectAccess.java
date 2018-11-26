package com.featurebim.core.model;

import java.time.LocalDateTime;

import com.featurebim.common.model.enums.EStatus;
import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccess extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private UserProjectAccessPK id;

  private LocalDateTime created;

  private EStatus status;

  private ProjectAccessType projectAccessType;

  public UserProjectAccess() {
  }

  public UserProjectAccessPK getId() {
    return this.id;
  }

  public void setId(final UserProjectAccessPK id) {
    this.id = id;
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

  public ProjectAccessType getProjectAccessType() {
    return this.projectAccessType;
  }

  public void setProjectAccessType(final ProjectAccessType projectAccessType) {
    this.projectAccessType = projectAccessType;
  }

}
