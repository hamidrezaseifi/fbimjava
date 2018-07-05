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
 * The persistent class for the ifc_building_storey_wallstandardcase_opening_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wallstandardcase_opening_properties")
public class IfcBuildingStoreyWallstandardcaseOpeningProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "opening_id")
  private String openingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpening
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "opening_id", insertable = false, updatable = false)
  private IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening;

  public IfcBuildingStoreyWallstandardcaseOpeningProperty() {
  }

  public IfcBuildingStoreyWallstandardcaseOpeningProperty(final String openingId, final String propertyId) {
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

  public IfcBuildingStoreyWallstandardcaseOpening getIfcBuildingStoreyWallstandardcaseOpening() {
    return this.ifcBuildingStoreyWallstandardcaseOpening;
  }

  public void
         setIfcBuildingStoreyWallstandardcaseOpening(final IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening) {
    this.ifcBuildingStoreyWallstandardcaseOpening = ifcBuildingStoreyWallstandardcaseOpening;
  }

  public String getOpeningId() {
    return openingId;
  }

  public void setOpeningId(final String openingId) {
    this.openingId = openingId;
  }

}
