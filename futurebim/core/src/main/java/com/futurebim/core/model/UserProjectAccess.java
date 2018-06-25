package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.core.model.base.SerializableModelBase;


/**
 * The persistent class for the user_project_access database table.
 * 
 */
@Entity
@Table(name="user_project_access")
public class UserProjectAccess extends SerializableModelBase {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserProjectAccessPK id;
	  
	private LocalDateTime created;

	private short status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "access_type", insertable=false, updatable=false)  
	private ProjectAccessType projectAccessType;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectid", insertable=false, updatable=false)  
	private Project project;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userid", insertable=false, updatable=false)  
	private User user;

	public UserProjectAccess() {
	}

	public UserProjectAccessPK getId() {
		return this.id;
	}

	public void setId(UserProjectAccessPK id) {
		this.id = id;
	}

  public void setCreated(LocalDateTime created) {
		this.created = created;
	}

  public LocalDateTime getCreated() {
    return this.created;
  }

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public ProjectAccessType getProjectAccessType() {
		return this.projectAccessType;
	}

	public void setProjectAccessType(ProjectAccessType projectAccessType) {
		this.projectAccessType = projectAccessType;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}