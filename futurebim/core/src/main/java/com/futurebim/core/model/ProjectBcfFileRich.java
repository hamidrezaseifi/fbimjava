package com.futurebim.core.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the project_bcf_files database table.
 *
 */
public class ProjectBcfFileRich extends ProjectBcfFile {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectid", insertable = false, updatable = false)
  private Project project;

  public ProjectBcfFileRich() {
  }

  public Project getProject() {
    return project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

}
