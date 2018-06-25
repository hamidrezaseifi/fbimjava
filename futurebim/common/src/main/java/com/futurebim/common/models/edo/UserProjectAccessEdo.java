package com.futurebim.common.models.edo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the user_project_access database table.
 * 
 */
public class UserProjectAccessEdo {

  private int projectid;
  
  private int userid;
	  
	private LocalDateTime created;

	private short status;

	private ProjectAccessTypeEdo projectAccessType;

	private ProjectEdo project;

	private UserEdo user;

	public UserProjectAccessEdo() {
	}

  public int getUserid() {
    return this.userid;
  }
  
  public void setUserid(int userid) {
    this.userid = userid;
  }
  
  public int getProjectid() {
    return this.projectid;
  }
  
  public void setProjectid(int projectid) {
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

	public ProjectEdo getProject() {
		return this.project;
	}

	public void setProject(ProjectEdo project) {
		this.project = project;
	}

	public UserEdo getUser() {
		return this.user;
	}

	public void setUser(UserEdo user) {
		this.user = user;
	}

}