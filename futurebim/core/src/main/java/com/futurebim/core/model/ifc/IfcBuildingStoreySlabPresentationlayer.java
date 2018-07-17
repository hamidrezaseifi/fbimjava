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

import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_slab_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_presentationlayer")
public class IfcBuildingStoreySlabPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "slab_id")
  private String slabId;

  // bi-directional many-to-one association to IfcBuildingStoreySlab
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "slab_id", updatable = false, insertable = false)
  private IfcBuildingStoreySlab ifcBuildingStoreySlab;

  public IfcBuildingStoreySlabPresentationlayer() {
  }

  public IfcBuildingStoreySlabPresentationlayer(final String slabId, final String presentationlayerId) {
    this.slabId = slabId;
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

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
    return this.ifcBuildingStoreySlab;
  }

  public void setIfcBuildingStoreySlab(final IfcBuildingStoreySlab ifcBuildingStoreySlab) {
    this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getSlabId() {
    return slabId;
  }

  public void setSlabId(final String slabId) {
    this.slabId = slabId;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
