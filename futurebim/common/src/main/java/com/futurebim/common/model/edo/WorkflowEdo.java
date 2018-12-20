package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class WorkflowEdo {

	private Long id;

	private Long projectid;

	private int type;

	private String name;

	private Long responsible;

	private Long reporter;

	private int status;

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime created;

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime updated;

	private int version;

	public WorkflowEdo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id != null ? id : 0;
	}

	/**
	 * @return the projectid
	 */
	public Long getProjectid() {
		return projectid;
	}

	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(final Long projectid) {
		this.projectid = projectid != null ? projectid : 0;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(final int type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the responsible
	 */
	public Long getResponsible() {
		return responsible;
	}

	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(final Long responsible) {
		this.responsible = responsible != null ? responsible : 0;
	}

	/**
	 * @return the reporter
	 */
	public Long getReporter() {
		return reporter;
	}

	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(final Long reporter) {
		this.reporter = reporter != null ? reporter : 0;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(final int status) {
		this.status = status;
	}

	/**
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public LocalDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(final int version) {
		this.version = version;
	}

}
