package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the ifc_building_storey_roof_slab_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab_opening")
public class IfcBuildingStoreyRoofSlabOpening extends SerializableModelBase {

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

  @Column(name = "opening_name")
  private String openingName;

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
  @ManyToOne
  @JoinColumn(name = "slab_id")
  private IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpeningPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofSlabOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> ifcBuildingStoreyRoofSlabOpeningPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpeningProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofSlabOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlabOpeningProperty> ifcBuildingStoreyRoofSlabOpeningProperties = new ArrayList<>();

  public IfcBuildingStoreyRoofSlabOpening() {
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

  public String getOpeningName() {
    return this.openingName;
  }

  public void setOpeningName(final String openingName) {
    this.openingName = openingName;
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

  public IfcBuildingStoreyRoofSlab getIfcBuildingStoreyRoofSlab() {
    return this.ifcBuildingStoreyRoofSlab;
  }

  public void setIfcBuildingStoreyRoofSlab(final IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
    this.ifcBuildingStoreyRoofSlab = ifcBuildingStoreyRoofSlab;
  }

  public List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> getIfcBuildingStoreyRoofSlabOpeningPresentationlayers() {
    return this.ifcBuildingStoreyRoofSlabOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreyRoofSlabOpeningPresentationlayers(final List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> ifcBuildingStoreyRoofSlabOpeningPresentationlayers) {
    this.ifcBuildingStoreyRoofSlabOpeningPresentationlayers = ifcBuildingStoreyRoofSlabOpeningPresentationlayers;
  }

  public IfcBuildingStoreyRoofSlabOpeningPresentationlayer
         addIfcBuildingStoreyRoofSlabOpeningPresentationlayer(final IfcBuildingStoreyRoofSlabOpeningPresentationlayer ifcBuildingStoreyRoofSlabOpeningPresentationlayer) {
    getIfcBuildingStoreyRoofSlabOpeningPresentationlayers().add(ifcBuildingStoreyRoofSlabOpeningPresentationlayer);
    ifcBuildingStoreyRoofSlabOpeningPresentationlayer.setIfcBuildingStoreyRoofSlabOpening(this);

    return ifcBuildingStoreyRoofSlabOpeningPresentationlayer;
  }

  public IfcBuildingStoreyRoofSlabOpeningPresentationlayer
         removeIfcBuildingStoreyRoofSlabOpeningPresentationlayer(final IfcBuildingStoreyRoofSlabOpeningPresentationlayer ifcBuildingStoreyRoofSlabOpeningPresentationlayer) {
    getIfcBuildingStoreyRoofSlabOpeningPresentationlayers().remove(ifcBuildingStoreyRoofSlabOpeningPresentationlayer);
    ifcBuildingStoreyRoofSlabOpeningPresentationlayer.setIfcBuildingStoreyRoofSlabOpening(null);

    return ifcBuildingStoreyRoofSlabOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreyRoofSlabOpeningProperty> getIfcBuildingStoreyRoofSlabOpeningProperties() {
    return this.ifcBuildingStoreyRoofSlabOpeningProperties;
  }

  public void
         setIfcBuildingStoreyRoofSlabOpeningProperties(final List<IfcBuildingStoreyRoofSlabOpeningProperty> ifcBuildingStoreyRoofSlabOpeningProperties) {
    this.ifcBuildingStoreyRoofSlabOpeningProperties = ifcBuildingStoreyRoofSlabOpeningProperties;
  }

  public IfcBuildingStoreyRoofSlabOpeningProperty
         addIfcBuildingStoreyRoofSlabOpeningProperty(final IfcBuildingStoreyRoofSlabOpeningProperty ifcBuildingStoreyRoofSlabOpeningProperty) {
    getIfcBuildingStoreyRoofSlabOpeningProperties().add(ifcBuildingStoreyRoofSlabOpeningProperty);
    ifcBuildingStoreyRoofSlabOpeningProperty.setIfcBuildingStoreyRoofSlabOpening(this);

    return ifcBuildingStoreyRoofSlabOpeningProperty;
  }

  public IfcBuildingStoreyRoofSlabOpeningProperty
         removeIfcBuildingStoreyRoofSlabOpeningProperty(final IfcBuildingStoreyRoofSlabOpeningProperty ifcBuildingStoreyRoofSlabOpeningProperty) {
    getIfcBuildingStoreyRoofSlabOpeningProperties().remove(ifcBuildingStoreyRoofSlabOpeningProperty);
    ifcBuildingStoreyRoofSlabOpeningProperty.setIfcBuildingStoreyRoofSlabOpening(null);

    return ifcBuildingStoreyRoofSlabOpeningProperty;
  }

  public IfcOpeningElementEdo toEdo() {

    final IfcOpeningElementEdo edo = new IfcOpeningElementEdo();
    edo.setId(guid);
    edo.setName(openingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyRoofSlabOpeningPresentationlayer item : ifcBuildingStoreyRoofSlabOpeningPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyRoofSlabOpeningProperty item : ifcBuildingStoreyRoofSlabOpeningProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }
}
