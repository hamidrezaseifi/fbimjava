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
 * The persistent class for the ifc_building_storey_wallstandardcase_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wallstandardcase_presentationlayer")
public class IfcBuildingStoreyWallstandardcasePresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "wall_id")
  private Long wallId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcase
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id", insertable = false, updatable = false)
  private IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase;

  public IfcBuildingStoreyWallstandardcasePresentationlayer() {
  }

  public IfcBuildingStoreyWallstandardcasePresentationlayer(final Long wallId, final String presentationlayerId) {
    this.wallId = wallId;
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

  public IfcBuildingStoreyWallstandardcase getIfcBuildingStoreyWallstandardcase() {
    return this.ifcBuildingStoreyWallstandardcase;
  }

  public void setIfcBuildingStoreyWallstandardcase(final IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase) {
    this.ifcBuildingStoreyWallstandardcase = ifcBuildingStoreyWallstandardcase;
  }

  public Long getWallId() {
    return wallId;
  }

  public void setWallId(final Long wallId) {
    this.wallId = wallId;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
