package com.futurebim.core.model;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.enums.EStatus;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the user_project_access database table.
 *
 */
@Entity
@Table(name = "user_project_access")
public class UserProjectAccess extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private UserProjectAccessPK id;

  private LocalDateTime created;

  private EStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "access_type", insertable = false, updatable = false)
  private ProjectAccessType projectAccessType;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectid", insertable = false, updatable = false)
  private Project project;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userid", insertable = false, updatable = false)
  private User user;

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

  public Project getProject() {
    return this.project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

}
