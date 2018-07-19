package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.futurebim.common.model.edo.ifc.IfcWallEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_wall database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wall")
public class IfcBuildingStoreyWall extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  @Column(name = "wall_name")
  private String wallName;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyWallOpening
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWall", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallOpening> ifcBuildingStoreyWallOpenings = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyWallPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWall", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyWallProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWall", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties = new ArrayList<>();

  public IfcBuildingStoreyWall() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(final String guid) {
    this.guid = guid;
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

  public String getWallName() {
    return this.wallName;
  }

  public void setWallName(final String wallName) {
    this.wallName = wallName;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return this.ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyWallOpening> getIfcBuildingStoreyWallOpenings() {
    return this.ifcBuildingStoreyWallOpenings;
  }

  public void setIfcBuildingStoreyWallOpenings(final List<IfcBuildingStoreyWallOpening> ifcBuildingStoreyWallOpenings) {
    this.ifcBuildingStoreyWallOpenings = ifcBuildingStoreyWallOpenings;
  }

  public IfcBuildingStoreyWallOpening addIfcBuildingStoreyWallOpening(final IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
    getIfcBuildingStoreyWallOpenings().add(ifcBuildingStoreyWallOpening);
    ifcBuildingStoreyWallOpening.setIfcBuildingStoreyWall(this);

    return ifcBuildingStoreyWallOpening;
  }

  public IfcBuildingStoreyWallOpening removeIfcBuildingStoreyWallOpening(final IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
    getIfcBuildingStoreyWallOpenings().remove(ifcBuildingStoreyWallOpening);
    ifcBuildingStoreyWallOpening.setIfcBuildingStoreyWall(null);

    return ifcBuildingStoreyWallOpening;
  }

  public List<IfcBuildingStoreyWallPresentationlayer> getIfcBuildingStoreyWallPresentationlayers() {
    return this.ifcBuildingStoreyWallPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallPresentationlayers(final List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers) {
    this.ifcBuildingStoreyWallPresentationlayers = ifcBuildingStoreyWallPresentationlayers;
  }

  public IfcBuildingStoreyWallPresentationlayer
         addIfcBuildingStoreyWallPresentationlayer(final IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
    getIfcBuildingStoreyWallPresentationlayers().add(ifcBuildingStoreyWallPresentationlayer);
    ifcBuildingStoreyWallPresentationlayer.setIfcBuildingStoreyWall(this);

    return ifcBuildingStoreyWallPresentationlayer;
  }

  public IfcBuildingStoreyWallPresentationlayer
         removeIfcBuildingStoreyWallPresentationlayer(final IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
    getIfcBuildingStoreyWallPresentationlayers().remove(ifcBuildingStoreyWallPresentationlayer);
    ifcBuildingStoreyWallPresentationlayer.setIfcBuildingStoreyWall(null);

    return ifcBuildingStoreyWallPresentationlayer;
  }

  public List<IfcBuildingStoreyWallProperty> getIfcBuildingStoreyWallProperties() {
    return this.ifcBuildingStoreyWallProperties;
  }

  public void setIfcBuildingStoreyWallProperties(final List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties) {
    this.ifcBuildingStoreyWallProperties = ifcBuildingStoreyWallProperties;
  }

  public IfcBuildingStoreyWallProperty addIfcBuildingStoreyWallProperty(final IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
    getIfcBuildingStoreyWallProperties().add(ifcBuildingStoreyWallProperty);
    ifcBuildingStoreyWallProperty.setIfcBuildingStoreyWall(this);

    return ifcBuildingStoreyWallProperty;
  }

  public IfcBuildingStoreyWallProperty
         removeIfcBuildingStoreyWallProperty(final IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
    getIfcBuildingStoreyWallProperties().remove(ifcBuildingStoreyWallProperty);
    ifcBuildingStoreyWallProperty.setIfcBuildingStoreyWall(null);

    return ifcBuildingStoreyWallProperty;
  }

  public IfcWallEdo toEdo() {

    final IfcWallEdo edo = new IfcWallEdo();
    edo.setId(guid);
    edo.setName(wallName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyWallOpening item : ifcBuildingStoreyWallOpenings) {
      edo.addOpeningElement(item.toEdo());
    }

    for (final IfcBuildingStoreyWallProperty item : ifcBuildingStoreyWallProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreyWallPresentationlayer item : ifcBuildingStoreyWallPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    return edo;
  }
}
