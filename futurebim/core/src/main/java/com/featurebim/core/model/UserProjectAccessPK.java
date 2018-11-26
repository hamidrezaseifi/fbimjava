package com.featurebim.core.model;

import javax.validation.constraints.NotNull;

import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The primary key class for the user_project_access database table.
 *
 */
public class UserProjectAccessPK extends SerializableModelBase {

  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @NotNull
  private int userid;

  @NotNull
  private int projectid;

  public UserProjectAccessPK() {
  }

  public int getUserid() {
    return this.userid;
  }

  public void setUserid(final int userid) {
    this.userid = userid;
  }

  public int getProjectid() {
    return this.projectid;
  }

  public void setProjectid(final int projectid) {
    this.projectid = projectid;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof UserProjectAccessPK)) {
      return false;
    }
    final UserProjectAccessPK castOther = (UserProjectAccessPK) other;
    return (this.userid == castOther.userid)
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
