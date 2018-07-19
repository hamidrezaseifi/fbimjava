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

import com.futurebim.common.model.edo.ifc.IfcFurnitureTypeSetEdo;
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
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "furnituretype_id")
  private String furnituretypeId;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "felement_id")
  private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype() {
  }

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype(final String furnituretypeId) {

    this.furnituretypeId = furnituretypeId;
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

  public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
    return this.ifcBuildingStoreySpaceFurnishingelement;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelement(final IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
    this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
  }

  public String getFurnituretypeId() {
    return furnituretypeId;
  }

  public void setFurnituretypeId(final String furnituretypeId) {
    this.furnituretypeId = furnituretypeId;
  }

  public IfcFurnitureTypeSetEdo toEdo() {

    final IfcFurnitureTypeSetEdo edo = new IfcFurnitureTypeSetEdo();
    edo.setHref(this.furnituretypeId);

    return edo;
  }
}
