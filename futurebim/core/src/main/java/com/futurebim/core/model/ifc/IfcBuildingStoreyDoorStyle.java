package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

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
 * The persistent class for the ifc_building_storey_door_style database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_door_style")
public class IfcBuildingStoreyDoorStyle extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyDoor
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "door_id")
  private IfcBuildingStoreyDoor ifcBuildingStoreyDoor;

  // bi-directional many-to-one association to IfcDoorstyle
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "style_id")
  private IfcDoorstyle ifcDoorstyle;

  public IfcBuildingStoreyDoorStyle() {
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

  public IfcDoorstyle getIfcDoorstyle() {
    return this.ifcDoorstyle;
  }

  public void setIfcDoorstyle(final IfcDoorstyle ifcDoorstyle) {
    this.ifcDoorstyle = ifcDoorstyle;
  }

}
