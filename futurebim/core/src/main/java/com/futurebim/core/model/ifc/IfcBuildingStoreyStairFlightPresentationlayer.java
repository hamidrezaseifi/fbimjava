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
 * The persistent class for the ifc_building_storey_stair_flight_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_flight_presentationlayers")
public class IfcBuildingStoreyStairFlightPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlight
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "flight_id")
  private IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight;

  public IfcBuildingStoreyStairFlightPresentationlayer() {
  }

  public IfcBuildingStoreyStairFlightPresentationlayer(final String presentationlayerId) {

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

  public IfcBuildingStoreyStairFlight getIfcBuildingStoreyStairFlight() {
    return this.ifcBuildingStoreyStairFlight;
  }

  public void setIfcBuildingStoreyStairFlight(final IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
    this.ifcBuildingStoreyStairFlight = ifcBuildingStoreyStairFlight;
  }

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public IfcPresentationLayerAssignmentSetEdo toEdo() {

    final IfcPresentationLayerAssignmentSetEdo edo = new IfcPresentationLayerAssignmentSetEdo();
    edo.setHref(presentationlayerId);

    return edo;
  }
}
