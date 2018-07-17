package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

public class ProjectIfcRestResponse extends FutureBimUiRestResponse {

  private ProjectIfcEdo projectIfc;

  public ProjectIfcRestResponse() {
    super();
  }

  private ProjectIfcRestResponse(final ProjectIfcEdo projectIfc) {
    super();
    this.projectIfc = projectIfc;
  }

  public static ProjectIfcRestResponse createError(final HttpStatus status, final Exception ex) {
    return (ProjectIfcRestResponse) new FutureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static ProjectIfcRestResponse createData(final ProjectIfcEdo projectIfc) {
    return new ProjectIfcRestResponse(projectIfc);
  }

  public ProjectIfcEdo getProjectIfc() {
    return projectIfc;
  }

  public void setProjectIfc(final ProjectIfcEdo projectIfc) {
    this.projectIfc = projectIfc;
  }

}
