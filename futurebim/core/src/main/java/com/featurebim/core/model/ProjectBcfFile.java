package com.featurebim.core.model;

import java.time.LocalDateTime;



/**
 * The persistent class for the project_bcf_files database table.
 *
 */
public class ProjectBcfFile {

  

  private Long id;

  private LocalDateTime created;

  private String fileName;

  private String filePath;

  private String objectId;

  private int status;

  private LocalDateTime updated;

  private String viewpoint;

  private Long projectid;

  public ProjectBcfFile() {
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

  public String getObjectId() {
    return this.objectId;
  }

  public void setObjectId(final String objectId) {
    this.objectId = objectId;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public String getViewpoint() {
    return this.viewpoint;
  }

  public void setViewpoint(final String viewpoint) {
    this.viewpoint = viewpoint;
  }

  public Long getProjectid() {
    return this.projectid;
  }

  public void setProjectid(final Long projectid) {
    this.projectid = projectid;
  }

}
