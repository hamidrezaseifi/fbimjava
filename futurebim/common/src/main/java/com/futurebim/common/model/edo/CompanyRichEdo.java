package com.futurebim.common.model.edo;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyRichEdo extends CompanyEdo {

  private List<UserEdo> users = new ArrayList<>();

  private List<ProjectEdo> projects = new ArrayList<>();

  public CompanyRichEdo() {
  }

  public List<UserEdo> getUsers() {
    return users;
  }

  public void setUsers(final List<UserEdo> users) {
    this.users = users;
  }

  public List<ProjectEdo> getProjects() {
    return projects;
  }

  public void setProjects(final List<ProjectEdo> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
