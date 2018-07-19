package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;

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
 * The persistent class for the ifc_building_storey_roof_slab_opening_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab_opening_properties")
public class IfcBuildingStoreyRoofSlabOpeningProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private LocalDateTime created;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "opening_id")
  private Long openingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpening
  @ManyToOne
  @JoinColumn(name = "opening_id", updatable = false, insertable = false)
  private IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening;

  public IfcBuildingStoreyRoofSlabOpeningProperty() {
  }

  public IfcBuildingStoreyRoofSlabOpeningProperty(final Long openingId, final String propertyId) {
    this.openingId = openingId;
    this.propertyId = propertyId;
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

  public IfcBuildingStoreyRoofSlabOpening getIfcBuildingStoreyRoofSlabOpening() {
    return this.ifcBuildingStoreyRoofSlabOpening;
  }

  public void setIfcBuildingStoreyRoofSlabOpening(final IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
    this.ifcBuildingStoreyRoofSlabOpening = ifcBuildingStoreyRoofSlabOpening;
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
