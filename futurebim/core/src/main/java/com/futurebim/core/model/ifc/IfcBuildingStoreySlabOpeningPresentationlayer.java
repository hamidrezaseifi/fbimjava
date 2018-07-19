package com.futurebim.core.model.ifc;

import java.io.Serializable;
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

/**
 * The persistent class for the ifc_building_storey_slab_opening_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_opening_presentationlayer")
public class IfcBuildingStoreySlabOpeningPresentationlayer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySlabOpening
  @ManyToOne
  @JoinColumn(name = "opening_id")
  private IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening;

  public IfcBuildingStoreySlabOpeningPresentationlayer() {
  }

  public IfcBuildingStoreySlabOpeningPresentationlayer(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
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

  public IfcBuildingStoreySlabOpening getIfcBuildingStoreySlabOpening() {
    return this.ifcBuildingStoreySlabOpening;
  }

  public void setIfcBuildingStoreySlabOpening(final IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
    this.ifcBuildingStoreySlabOpening = ifcBuildingStoreySlabOpening;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
