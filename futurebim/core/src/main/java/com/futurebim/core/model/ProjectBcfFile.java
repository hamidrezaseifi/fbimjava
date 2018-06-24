package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The persistent class for the project_bcf_files database table.
 * 
 */
public class ProjectBcfFile implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private LocalDateTime created;

	private String fileName;

	private String filePath;

	private String objectId;

	private short status;

	private LocalDateTime updated;

	private String viewpoint;

	private Project project;

	public ProjectBcfFile() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getViewpoint() {
		return this.viewpoint;
	}

	public void setViewpoint(String viewpoint) {
		this.viewpoint = viewpoint;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}