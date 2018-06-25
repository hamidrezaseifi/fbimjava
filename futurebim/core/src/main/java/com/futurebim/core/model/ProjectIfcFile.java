package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.futurebim.core.model.base.SerializableModelBase;
import com.futurebim.core.model.enums.EStatus;
import com.futurebim.core.model.enums.base.UnknownEnumValueException;


/**
 * The persistent class for the project_ifc_files database table.
 * 
 */
public class ProjectIfcFile extends SerializableModelBase {
	private static final long serialVersionUID = 1L;

	private int id;

	private LocalDateTime created;

	private String fileName;

	private String filePath;

	private EStatus status;

	private LocalDateTime updated;

	private Project project;

	public ProjectIfcFile() {
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

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(Long status) throws UnknownEnumValueException {
		this.status = EStatus.ofId(status);
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}