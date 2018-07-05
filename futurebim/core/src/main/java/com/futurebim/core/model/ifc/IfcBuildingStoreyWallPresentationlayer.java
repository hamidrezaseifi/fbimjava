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
 * The persistent class for the ifc_building_storey_wall_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wall_presentationlayer")
public class IfcBuildingStoreyWallPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "wall_id")
  private String wallId;

  // bi-directional many-to-one association to IfcBuildingStoreyWall
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id", insertable = false, updatable = false)
  private IfcBuildingStoreyWall ifcBuildingStoreyWall;

  public IfcBuildingStoreyWallPresentationlayer() {
  }

  public IfcBuildingStoreyWallPresentationlayer(final String wallId, final String presentationlayerId) {
    this.wallId = wallId;
    this.presentationlayerId = presentationlayerId;
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

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuildingStoreyWall getIfcBuildingStoreyWall() {
    return this.ifcBuildingStoreyWall;
  }

  public void setIfcBuildingStoreyWall(final IfcBuildingStoreyWall ifcBuildingStoreyWall) {
    this.ifcBuildingStoreyWall = ifcBuildingStoreyWall;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getWallId() {
    return wallId;
  }

  public void setWallId(final String wallId) {
    this.wallId = wallId;
  }

}
