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
 * The persistent class for the ifc_building_storey_stair_railing_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_railing_properties")
public class IfcBuildingStoreyStairRailingProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "railing_id")
  private String railingId;

  // bi-directional many-to-one association to IfcBuildingStoreyStairRailing
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "railing_id", updatable = false, insertable = false)
  private IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing;

  public IfcBuildingStoreyStairRailingProperty() {
  }

  public IfcBuildingStoreyStairRailingProperty(final String railingId, final String propertyId) {
    this.railingId = railingId;
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

  public String getRailingId() {
    return railingId;
  }

  public void setRailingId(final String railingId) {
    this.railingId = railingId;
  }

  public IfcBuildingStoreyStairRailing getIfcBuildingStoreyStairRailing() {
    return this.ifcBuildingStoreyStairRailing;
  }

  public void setIfcBuildingStoreyStairRailing(final IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
    this.ifcBuildingStoreyStairRailing = ifcBuildingStoreyStairRailing;
  }

  public IfcPropertySetEdo toEdo() {

    final IfcPropertySetEdo edo = new IfcPropertySetEdo();
    edo.setHref(propertyId);

    return edo;
  }
}
