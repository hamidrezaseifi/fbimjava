package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building database table.
 *
 */
@Entity
@Table(name = "ifc_building")
public class IfcBuilding extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name = "building_name")
  private String buildingName;

  @Column(name = "composition_type")
  private String compositionType;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  private short status = 1;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcProjectSite
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "site_id")
  private IfcProjectSite ifcProjectSite;

  // bi-directional many-to-one association to IfcBuildingProperty
  @OneToMany(mappedBy = "ifcBuilding")
  private List<IfcBuildingProperty> ifcBuildingProperties;

  // bi-directional many-to-one association to IfcBuildingStorey
  @OneToMany(mappedBy = "ifcBuilding")
  private List<IfcBuildingStorey> ifcBuildingStoreys;

  public IfcBuilding() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getBuildingName() {
    return this.buildingName;
  }

  public void setBuildingName(final String buildingName) {
    this.buildingName = buildingName;
  }

  public String getCompositionType() {
    return this.compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getObjectPlacement() {
    return this.objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public Timestamp getUpdated() {
    return this.updated;
  }

  public void setUpdated(final Timestamp updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public IfcProjectSite getIfcProjectSite() {
    return this.ifcProjectSite;
  }

  public void setIfcProjectSite(final IfcProjectSite ifcProjectSite) {
    this.ifcProjectSite = ifcProjectSite;
  }

  public List<IfcBuildingProperty> getIfcBuildingProperties() {
    return this.ifcBuildingProperties;
  }

  public void setIfcBuildingProperties(final List<IfcBuildingProperty> ifcBuildingProperties) {
    this.ifcBuildingProperties = ifcBuildingProperties;
  }

  public IfcBuildingProperty addIfcBuildingProperty(final IfcBuildingProperty ifcBuildingProperty) {
    getIfcBuildingProperties().add(ifcBuildingProperty);
    ifcBuildingProperty.setIfcBuilding(this);

    return ifcBuildingProperty;
  }

  public IfcBuildingProperty removeIfcBuildingProperty(final IfcBuildingProperty ifcBuildingProperty) {
    getIfcBuildingProperties().remove(ifcBuildingProperty);
    ifcBuildingProperty.setIfcBuilding(null);

    return ifcBuildingProperty;
  }

  public List<IfcBuildingStorey> getIfcBuildingStoreys() {
    return this.ifcBuildingStoreys;
  }

  public void setIfcBuildingStoreys(final List<IfcBuildingStorey> ifcBuildingStoreys) {
    this.ifcBuildingStoreys = ifcBuildingStoreys;
  }

  public IfcBuildingStorey addIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    getIfcBuildingStoreys().add(ifcBuildingStorey);
    ifcBuildingStorey.setIfcBuilding(this);

    return ifcBuildingStorey;
  }

  public IfcBuildingStorey removeIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    getIfcBuildingStoreys().remove(ifcBuildingStorey);
    ifcBuildingStorey.setIfcBuilding(null);

    return ifcBuildingStorey;
  }

}
