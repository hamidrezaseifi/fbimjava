package com.futurebim.common.model.edo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.enums.EStatus;


/**
 * The persistent class for the projects database table.
 * 
 */

public class ProjectReferenceEdo  {

  private Long id;

  private Long companyid;

	private LocalDate deatline;

	private String projectName;

	private LocalDate startDate;

	private EStatus status;

  private LocalDateTime created;

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

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(EStatus status) {
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