package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  private String id;

  private Timestamp created;

  private short status = 1;

  // bi-directional many-to-one association to IfcBuildingStoreyWall
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id")
  private IfcBuildingStoreyWall ifcBuildingStoreyWall;

  // bi-directional many-to-one association to IfcPresentationlayer
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "presentationlayer_id")
  private IfcPresentationlayer ifcPresentationlayer;

  public IfcBuildingStoreyWallPresentationlayer() {
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

  public IfcBuildingStoreyWall getIfcBuildingStoreyWall() {
    return this.ifcBuildingStoreyWall;
  }

  public void setIfcBuildingStoreyWall(final IfcBuildingStoreyWall ifcBuildingStoreyWall) {
    this.ifcBuildingStoreyWall = ifcBuildingStoreyWall;
  }

  public IfcPresentationlayer getIfcPresentationlayer() {
    return this.ifcPresentationlayer;
  }

  public void setIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    this.ifcPresentationlayer = ifcPresentationlayer;
  }

}
