package com.futurebim.core.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the project_ifc_files database table.
 *
 */
public class ProjectIfcFileRich extends ProjectIfcFile {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectid", insertable = false, updatable = false)
  private Project project;

  public ProjectIfcFileRich() {
  }

  public Project getProject() {
    return this.project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

}
