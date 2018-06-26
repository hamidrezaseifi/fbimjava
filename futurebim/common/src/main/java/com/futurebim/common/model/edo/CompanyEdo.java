package com.futurebim.common.model.edo;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyEdo extends CompanyReferenceEdo {

  private List<UserReferenceEdo> users = new ArrayList<>();

  private List<ProjectReferenceEdo> projects = new ArrayList<>();

  public CompanyEdo() {
  }

  public List<UserReferenceEdo> getUsers() {
    return users;
  }

  public void setUsers(final List<UserReferenceEdo> users) {
    this.users = users;
  }

  public List<ProjectReferenceEdo> getProjects() {
    return projects;
  }

  public void setProjects(final List<ProjectReferenceEdo> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
