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
 * The persistent class for the ifc_building_storey_space_furnishingelement_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_furnishingelement_presentationlayers")
public class IfcBuildingStoreySpaceFurnishingelementPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "felement_id")
  private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

  // bi-directional many-to-one association to IfcPresentationlayer
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "presentationlayer_id")
  private IfcPresentationlayer ifcPresentationlayer;

  public IfcBuildingStoreySpaceFurnishingelementPresentationlayer() {
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

  public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
    return this.ifcBuildingStoreySpaceFurnishingelement;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelement(final IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
    this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
  }

  public IfcPresentationlayer getIfcPresentationlayer() {
    return this.ifcPresentationlayer;
  }

  public void setIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    this.ifcPresentationlayer = ifcPresentationlayer;
  }

}
