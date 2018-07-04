package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_properties")
public class IfcBuildingProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "building_id")
  private String buildingId;

  @Column(name = "property_id")
  private String propertyId;

  // bi-directional many-to-one association to IfcBuilding
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "building_id", insertable = false, updatable = false)
  private IfcBuilding ifcBuilding;

  public IfcBuildingProperty() {
  }

  public IfcBuildingProperty(final String buildingId, final String propertyId) {
    this.buildingId = buildingId;
    this.propertyId = propertyId;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuilding getIfcBuilding() {
    return this.ifcBuilding;
  }

  public void setIfcBuilding(final IfcBuilding ifcBuilding) {
    this.ifcBuilding = ifcBuilding;
  }

  public String getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(final String buildingId) {
    this.buildingId = buildingId;
  }

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(final String propertyId) {
    this.propertyId = propertyId;
  }

}
