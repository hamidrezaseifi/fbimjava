package com.futurebim.common.models.edo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the projects database table.
 * 
 */

public class ProjectReferenceEdo  {

  private Long id;

  private Long companyid;

	private LocalDateTime created;

	private LocalDate deatline;

	private String projectName;

  private int responsibleUser;

	private LocalDate startDate;

	private short status;

	private LocalDateTime updated;

	private int version;

	public ProjectReferenceEdo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
  public Long getCompanyid() {
    return companyid;
  }
  
  public void setCompanyid(Long companyid) {
    this.companyid = companyid;
  }

  public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDate getDeatline() {
		return this.deatline;
	}

	public void setDeatline(LocalDate deatline) {
		this.deatline = deatline;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getResponsibleUser() {
		return this.responsibleUser;
	}

	public void setResponsibleUser(int responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
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

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


}