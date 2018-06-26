package com.futurebim.common.model.edo;

/**
 * The persistent class for the user_project_access database table.
 *
 */
public class UserProjectAccessEdo extends UserProjectAccessReferenceEdo {

  private ProjectEdo project;

  private UserEdo user;

  public UserProjectAccessEdo() {
  }

  public ProjectEdo getProject() {
    return this.project;
  }

  public void setProject(final ProjectEdo project) {
    this.project = project;
  }

  public UserEdo getUser() {
    return this.user;
  }

  public void setUser(final UserEdo user) {
    this.user = user;
  }

}
