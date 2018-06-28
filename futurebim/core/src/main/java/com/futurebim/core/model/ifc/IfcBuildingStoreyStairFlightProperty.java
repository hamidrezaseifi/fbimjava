package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

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
 * The persistent class for the ifc_building_storey_stair_flight_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_flight_properties")
public class IfcBuildingStoreyStairFlightProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlight
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "flight_id")
  private IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight;

  // bi-directional many-to-one association to IfcProperty
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property_id")
  private IfcProperty ifcProperty;

  public IfcBuildingStoreyStairFlightProperty() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
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

  public IfcBuildingStoreyStairFlight getIfcBuildingStoreyStairFlight() {
    return this.ifcBuildingStoreyStairFlight;
  }

  public void setIfcBuildingStoreyStairFlight(final IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
    this.ifcBuildingStoreyStairFlight = ifcBuildingStoreyStairFlight;
  }

  public IfcProperty getIfcProperty() {
    return this.ifcProperty;
  }

  public void setIfcProperty(final IfcProperty ifcProperty) {
    this.ifcProperty = ifcProperty;
  }

}
