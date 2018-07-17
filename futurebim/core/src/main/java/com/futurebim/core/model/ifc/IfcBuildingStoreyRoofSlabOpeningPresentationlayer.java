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
 * The persistent class for the ifc_building_storey_roof_slab_opening_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab_opening_presentationlayer")
public class IfcBuildingStoreyRoofSlabOpeningPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private LocalDateTime created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "opening_id")
  private String openingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpening
  @ManyToOne
  @JoinColumn(name = "opening_id", updatable = false, insertable = false)
  private IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening;

  public IfcBuildingStoreyRoofSlabOpeningPresentationlayer() {
  }

  public IfcBuildingStoreyRoofSlabOpeningPresentationlayer(final String openingId, final String presentationlayerId) {
    this.openingId = openingId;
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

  public IfcBuildingStoreyRoofSlabOpening getIfcBuildingStoreyRoofSlabOpening() {
    return this.ifcBuildingStoreyRoofSlabOpening;
  }

  public void setIfcBuildingStoreyRoofSlabOpening(final IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
    this.ifcBuildingStoreyRoofSlabOpening = ifcBuildingStoreyRoofSlabOpening;
  }

  public String getOpeningId() {
    return openingId;
  }

  public void setOpeningId(final String openingId) {
    this.openingId = openingId;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
