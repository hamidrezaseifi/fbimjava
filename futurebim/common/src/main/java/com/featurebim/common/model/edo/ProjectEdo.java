package com.featurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.featurebim.common.rest.json.FBLocalDateDeserializer;
import com.featurebim.common.rest.json.FBLocalDateSerializer;
import com.featurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.featurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectEdo {

	private Long id;

	private Long parentProjectId;

	private Long companyid;

	private int projectType;

	private String projectName;

	@JsonSerialize(using = FBLocalDateSerializer.class)
	@JsonDeserialize(using = FBLocalDateDeserializer.class)
	private LocalDate deadline;

	@JsonSerialize(using = FBLocalDateSerializer.class)
	@JsonDeserialize(using = FBLocalDateDeserializer.class)
	private LocalDate startDate;

	private int status;

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime created;

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime updated;

	private int version;

	public ProjectEdo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id != null ? id : 0;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(final Long companyid) {
		this.companyid = companyid != null ? companyid : 0;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public LocalDate getDeadline() {
		return this.deadline;
	}

	public void setDeadline(final LocalDate deatline) {
		this.deadline = deatline;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(final int status) {
		this.status = status;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public Long getParentProjectId() {
		return parentProjectId;
	}

	public void setParentProjectId(final Long parentProjectId) {
		this.parentProjectId = parentProjectId != null ? parentProjectId : 0;
	}

	public int getProjectType() {
		return projectType;
	}

	public void setProjectType(final int projectType) {
		this.projectType = projectType;
	}

}
