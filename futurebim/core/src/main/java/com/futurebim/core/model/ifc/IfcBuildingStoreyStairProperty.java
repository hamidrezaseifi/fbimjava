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

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_stair_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_properties")
public class IfcBuildingStoreyStairProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "stair_id")
  private String stairId;

  // bi-directional many-to-one association to IfcBuildingStoreyStair
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stair_id", updatable = false, insertable = false)
  private IfcBuildingStoreyStair ifcBuildingStoreyStair;

  public IfcBuildingStoreyStairProperty() {
  }

  public IfcBuildingStoreyStairProperty(final String stairId, final String propertyId) {
    this.stairId = stairId;
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

  public String getStairId() {
    return stairId;
  }

  public void setStairId(final String stairId) {
    this.stairId = stairId;
  }

  public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
    return this.ifcBuildingStoreyStair;
  }

  public void setIfcBuildingStoreyStair(final IfcBuildingStoreyStair ifcBuildingStoreyStair) {
    this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
  }

}
