package com.futurebim.core.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the projects database table.
 *
 */
@Entity
@Table(name = "projects")
public class Project extends ProjectReference {

  private static final long serialVersionUID = 1L;

  /*
   * private List<ProjectBcfFile> projectBcfFiles; private List<ProjectIfcFile> projectIfcFiles; private List<ProjectTask> projectTasks;
   */

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private CompanyReference companyBean;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.projectid", targetEntity = UserProjectAccessReference.class)
  private List<UserProjectAccessReference> userProjectAccesses;

  public Project() {
  }

  public CompanyReference getCompanyBean() {
    return this.companyBean;
  }

  public void setCompanyBean(final CompanyReference companyBean) {
    this.companyBean = companyBean;
  }

  public List<UserProjectAccessReference> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessReference> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessReference addUserProjectAccess(final UserProjectAccessReference userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setProject(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessReference removeUserProjectAccess(final UserProjectAccessReference userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setProject(null);

    return userProjectAccess;
  }

}
