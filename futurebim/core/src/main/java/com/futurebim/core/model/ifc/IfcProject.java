package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_project database table.
 *
 */
@Entity
@Table(name = "ifc_project")
public class IfcProject extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private LocalDateTime created;

  private String phase;

  @Column(name = "project_long_name")
  private String projectLongName;

  @Column(name = "project_name")
  private String projectName;

  private short status = 1;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcProjectSite
  @OneToMany(mappedBy = "ifcProject", cascade = CascadeType.ALL)
  private List<IfcProjectSite> ifcProjectSites = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcProject() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getPhase() {
    return this.phase;
  }

  public void setPhase(final String phase) {
    this.phase = phase;
  }

  public String getProjectLongName() {
    return this.projectLongName;
  }

  public void setProjectLongName(final String projectLongName) {
    this.projectLongName = projectLongName;
  }

  public String getProjectName() {
    return this.projectName;
  }

  public void setProjectName(final String projectName) {
    this.projectName = projectName;
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

  public List<IfcProjectSite> getIfcProjectSites() {
    return this.ifcProjectSites;
  }

  public void setIfcProjectSites(final List<IfcProjectSite> ifcProjectSites) {
    this.ifcProjectSites = ifcProjectSites;
  }

  public void addIfcProjectSites(final IfcProjectSite ifcProjectSite) {
    this.ifcProjectSites.add(ifcProjectSite);
  }

  public IfcProjectSite addIfcProjectSite(final IfcProjectSite ifcProjectSite) {
    getIfcProjectSites().add(ifcProjectSite);
    ifcProjectSite.setIfcProject(this);

    return ifcProjectSite;
  }

  public IfcProjectSite removeIfcProjectSite(final IfcProjectSite ifcProjectSite) {
    getIfcProjectSites().remove(ifcProjectSite);
    ifcProjectSite.setIfcProject(null);

    return ifcProjectSite;
  }

  public ProjectIfc getProjectIfc() {
    return projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }
}
