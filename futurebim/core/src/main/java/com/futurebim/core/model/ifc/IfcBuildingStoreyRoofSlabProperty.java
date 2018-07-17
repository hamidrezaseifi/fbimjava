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
 * The persistent class for the ifc_building_storey_roof_slab_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab_properties")
public class IfcBuildingStoreyRoofSlabProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "slab_id")
  private String slabId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
  @ManyToOne
  @JoinColumn(name = "slab_id", updatable = false, insertable = false)
  private IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab;

  public IfcBuildingStoreyRoofSlabProperty() {
  }

  public IfcBuildingStoreyRoofSlabProperty(final String slabId, final String propertyId) {
    this.slabId = slabId;
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

  public IfcBuildingStoreyRoofSlab getIfcBuildingStoreyRoofSlab() {
    return this.ifcBuildingStoreyRoofSlab;
  }

  public void setIfcBuildingStoreyRoofSlab(final IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
    this.ifcBuildingStoreyRoofSlab = ifcBuildingStoreyRoofSlab;
  }

  public String getSlabId() {
    return slabId;
  }

  public void setSlabId(final String slabId) {
    this.slabId = slabId;
  }

  public IfcPropertySetEdo toEdo() {

    final IfcPropertySetEdo edo = new IfcPropertySetEdo();
    edo.setHref(propertyId);

    return edo;
  }
}
