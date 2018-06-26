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
public class ProjectRich extends Project {

  private static final long serialVersionUID = 1L;

  /*
   * private List<ProjectBcfFile> projectBcfFiles; private List<ProjectIfcFile> projectIfcFiles; private List<ProjectTask> projectTasks;
   */

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private Company companyBean;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.projectid", targetEntity = UserProjectAccess.class)
  private List<UserProjectAccess> userProjectAccesses;

  public ProjectRich() {
  }

  public Company getCompanyBean() {
    return this.companyBean;
  }

  public void setCompanyBean(final Company companyBean) {
    this.companyBean = companyBean;
  }

  public List<UserProjectAccess> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccess> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccess addUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);

    return userProjectAccess;
  }

  public UserProjectAccess removeUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);

    return userProjectAccess;
  }

}
