package com.futurebim.common.model.edo;

import java.util.List;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectRichEdo extends ProjectEdo {

  /*
   * private List<ProjectBcfFile> projectBcfFiles; private List<ProjectIfcFile> projectIfcFiles; private List<ProjectTask> projectTasks;
   */

  private CompanyEdo companyBean;

  private List<UserProjectAccessEdo> userProjectAccesses;

  public ProjectRichEdo() {
  }

  public CompanyEdo getCompanyBean() {
    return this.companyBean;
  }

  public void setCompanyBean(final CompanyEdo companyBean) {
    this.companyBean = companyBean;
  }

  public List<UserProjectAccessEdo> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessEdo> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessEdo addUserProjectAccess(final UserProjectAccessEdo userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setProjectid(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessEdo removeUserProjectAccess(final UserProjectAccessEdo userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setProjectid(0L);

    return userProjectAccess;
  }

}
