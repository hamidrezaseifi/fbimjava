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
 * The persistent class for the ifc_building_storey_roof_opening_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_opening_presentationlayer")
public class IfcBuildingStoreyRoofOpeningPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Timestamp created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "opening_id")
  private String openingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofOpening
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "opening_id", insertable = false, updatable = false)
  private IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening;

  public IfcBuildingStoreyRoofOpeningPresentationlayer() {
  }

  public IfcBuildingStoreyRoofOpeningPresentationlayer(final String openingId, final String presentationlayerId) {
    this.openingId = openingId;
    this.presentationlayerId = presentationlayerId;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getPresentationlayerId() {
    return this.presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
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

  public String getOpeningId() {
    return openingId;
  }

  public void setOpeningId(final String openingId) {
    this.openingId = openingId;
  }
}
