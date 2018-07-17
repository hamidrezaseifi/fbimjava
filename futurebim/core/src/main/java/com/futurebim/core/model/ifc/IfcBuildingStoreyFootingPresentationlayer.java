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
 * The persistent class for the ifc_building_storey_footing_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_footing_presentationlayer")
public class IfcBuildingStoreyFootingPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "footing_id")
  private String footingId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyFooting
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "footing_id", updatable = false, insertable = false)
  private IfcBuildingStoreyFooting ifcBuildingStoreyFooting;

  public IfcBuildingStoreyFootingPresentationlayer() {
  }

  public IfcBuildingStoreyFootingPresentationlayer(final String footingId, final String presentationlayerId) {
    this.footingId = footingId;
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

  public IfcBuildingStoreyFooting getIfcBuildingStoreyFooting() {
    return this.ifcBuildingStoreyFooting;
  }

  public void setIfcBuildingStoreyFooting(final IfcBuildingStoreyFooting ifcBuildingStoreyFooting) {
    this.ifcBuildingStoreyFooting = ifcBuildingStoreyFooting;
  }

  public String getFootingId() {
    return footingId;
  }

  public void setFootingId(final String footingId) {
    this.footingId = footingId;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
