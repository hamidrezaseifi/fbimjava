package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_roof_slab_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab_presentationlayer")
public class IfcBuildingStoreyRoofSlabPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private LocalDateTime created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
  @ManyToOne
  @JoinColumn(name = "slab_id")
  private IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab;

  public IfcBuildingStoreyRoofSlabPresentationlayer() {
  }

  public IfcBuildingStoreyRoofSlabPresentationlayer(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
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

  public IfcBuildingStoreyRoofSlab getIfcBuildingStoreyRoofSlab() {
    return this.ifcBuildingStoreyRoofSlab;
  }

  public void setIfcBuildingStoreyRoofSlab(final IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
    this.ifcBuildingStoreyRoofSlab = ifcBuildingStoreyRoofSlab;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
