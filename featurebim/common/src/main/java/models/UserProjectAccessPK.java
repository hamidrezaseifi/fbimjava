package com.featurebim.common.models;

import java.io.Serializable;

/**
 * The primary key class for the user_project_access database table.
 * 
 */
public class UserProjectAccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int userid;

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

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid;
		hash = hash * prime + this.projectid;
		
		return hash;
	}
}