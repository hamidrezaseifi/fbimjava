package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.ProjectIfcProxyEdo;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@Entity
@Table(name = "project_ifc")
public class ProjectIfcProxy extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "filename")
  private String filename;

  private String comments;

  private LocalDateTime created;

  @Column(name = "ifc_name", unique = true, nullable = false)
  private String ifcName;

  @Column(name = "project_id")
  private Long projectId;

  private short status = 1;

  private LocalDateTime updated;

  private int version = 1;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "project_id", insertable = false, updatable = false)
  private Project project;

  public ProjectIfcProxy() {
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(final String filename) {
    this.filename = filename;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getIfcName() {
    return this.ifcName;
  }

  public void setIfcName(final String ifcName) {
    this.ifcName = ifcName;
  }

  public Long getProjectId() {
    return this.projectId;
  }

  public void setProjectId(final Long projectId) {
    this.projectId = projectId;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public ProjectIfcProxyEdo toEdo() {

    final ProjectIfcProxyEdo edo = new ProjectIfcProxyEdo();

    edo.setComments(comments);
    edo.setCreated(created);
    edo.setFilename(filename);
    edo.setId(id);
    edo.setIfcName(ifcName);
    edo.setProjectId(projectId);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);

    return edo;
  }

  public static List<ProjectIfcProxyEdo> toEdoList(final List<ProjectIfcProxy> list) {

    final List<ProjectIfcProxyEdo> edoList = new ArrayList<>();
    for (final ProjectIfcProxy ifc : list) {
      edoList.add(ifc.toEdo());
    }
    return edoList;
  }
}
