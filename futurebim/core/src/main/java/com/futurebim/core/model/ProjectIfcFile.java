package com.futurebim.core.model;

import java.time.LocalDateTime;

import com.futurebim.common.model.enums.EStatus;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_ifc_files database table.
 *
 */
public class ProjectIfcFile extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private int id;

  private LocalDateTime created;

  private String fileName;

  private String filePath;

  private EStatus status;

  private LocalDateTime updated;

  private Long projectid;

  public ProjectIfcFile() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
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

  public Long getProject() {
    return this.projectid;
  }

  public void setProject(final Long projectid) {
    this.projectid = projectid;
  }

}
