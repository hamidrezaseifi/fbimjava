package com.featurebim.core.model;

import java.time.LocalDateTime;

import com.featurebim.common.model.enums.EStatus;
import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_access_type database table.
 *
 */
public class ProjectAccessType extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private int id;

  private LocalDateTime created;

  private EStatus status;

  private String typeName;

  private LocalDateTime updated;

  public ProjectAccessType() {
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

}
