package com.futurebim.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * The primary key class for the user_project_access database table.
 * 
 */
@Embeddable
public class UserProjectAccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="userid")
	private int userid;

	@NotNull
	@Column(name="projectid")
	private int projectid;

	public UserProjectAccessPK() {
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

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserProjectAccessPK)) {
			return false;
		}
		UserProjectAccessPK castOther = (UserProjectAccessPK)other;
		return 
			(this.userid == castOther.userid)
			&& (this.projectid == castOther.projectid);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid;
		hash = hash * prime + this.projectid;
		
		return hash;
	}
}