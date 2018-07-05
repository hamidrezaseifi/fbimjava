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
 * The persistent class for the ifc_building_storey_door_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_door_presentationlayer")
public class IfcBuildingStoreyDoorPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "door_id")
  private String doorId;

  // bi-directional many-to-one association to IfcBuildingStoreyDoor
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "door_id", updatable = false, insertable = false)
  private IfcBuildingStoreyDoor ifcBuildingStoreyDoor;

  public IfcBuildingStoreyDoorPresentationlayer() {
  }

  public IfcBuildingStoreyDoorPresentationlayer(final String doorId, final String presentationlayerId) {
    this.doorId = doorId;
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

  public IfcBuildingStoreyDoor getIfcBuildingStoreyDoor() {
    return this.ifcBuildingStoreyDoor;
  }

  public void setIfcBuildingStoreyDoor(final IfcBuildingStoreyDoor ifcBuildingStoreyDoor) {
    this.ifcBuildingStoreyDoor = ifcBuildingStoreyDoor;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getDoorId() {
    return doorId;
  }

  public void setDoorId(final String doorId) {
    this.doorId = doorId;
  }

}
