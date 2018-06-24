package com.featurebim.common.models;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The persistent class for the user_project_access database table.
 * 
 */
public class UserProjectAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserProjectAccessPK id;

	private LocalDateTime created;

	private short status;

	private ProjectAccessType projectAccessType;

	private Project project;

	private User user;

	public UserProjectAccess() {
	}

	public UserProjectAccessPK getId() {
		return this.id;
	}

	public void setId(UserProjectAccessPK id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
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