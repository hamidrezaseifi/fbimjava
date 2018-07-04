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

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_space_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_presentationlayers")
public class IfcBuildingStoreySpacePresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "space_id")
  private String spaceId;

  // bi-directional many-to-one association to IfcBuildingStoreySpace
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "space_id", updatable = false, insertable = false)
  private IfcBuildingStoreySpace ifcBuildingStoreySpace;

  public IfcBuildingStoreySpacePresentationlayer() {
  }

  public IfcBuildingStoreySpacePresentationlayer(final String spaceId, final String presentationlayerId) {
    this.spaceId = spaceId;
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

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getSpaceId() {
    return spaceId;
  }

  public void setSpaceId(final String spaceId) {
    this.spaceId = spaceId;
  }

  public IfcBuildingStoreySpace getIfcBuildingStoreySpace() {
    return this.ifcBuildingStoreySpace;
  }

  public void setIfcBuildingStoreySpace(final IfcBuildingStoreySpace ifcBuildingStoreySpace) {
    this.ifcBuildingStoreySpace = ifcBuildingStoreySpace;
  }

}
