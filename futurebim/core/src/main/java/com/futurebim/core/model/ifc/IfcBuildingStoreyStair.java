package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.futurebim.common.model.edo.ifc.IfcStairEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_stair database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair")
public class IfcBuildingStoreyStair extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "ifc_id")
  private Long ifcId;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "shape_type")
  private String shapeType;

  @Column(name = "stair_name")
  private String stairName;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyStairProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyStair", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlight
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyStair", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyStairFlight> ifcBuildingStoreyStairFlights = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyStairMember
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyStair", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyStairMember> ifcBuildingStoreyStairMembers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyStairRailing
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyStair", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyStairRailing> ifcBuildingStoreyStairRailings = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyStairPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyStair", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyStairPresentationlayer> ifcBuildingStoreyStairPresentationlayers;

  public IfcBuildingStoreyStair() {
  }

  public Long getIfcId() {
    return ifcId;
  }

  public void setIfcId(final Long ifcId) {
    this.ifcId = ifcId;
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
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

  public String getShapeType() {
    return this.shapeType;
  }

  public void setShapeType(final String shapeType) {
    this.shapeType = shapeType;
  }

  public String getStairName() {
    return this.stairName;
  }

  public void setStairName(final String stairName) {
    this.stairName = stairName;
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

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
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

  public List<IfcBuildingStoreyStairFlight> getIfcBuildingStoreyStairFlights() {
    return this.ifcBuildingStoreyStairFlights;
  }

  public void setIfcBuildingStoreyStairFlights(final List<IfcBuildingStoreyStairFlight> ifcBuildingStoreyStairFlights) {
    this.ifcBuildingStoreyStairFlights = ifcBuildingStoreyStairFlights;
  }

  public IfcBuildingStoreyStairFlight addIfcBuildingStoreyStairFlight(final IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
    getIfcBuildingStoreyStairFlights().add(ifcBuildingStoreyStairFlight);
    ifcBuildingStoreyStairFlight.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairFlight;
  }

  public IfcBuildingStoreyStairFlight removeIfcBuildingStoreyStairFlight(final IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
    getIfcBuildingStoreyStairFlights().remove(ifcBuildingStoreyStairFlight);
    ifcBuildingStoreyStairFlight.setIfcBuildingStoreyStair(null);

    return ifcBuildingStoreyStairFlight;
  }

  public List<IfcBuildingStoreyStairMember> getIfcBuildingStoreyStairMembers() {
    return this.ifcBuildingStoreyStairMembers;
  }

  public void setIfcBuildingStoreyStairMembers(final List<IfcBuildingStoreyStairMember> ifcBuildingStoreyStairMembers) {
    this.ifcBuildingStoreyStairMembers = ifcBuildingStoreyStairMembers;
  }

  public IfcBuildingStoreyStairMember addIfcBuildingStoreyStairMember(final IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
    getIfcBuildingStoreyStairMembers().add(ifcBuildingStoreyStairMember);
    ifcBuildingStoreyStairMember.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairMember;
  }

  public IfcBuildingStoreyStairMember removeIfcBuildingStoreyStairMember(final IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
    getIfcBuildingStoreyStairMembers().remove(ifcBuildingStoreyStairMember);
    ifcBuildingStoreyStairMember.setIfcBuildingStoreyStair(null);

    return ifcBuildingStoreyStairMember;
  }

  public List<IfcBuildingStoreyStairProperty> getIfcBuildingStoreyStairProperties() {
    return this.ifcBuildingStoreyStairProperties;
  }

  public void setIfcBuildingStoreyStairProperties(final List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties) {
    this.ifcBuildingStoreyStairProperties = ifcBuildingStoreyStairProperties;
  }

  public IfcBuildingStoreyStairProperty
         addIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().add(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairProperty;
  }

  public IfcBuildingStoreyStairProperty
         removeIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().remove(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(null);

    return ifcBuildingStoreyStairProperty;
  }

  public List<IfcBuildingStoreyStairRailing> getIfcBuildingStoreyStairRailings() {
    return this.ifcBuildingStoreyStairRailings;
  }

  public void setIfcBuildingStoreyStairRailings(final List<IfcBuildingStoreyStairRailing> ifcBuildingStoreyStairRailings) {
    this.ifcBuildingStoreyStairRailings = ifcBuildingStoreyStairRailings;
  }

  public IfcBuildingStoreyStairRailing addIfcBuildingStoreyStairRailing(final IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
    getIfcBuildingStoreyStairRailings().add(ifcBuildingStoreyStairRailing);
    ifcBuildingStoreyStairRailing.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairRailing;
  }

  public IfcBuildingStoreyStairRailing
         removeIfcBuildingStoreyStairRailing(final IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
    getIfcBuildingStoreyStairRailings().remove(ifcBuildingStoreyStairRailing);
    ifcBuildingStoreyStairRailing.setIfcBuildingStoreyStair(null);

    return ifcBuildingStoreyStairRailing;
  }

  public List<IfcBuildingStoreyStairPresentationlayer> getIfcBuildingStoreyStairPresentationlayers() {
    return this.ifcBuildingStoreyStairPresentationlayers;
  }

  public void
         setIfcBuildingStoreyStairPresentationlayers(final List<IfcBuildingStoreyStairPresentationlayer> ifcBuildingStoreyStairPresentationlayers) {
    this.ifcBuildingStoreyStairPresentationlayers = ifcBuildingStoreyStairPresentationlayers;
  }

  public IfcBuildingStoreyStairPresentationlayer
         addIfcBuildingStoreyStairPresentationlayer(final IfcBuildingStoreyStairPresentationlayer ifcBuildingStoreyStairPresentationlayer) {
    getIfcBuildingStoreyStairPresentationlayers().add(ifcBuildingStoreyStairPresentationlayer);
    ifcBuildingStoreyStairPresentationlayer.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairPresentationlayer;
  }

  public IfcStairEdo toEdo() {

    final IfcStairEdo edo = new IfcStairEdo();
    edo.setId(id);
    edo.setName(stairName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setShapeType(shapeType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyStairFlight item : ifcBuildingStoreyStairFlights) {
      edo.addStairFlight(item.toEdo());
    }

    for (final IfcBuildingStoreyStairProperty item : ifcBuildingStoreyStairProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreyStairPresentationlayer item : ifcBuildingStoreyStairPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyStairMember item : ifcBuildingStoreyStairMembers) {
      edo.addMember(item.toEdo());
    }

    for (final IfcBuildingStoreyStairRailing item : ifcBuildingStoreyStairRailings) {
      edo.addRailing(item.toEdo());
    }

    return edo;
  }
}
