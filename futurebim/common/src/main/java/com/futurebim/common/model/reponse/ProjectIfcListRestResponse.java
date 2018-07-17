package com.futurebim.common.model.reponse;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

public class ProjectIfcListRestResponse extends FutureBimUiRestResponse {

  private List<ProjectIfcEdo> projectIfcList;

  public ProjectIfcListRestResponse() {
    super();
  }

  private ProjectIfcListRestResponse(final List<ProjectIfcEdo> projectIfcList) {
    super();
    this.projectIfcList = projectIfcList;
  }

  public static ProjectIfcListRestResponse createError(final HttpStatus status, final Exception ex) {
    return (ProjectIfcListRestResponse) new FutureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static ProjectIfcListRestResponse createData(final List<ProjectIfcEdo> projectIfcList) {
    return new ProjectIfcListRestResponse(projectIfcList);
  }

  public List<ProjectIfcEdo> getProjectIfcList() {
    return projectIfcList;
  }

  public void setProjectIfcList(final List<ProjectIfcEdo> projectIfcList) {
    this.projectIfcList = projectIfcList;
  }

  public void addProjectIfc(final ProjectIfcEdo projectIfc) {
    this.projectIfcList.add(projectIfc);
  }

}
