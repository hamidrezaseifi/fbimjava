package com.futurebim.core.model.ifc;

import java.io.Serializable;
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

/**
 * The persistent class for the ifc_building_storey_slab_opening_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_opening_properties")
public class IfcBuildingStoreySlabOpeningProperty implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  @Column(name = "property_id")
  private String propertyId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySlabOpening
  @ManyToOne
  @JoinColumn(name = "opening_id")
  private IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening;

  public IfcBuildingStoreySlabOpeningProperty() {
  }

  public IfcBuildingStoreySlabOpeningProperty(final String propertyId) {

    this.propertyId = propertyId;
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

  public IfcBuildingStoreySlabOpening getIfcBuildingStoreySlabOpening() {
    return this.ifcBuildingStoreySlabOpening;
  }

  public void setIfcBuildingStoreySlabOpening(final IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
    this.ifcBuildingStoreySlabOpening = ifcBuildingStoreySlabOpening;
  }

  public IfcPropertySetEdo toEdo() {

    final IfcPropertySetEdo edo = new IfcPropertySetEdo();
    edo.setHref(propertyId);

    return edo;
  }
}
