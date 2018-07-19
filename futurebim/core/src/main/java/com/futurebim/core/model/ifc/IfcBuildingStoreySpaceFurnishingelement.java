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

import com.futurebim.common.model.edo.ifc.IfcFurnishingElementEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_space_furnishingelement database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_furnishingelement")
public class IfcBuildingStoreySpaceFurnishingelement extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  private LocalDateTime created;

  @Column(name = "element_name")
  private String elementName;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "space_id")
  private IfcBuildingStoreySpace ifcBuildingStoreySpace;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementFurnituretype
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySpaceFurnishingelement", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes =
                                                                                                                           new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySpaceFurnishingelement", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers =
                                                                                                                                   new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySpaceFurnishingelement", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySpaceFurnishingelement", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementOpening> IfcBuildingStoreySpaceFurnishingelementOpenings = new ArrayList<>();

  public IfcBuildingStoreySpaceFurnishingelement() {
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

  public String getElementName() {
    return this.elementName;
  }

  public void setElementName(final String elementName) {
    this.elementName = elementName;
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

  public IfcBuildingStoreySpace getIfcBuildingStorey() {
    return this.ifcBuildingStoreySpace;
  }

  public void setIfcBuildingStorey(final IfcBuildingStoreySpace ifcBuildingStoreySpace) {
    this.ifcBuildingStoreySpace = ifcBuildingStoreySpace;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> getIfcBuildingStoreySpaceFurnishingelementFurnituretypes() {
    return this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementFurnituretypes(final List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes) {
    this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes = ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
  }

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype
         addIfcBuildingStoreySpaceFurnishingelementFurnituretype(final IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
    getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().add(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
    ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcBuildingStoreySpaceFurnishingelement(this);

    return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
  }

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype
         removeIfcBuildingStoreySpaceFurnishingelementFurnituretype(final IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
    getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().remove(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
    ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcBuildingStoreySpaceFurnishingelement(null);

    return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> getIfcBuildingStoreySpaceFurnishingelementPresentationlayers() {
    return this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementPresentationlayers(final List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers) {
    this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers = ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
  }

  public IfcBuildingStoreySpaceFurnishingelementPresentationlayer
         addIfcBuildingStoreySpaceFurnishingelementPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
    getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().add(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
    ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcBuildingStoreySpaceFurnishingelement(this);

    return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
  }

  public IfcBuildingStoreySpaceFurnishingelementPresentationlayer
         removeIfcBuildingStoreySpaceFurnishingelementPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
    getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().remove(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
    ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcBuildingStoreySpaceFurnishingelement(null);

    return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementProperty> getIfcBuildingStoreySpaceFurnishingelementProperties() {
    return this.ifcBuildingStoreySpaceFurnishingelementProperties;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementProperties(final List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties) {
    this.ifcBuildingStoreySpaceFurnishingelementProperties = ifcBuildingStoreySpaceFurnishingelementProperties;
  }

  public IfcBuildingStoreySpaceFurnishingelementProperty
         addIfcBuildingStoreySpaceFurnishingelementProperty(final IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
    getIfcBuildingStoreySpaceFurnishingelementProperties().add(ifcBuildingStoreySpaceFurnishingelementProperty);
    ifcBuildingStoreySpaceFurnishingelementProperty.setIfcBuildingStoreySpaceFurnishingelement(this);

    return ifcBuildingStoreySpaceFurnishingelementProperty;
  }

  public IfcBuildingStoreySpaceFurnishingelementProperty
         removeIfcBuildingStoreySpaceFurnishingelementProperty(final IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
    getIfcBuildingStoreySpaceFurnishingelementProperties().remove(ifcBuildingStoreySpaceFurnishingelementProperty);
    ifcBuildingStoreySpaceFurnishingelementProperty.setIfcBuildingStoreySpaceFurnishingelement(null);

    return ifcBuildingStoreySpaceFurnishingelementProperty;
  }

  public IfcBuildingStoreySpace getIfcBuildingStoreySpace() {
    return ifcBuildingStoreySpace;
  }

  public void setIfcBuildingStoreySpace(final IfcBuildingStoreySpace ifcBuildingStoreySpace) {
    this.ifcBuildingStoreySpace = ifcBuildingStoreySpace;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementOpening> getIfcBuildingStoreySpaceFurnishingelementOpenings() {
    return IfcBuildingStoreySpaceFurnishingelementOpenings;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementOpenings(final List<IfcBuildingStoreySpaceFurnishingelementOpening> ifcBuildingStoreySpaceFurnishingelementOpenings) {
    IfcBuildingStoreySpaceFurnishingelementOpenings = ifcBuildingStoreySpaceFurnishingelementOpenings;
  }

  public void
         addIfcBuildingStoreySpaceFurnishingelementOpening(final IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening) {
    ifcBuildingStoreySpaceFurnishingelementOpening.setIfcBuildingStoreySpaceFurnishingelement(this);
    IfcBuildingStoreySpaceFurnishingelementOpenings.add(ifcBuildingStoreySpaceFurnishingelementOpening);
  }

  public IfcFurnishingElementEdo toEdo() {

    final IfcFurnishingElementEdo edo = new IfcFurnishingElementEdo();
    edo.setId(guid);
    edo.setName(elementName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreySpaceFurnishingelementPresentationlayer item : ifcBuildingStoreySpaceFurnishingelementPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreySpaceFurnishingelementProperty item : ifcBuildingStoreySpaceFurnishingelementProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreySpaceFurnishingelementFurnituretype item : ifcBuildingStoreySpaceFurnishingelementFurnituretypes) {
      edo.addFurnitureType(item.toEdo());
    }

    for (final IfcBuildingStoreySpaceFurnishingelementOpening item : IfcBuildingStoreySpaceFurnishingelementOpenings) {
      edo.addOpeningElement(item.toEdo());
    }

    return edo;
  }
}
