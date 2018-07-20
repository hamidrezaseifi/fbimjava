package com.futurebim.gui.model.futurebim;

import java.time.LocalDateTime;

import com.futurebim.common.model.edo.ifc.ProjectIfcProxyEdo;

/**
 * The persistent class for the project_ifc database table.
 *
 */
public class GuiProjectIfcProxy {

  private Long id;

  private String filename;

  private String comments;

  private LocalDateTime created;

  private String ifcName;

  private Long projectId;

  private short status = 1;

  private LocalDateTime updated;

  private int version = 1;

  public GuiProjectIfcProxy() {

  }

  public GuiProjectIfcProxy(final ProjectIfcProxyEdo edo) {
    this.setComments(edo.getComments());
    this.setCreated(edo.getCreated());
    this.setFilename(edo.getFilename());
    this.setId(edo.getId());
    this.setIfcName(edo.getIfcName());
    this.setProjectId(edo.getProjectId());
    this.setStatus(edo.getStatus());
    this.setUpdated(edo.getUpdated());
    this.setVersion(edo.getVersion());
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(final String filename) {
    this.filename = filename;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getIfcName() {
    return ifcName;
  }

  public void setIfcName(final String ifcName) {
    this.ifcName = ifcName;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(final Long projectId) {
    this.projectId = projectId;
  }

  public short getStatus() {
    return status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

}
