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

import com.futurebim.common.model.edo.ifc.IfcOpeningElementEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_wall_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wall_opening")
public class IfcBuildingStoreyWallOpening extends SerializableModelBase {

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

  @Column(name = "opening_name")
  private String openingName;

  // bi-directional many-to-one association to IfcBuildingStoreyWall
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id")
  private IfcBuildingStoreyWall ifcBuildingStoreyWall;

  // bi-directional many-to-one association to IfcBuildingStoreyWallOpeningPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallOpeningProperty> ifcBuildingStoreyWallOpeningProperties = new ArrayList<>();

  public IfcBuildingStoreyWallOpening() {
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

  public String getOpeningName() {
    return openingName;
  }

  public void setOpeningName(final String openingName) {
    this.openingName = openingName;
  }

  public IfcBuildingStoreyWall getIfcBuildingStoreyWall() {
    return this.ifcBuildingStoreyWall;
  }

  public void setIfcBuildingStoreyWall(final IfcBuildingStoreyWall ifcBuildingStoreyWall) {
    this.ifcBuildingStoreyWall = ifcBuildingStoreyWall;
  }

  public List<IfcBuildingStoreyWallOpeningPresentationlayer> getIfcBuildingStoreyWallOpeningPresentationlayers() {
    return this.ifcBuildingStoreyWallOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallOpeningPresentationlayers(final List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers) {
    this.ifcBuildingStoreyWallOpeningPresentationlayers = ifcBuildingStoreyWallOpeningPresentationlayers;
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer
         addIfcBuildingStoreyWallOpeningPresentationlayer(final IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
    getIfcBuildingStoreyWallOpeningPresentationlayers().add(ifcBuildingStoreyWallOpeningPresentationlayer);
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(this);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer
         removeIfcBuildingStoreyWallOpeningPresentationlayer(final IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
    getIfcBuildingStoreyWallOpeningPresentationlayers().remove(ifcBuildingStoreyWallOpeningPresentationlayer);
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(null);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreyWallOpeningProperty> getIfcBuildingStoreyWallOpeningProperties() {
    return ifcBuildingStoreyWallOpeningProperties;
  }

  public void
         setIfcBuildingStoreyWallOpeningProperties(final List<IfcBuildingStoreyWallOpeningProperty> ifcBuildingStoreyWallOpeningProperties) {
    this.ifcBuildingStoreyWallOpeningProperties = ifcBuildingStoreyWallOpeningProperties;
  }

  public void addIfcBuildingStoreyWallOpeningProperty(final IfcBuildingStoreyWallOpeningProperty ifcBuildingStoreyWallOpeningProperty) {
    this.ifcBuildingStoreyWallOpeningProperties.add(ifcBuildingStoreyWallOpeningProperty);
  }

  public IfcOpeningElementEdo toEdo() {

    final IfcOpeningElementEdo edo = new IfcOpeningElementEdo();
    edo.setId(guid);
    edo.setName(openingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyWallOpeningPresentationlayer item : ifcBuildingStoreyWallOpeningPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyWallOpeningProperty item : ifcBuildingStoreyWallOpeningProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }
}
