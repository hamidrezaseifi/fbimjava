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
 * The persistent class for the ifc_building_storey_space_furnishingelement_furnituretypes database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_furnishingelement_furnituretypes")
public class IfcBuildingStoreySpaceFurnishingelementFurnituretype extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "felement_id")
  private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

  // bi-directional many-to-one association to IfcFurnituretype
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "furnituretype_id")
  private IfcFurnituretype ifcFurnituretype;

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype() {
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

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
    return this.ifcBuildingStoreySpaceFurnishingelement;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelement(final IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
    this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
  }

  public IfcFurnituretype getIfcFurnituretype() {
    return this.ifcFurnituretype;
  }

  public void setIfcFurnituretype(final IfcFurnituretype ifcFurnituretype) {
    this.ifcFurnituretype = ifcFurnituretype;
  }

}
