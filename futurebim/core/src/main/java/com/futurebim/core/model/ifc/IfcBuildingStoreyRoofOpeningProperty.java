package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_roof_opening_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_opening_properties")
public class IfcBuildingStoreyRoofOpeningProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "opening_id")
  private Long openingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofOpening
  @ManyToOne
  @JoinColumn(name = "opening_id", insertable = false, updatable = false)
  private IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening;

  public IfcBuildingStoreyRoofOpeningProperty() {
  }

  public IfcBuildingStoreyRoofOpeningProperty(final Long openingId, final String propertyId) {
    this.openingId = openingId;
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

  public String getPropertyId() {
    return this.propertyId;
  }

  public void setPropertyId(final String propertyId) {
    this.propertyId = propertyId;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuildingStoreyRoofOpening getIfcBuildingStoreyRoofOpening() {
    return this.ifcBuildingStoreyRoofOpening;
  }

  public void setIfcBuildingStoreyRoofOpening(final IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening) {
    this.ifcBuildingStoreyRoofOpening = ifcBuildingStoreyRoofOpening;
  }

  public Long getOpeningId() {
    return openingId;
  }

  public void setOpeningId(final Long openingId) {
    this.openingId = openingId;
  }

  public IfcPropertySetEdo toEdo() {

    final IfcPropertySetEdo edo = new IfcPropertySetEdo();
    edo.setHref(propertyId);

    return edo;
  }
}
