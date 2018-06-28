package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_stair_flight database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_flight")
public class IfcBuildingStoreyStairFlight extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "flight_name")
  private String flightName;

  @Column(name = "number_of_riser")
  private String numberOfRiser;

  @Column(name = "number_of_treads")
  private String numberOfTreads;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "riser_height")
  private String riserHeight;

  private short status;

  private String tag;

  @Column(name = "treads_height")
  private String treadsHeight;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stair_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlightPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyStairFlight")
  private List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlightProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyStairFlight")
  private List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties;

  public IfcBuildingStoreyStairFlight() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getFlightName() {
    return this.flightName;
  }

  public void setFlightName(final String flightName) {
    this.flightName = flightName;
  }

  public String getNumberOfRiser() {
    return this.numberOfRiser;
  }

  public void setNumberOfRiser(final String numberOfRiser) {
    this.numberOfRiser = numberOfRiser;
  }

  public String getNumberOfTreads() {
    return this.numberOfTreads;
  }

  public void setNumberOfTreads(final String numberOfTreads) {
    this.numberOfTreads = numberOfTreads;
  }

  public String getObjectPlacement() {
    return this.objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getObjectType() {
    return this.objectType;
  }

  public void setObjectType(final String objectType) {
    this.objectType = objectType;
  }

  public String getRiserHeight() {
    return this.riserHeight;
  }

  public void setRiserHeight(final String riserHeight) {
    this.riserHeight = riserHeight;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public String getTag() {
    return this.tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
  }

  public String getTreadsHeight() {
    return this.treadsHeight;
  }

  public void setTreadsHeight(final String treadsHeight) {
    this.treadsHeight = treadsHeight;
  }

  public Timestamp getUpdated() {
    return this.updated;
  }

  public void setUpdated(final Timestamp updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return this.ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyStairFlightPresentationlayer> getIfcBuildingStoreyStairFlightPresentationlayers() {
    return this.ifcBuildingStoreyStairFlightPresentationlayers;
  }

  public void
         setIfcBuildingStoreyStairFlightPresentationlayers(final List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers) {
    this.ifcBuildingStoreyStairFlightPresentationlayers = ifcBuildingStoreyStairFlightPresentationlayers;
  }

  public IfcBuildingStoreyStairFlightPresentationlayer
         addIfcBuildingStoreyStairFlightPresentationlayer(final IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
    getIfcBuildingStoreyStairFlightPresentationlayers().add(ifcBuildingStoreyStairFlightPresentationlayer);
    ifcBuildingStoreyStairFlightPresentationlayer.setIfcBuildingStoreyStairFlight(this);

    return ifcBuildingStoreyStairFlightPresentationlayer;
  }

  public IfcBuildingStoreyStairFlightPresentationlayer
         removeIfcBuildingStoreyStairFlightPresentationlayer(final IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
    getIfcBuildingStoreyStairFlightPresentationlayers().remove(ifcBuildingStoreyStairFlightPresentationlayer);
    ifcBuildingStoreyStairFlightPresentationlayer.setIfcBuildingStoreyStairFlight(null);

    return ifcBuildingStoreyStairFlightPresentationlayer;
  }

  public List<IfcBuildingStoreyStairFlightProperty> getIfcBuildingStoreyStairFlightProperties() {
    return this.ifcBuildingStoreyStairFlightProperties;
  }

  public void
         setIfcBuildingStoreyStairFlightProperties(final List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties) {
    this.ifcBuildingStoreyStairFlightProperties = ifcBuildingStoreyStairFlightProperties;
  }

  public IfcBuildingStoreyStairFlightProperty
         addIfcBuildingStoreyStairFlightProperty(final IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
    getIfcBuildingStoreyStairFlightProperties().add(ifcBuildingStoreyStairFlightProperty);
    ifcBuildingStoreyStairFlightProperty.setIfcBuildingStoreyStairFlight(this);

    return ifcBuildingStoreyStairFlightProperty;
  }

  public IfcBuildingStoreyStairFlightProperty
         removeIfcBuildingStoreyStairFlightProperty(final IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
    getIfcBuildingStoreyStairFlightProperties().remove(ifcBuildingStoreyStairFlightProperty);
    ifcBuildingStoreyStairFlightProperty.setIfcBuildingStoreyStairFlight(null);

    return ifcBuildingStoreyStairFlightProperty;
  }

}
