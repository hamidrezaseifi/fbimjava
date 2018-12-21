package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

/**
 * The persistent class for the project_access_type database table.
 *
 */
public class ProjectAccessTypeEdo {

	private int id;

	private LocalDateTime created;

	private int status;

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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(final int status) {
		this.status = status;
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
