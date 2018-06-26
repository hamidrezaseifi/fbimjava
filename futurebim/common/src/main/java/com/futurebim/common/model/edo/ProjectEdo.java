package com.futurebim.common.model.edo;

import java.util.List;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectEdo extends ProjectReferenceEdo {

  /*
   * private List<ProjectBcfFile> projectBcfFiles; private List<ProjectIfcFile> projectIfcFiles; private List<ProjectTask> projectTasks;
   */

  private CompanyReferenceEdo companyBean;

  private List<UserProjectAccessReferenceEdo> userProjectAccesses;

  public ProjectEdo() {
  }

  public CompanyReferenceEdo getCompanyBean() {
    return this.companyBean;
  }

  public void setCompanyBean(final CompanyReferenceEdo companyBean) {
    this.companyBean = companyBean;
  }

  public List<UserProjectAccessReferenceEdo> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessReferenceEdo> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessReferenceEdo addUserProjectAccess(final UserProjectAccessReferenceEdo userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setProjectid(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessReferenceEdo removeUserProjectAccess(final UserProjectAccessReferenceEdo userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setProjectid(0L);

    return userProjectAccess;
  }

}
