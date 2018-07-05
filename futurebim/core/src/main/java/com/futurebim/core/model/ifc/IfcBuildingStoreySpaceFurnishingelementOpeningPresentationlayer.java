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
 * The persistent class for the ifc_building_storey_space_felement_opening_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_felement_opening_presentationlayer")
public class IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  @Column(name = "opening_id")
  private String openingId;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpening
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "opening_id", insertable = false, updatable = false)
  private IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening;

  public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer() {
  }

  public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer(final String openingId, final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
    this.openingId = openingId;
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

  public IfcBuildingStoreySpaceFurnishingelementOpening getIfcBuildingStoreySpaceFurnishingelementOpening() {
    return this.ifcBuildingStoreySpaceFurnishingelementOpening;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementOpening(final IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening) {
    this.ifcBuildingStoreySpaceFurnishingelementOpening = ifcBuildingStoreySpaceFurnishingelementOpening;
  }

  public String getOpeningId() {
    return openingId;
  }

  public void setOpeningId(final String openingId) {
    this.openingId = openingId;
  }

}
