package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.edo.ProjectEdo;

public class ProjectRestResponse extends FBUiRestResponse {

  private ProjectEdo project;

  public ProjectRestResponse() {
    super();
  }

  private ProjectRestResponse(final ProjectEdo project) {
    super();
    this.project = project;
  }

  public static ProjectRestResponse createError(final HttpStatus status, final Exception ex) {
    return (ProjectRestResponse) new FBUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static ProjectRestResponse createData(final ProjectEdo project) {
    return new ProjectRestResponse(project);
  }

  public ProjectEdo getProject() {
    return project;
  }

  public void setProject(final ProjectEdo project) {
    this.project = project;
  }

}
