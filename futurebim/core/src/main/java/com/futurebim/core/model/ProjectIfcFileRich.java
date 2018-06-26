package com.futurebim.core.model;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.futurebim.common.model.enums.EStatus;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_ifc_files database table.
 *
 */
public class ProjectIfcFileRich extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private Long id;

  private LocalDateTime created;

  private String fileName;

  private String filePath;

  private EStatus status;

  private LocalDateTime updated;

  private Long projectid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectid", insertable = false, updatable = false)
  private Project project;

  public ProjectIfcFileRich() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public Long getProjectid() {
    return this.projectid;
  }

  public void setProjectid(final Long projectid) {
    this.projectid = projectid;
  }

  public Project getProject() {
    return this.project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

}
