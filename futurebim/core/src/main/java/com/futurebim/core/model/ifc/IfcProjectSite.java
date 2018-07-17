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

import com.futurebim.common.model.edo.ifc.IfcProjectSiteEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_project_site database table.
 *
 */
@Entity
@Table(name = "ifc_project_site")
public class IfcProjectSite extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "composition_type")
  private String compositionType;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "ref_elevation")
  private String refElevation;

  @Column(name = "ref_latitude")
  private String refLatitude;

  @Column(name = "ref_longitude")
  private String refLongitude;

  @Column(name = "site_name")
  private String siteName;

  @Column(name = "project_id")
  private String projectId;

  private short status = 1;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuilding
  @OneToMany(mappedBy = "ifcProjectSite", cascade = CascadeType.ALL)
  private List<IfcBuilding> ifcBuildings = new ArrayList<>();

  // bi-directional many-to-one association to IfcProject
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id", insertable = false, updatable = false)
  private IfcProject ifcProject;

  public IfcProjectSite() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getCompositionType() {
    return this.compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getObjectPlacement() {
    return this.objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getObjectType() {
    return this.objectType;
  }

  public void setObjectType(final String objectType) {
    this.objectType = objectType;
  }

  public String getRefElevation() {
    return this.refElevation;
  }

  public void setRefElevation(final String refElevation) {
    this.refElevation = refElevation;
  }

  public String getRefLatitude() {
    return this.refLatitude;
  }

  public void setRefLatitude(final String refLatitude) {
    this.refLatitude = refLatitude;
  }

  public String getRefLongitude() {
    return this.refLongitude;
  }

  public void setRefLongitude(final String refLongitude) {
    this.refLongitude = refLongitude;
  }

  public String getSiteName() {
    return this.siteName;
  }

  public void setSiteName(final String siteName) {
    this.siteName = siteName;
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

  public List<IfcBuilding> getIfcBuildings() {
    return this.ifcBuildings;
  }

  public void setIfcBuildings(final List<IfcBuilding> ifcBuildings) {
    this.ifcBuildings = ifcBuildings;
  }

  public IfcBuilding addIfcBuilding(final IfcBuilding ifcBuilding) {
    getIfcBuildings().add(ifcBuilding);
    ifcBuilding.setIfcProjectSite(this);

    return ifcBuilding;
  }

  public IfcBuilding removeIfcBuilding(final IfcBuilding ifcBuilding) {
    getIfcBuildings().remove(ifcBuilding);
    ifcBuilding.setIfcProjectSite(null);

    return ifcBuilding;
  }

  public IfcProject getIfcProject() {
    return this.ifcProject;
  }

  public void setIfcProject(final IfcProject ifcProject) {
    this.ifcProject = ifcProject;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(final String projectId) {
    this.projectId = projectId;
  }

  public IfcProjectSiteEdo toEdo() {
    final IfcProjectSiteEdo edo = new IfcProjectSiteEdo();
    edo.setId(id);
    edo.setCompositionType(compositionType);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setRefElevation(refElevation);
    edo.setRefLatitude(refLatitude);
    edo.setRefLongitude(refLongitude);
    edo.setSiteName(siteName);

    for (final IfcBuilding item : ifcBuildings) {
      edo.addBuilding(item.toEdo());
    }

    return edo;
  }

}
