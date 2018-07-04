package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_wall_opening_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wall_opening_presentationlayer")
public class IfcBuildingStoreyWallOpeningPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "opening_id")
  private String openingId;

  // bi-directional many-to-one association to IfcBuildingStoreyWallOpening
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "opening_id", insertable = false, updatable = false)
  private IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening;

  public IfcBuildingStoreyWallOpeningPresentationlayer() {
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer(final String openingId, final String presentationlayerId) {
    this.openingId = openingId;
    this.presentationlayerId = presentationlayerId;
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
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

  public IfcBuildingStoreyWallOpening getIfcBuildingStoreyWallOpening() {
    return this.ifcBuildingStoreyWallOpening;
  }

  public void setIfcBuildingStoreyWallOpening(final IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
    this.ifcBuildingStoreyWallOpening = ifcBuildingStoreyWallOpening;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getWallId() {
    return openingId;
  }

  public void setWallId(final String openingId) {
    this.openingId = openingId;
  }

}
