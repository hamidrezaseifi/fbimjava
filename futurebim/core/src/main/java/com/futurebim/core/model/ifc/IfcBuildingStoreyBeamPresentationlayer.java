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
 * The persistent class for the ifc_building_storey_beam_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_beam_presentationlayers")
public class IfcBuildingStoreyBeamPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "beam_id")
  private String beamId;

  // bi-directional many-to-one association to IfcBuildingStoreyBeam
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beam_id", updatable = false, insertable = false)
  private IfcBuildingStoreyBeam ifcBuildingStoreyBeam;

  public IfcBuildingStoreyBeamPresentationlayer() {
  }

  public IfcBuildingStoreyBeamPresentationlayer(final String beamId, final String presentationlayerId) {
    this.beamId = beamId;
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

  public IfcBuildingStoreyBeam getIfcBuildingStoreyBeam() {
    return this.ifcBuildingStoreyBeam;
  }

  public void setIfcBuildingStoreyBeam(final IfcBuildingStoreyBeam ifcBuildingStoreyBeam) {
    this.ifcBuildingStoreyBeam = ifcBuildingStoreyBeam;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getBeamId() {
    return beamId;
  }

  public void setBeamId(final String beamId) {
    this.beamId = beamId;
  }

}
