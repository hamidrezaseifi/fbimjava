package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_slab_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_properties")
public class IfcBuildingStoreySlabProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "property_id")
  private String propertyId;

  // bi-directional many-to-one association to IfcBuildingStoreySlab
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "slab_id")
  private IfcBuildingStoreySlab ifcBuildingStoreySlab;

  public IfcBuildingStoreySlabProperty() {
  }

  public IfcBuildingStoreySlabProperty(final String propertyId) {
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

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(final String propertyId) {
    this.propertyId = propertyId;
  }

  public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
    return this.ifcBuildingStoreySlab;
  }

  public void setIfcBuildingStoreySlab(final IfcBuildingStoreySlab ifcBuildingStoreySlab) {
    this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
  }

  public IfcPropertySetEdo toEdo() {

    final IfcPropertySetEdo edo = new IfcPropertySetEdo();
    edo.setHref(propertyId);

    return edo;
  }
}
