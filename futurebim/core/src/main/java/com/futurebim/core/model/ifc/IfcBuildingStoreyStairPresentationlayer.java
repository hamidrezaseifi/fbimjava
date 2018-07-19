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

import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_stair_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_presentationlayer")
public class IfcBuildingStoreyStairPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyStair
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stair_id")
  private IfcBuildingStoreyStair ifcBuildingStoreyStair;

  public IfcBuildingStoreyStairPresentationlayer() {
  }

  public IfcBuildingStoreyStairPresentationlayer(final String presentationlayerId) {
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

  public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
    return this.ifcBuildingStoreyStair;
  }

  public void setIfcBuildingStoreyStair(final IfcBuildingStoreyStair ifcBuildingStoreyStair) {
    this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
