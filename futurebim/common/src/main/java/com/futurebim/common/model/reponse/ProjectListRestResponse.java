package com.futurebim.common.model.reponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.edo.ProjectEdo;

public class ProjectListRestResponse extends FutureBimUiRestResponse {

  private List<ProjectEdo> projects = new ArrayList<>();

  public ProjectListRestResponse() {
    super();
  }

  private ProjectListRestResponse(final List<ProjectEdo> projects) {
    super();
    this.projects = projects;
  }

  public static ProjectListRestResponse createError(final HttpStatus status, final Exception ex) {
    return (ProjectListRestResponse) new FutureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static ProjectListRestResponse createList(final List<ProjectEdo> projects) {
    return new ProjectListRestResponse(projects);
  }

  public List<ProjectEdo> getProjects() {
    return projects;
  }

  public void setProjects(final List<ProjectEdo> projects) {
    this.projects = projects;
  }

}
