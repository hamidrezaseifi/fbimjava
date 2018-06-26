package com.futurebim.common.model.edo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the user_project_access database table.
 * 
 */
public class UserProjectAccessReferenceEdo {

  private Long projectid;
  
  private Long userid;
	  
	private LocalDateTime created;

	private short status;

	private ProjectAccessTypeEdo projectAccessType;

	public UserProjectAccessReferenceEdo() {
	}

  public Long getUserid() {
    return this.userid;
  }
  
  public void setUserid(Long userid) {
    this.userid = userid;
  }
  
  public Long getProjectid() {
    return this.projectid;
  }
  
  public void setProjectid(Long projectid) {
    this.projectid = projectid;
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

	public ProjectAccessTypeEdo getProjectAccessType() {
		return this.projectAccessType;
	}

	public void setProjectAccessType(ProjectAccessTypeEdo projectAccessType) {
		this.projectAccessType = projectAccessType;
	}


}