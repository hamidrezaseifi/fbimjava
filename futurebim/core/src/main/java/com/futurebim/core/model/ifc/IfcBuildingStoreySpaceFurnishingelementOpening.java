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

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_space_furnishingelement_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space_furnishingelement_opening")
public class IfcBuildingStoreySpaceFurnishingelementOpening extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private LocalDateTime created;

  @Column(name = "element_id")
  private String elementId;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "open_name")
  private String openName;

  private short status;

  private String tag;

  private int version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "element_id", insertable = false, updatable = false)
  private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer
  @OneToMany(mappedBy = "openingId", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer> ifcBuildingStoreySpaceFelementOpeningPresentationlayers =
                                                                                                                                        new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpeningProperty
  @OneToMany(mappedBy = "openingId", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> ifcBuildingStoreySpaceFurnishingelementOpeningProperties =
                                                                                                                                new ArrayList<>();

  public IfcBuildingStoreySpaceFurnishingelementOpening() {
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

  public String getElementId() {
    return this.elementId;
  }

  public void setElementId(final String elementId) {
    this.elementId = elementId;
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

  public String getOpenName() {
    return this.openName;
  }

  public void setOpenName(final String openName) {
    this.openName = openName;
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

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer>
         getIfcBuildingStoreySpaceFelementOpeningPresentationlayers() {
    return this.ifcBuildingStoreySpaceFelementOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreySpaceFelementOpeningPresentationlayers(final List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer> ifcBuildingStoreySpaceFelementOpeningPresentationlayers) {
    this.ifcBuildingStoreySpaceFelementOpeningPresentationlayers = ifcBuildingStoreySpaceFelementOpeningPresentationlayers;
  }

  public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer
         addIfcBuildingStoreySpaceFelementOpeningPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer ifcBuildingStoreySpaceFelementOpeningPresentationlayer) {
    getIfcBuildingStoreySpaceFelementOpeningPresentationlayers().add(ifcBuildingStoreySpaceFelementOpeningPresentationlayer);
    ifcBuildingStoreySpaceFelementOpeningPresentationlayer.setIfcBuildingStoreySpaceFurnishingelementOpening(this);

    return ifcBuildingStoreySpaceFelementOpeningPresentationlayer;
  }

  public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer
         removeIfcBuildingStoreySpaceFelementOpeningPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer ifcBuildingStoreySpaceFelementOpeningPresentationlayer) {
    getIfcBuildingStoreySpaceFelementOpeningPresentationlayers().remove(ifcBuildingStoreySpaceFelementOpeningPresentationlayer);
    ifcBuildingStoreySpaceFelementOpeningPresentationlayer.setIfcBuildingStoreySpaceFurnishingelementOpening(null);

    return ifcBuildingStoreySpaceFelementOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> getIfcBuildingStoreySpaceFurnishingelementOpeningProperties() {
    return this.ifcBuildingStoreySpaceFurnishingelementOpeningProperties;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementOpeningProperties(final List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> ifcBuildingStoreySpaceFurnishingelementOpeningProperties) {
    this.ifcBuildingStoreySpaceFurnishingelementOpeningProperties = ifcBuildingStoreySpaceFurnishingelementOpeningProperties;
  }

  public IfcBuildingStoreySpaceFurnishingelementOpeningProperty
         addIfcBuildingStoreySpaceFurnishingelementOpeningProperty(final IfcBuildingStoreySpaceFurnishingelementOpeningProperty ifcBuildingStoreySpaceFurnishingelementOpeningProperty) {
    getIfcBuildingStoreySpaceFurnishingelementOpeningProperties().add(ifcBuildingStoreySpaceFurnishingelementOpeningProperty);
    ifcBuildingStoreySpaceFurnishingelementOpeningProperty.setIfcBuildingStoreySpaceFurnishingelementOpening(this);

    return ifcBuildingStoreySpaceFurnishingelementOpeningProperty;
  }

  public IfcBuildingStoreySpaceFurnishingelementOpeningProperty
         removeIfcBuildingStoreySpaceFurnishingelementOpeningProperty(final IfcBuildingStoreySpaceFurnishingelementOpeningProperty ifcBuildingStoreySpaceFurnishingelementOpeningProperty) {
    getIfcBuildingStoreySpaceFurnishingelementOpeningProperties().remove(ifcBuildingStoreySpaceFurnishingelementOpeningProperty);
    ifcBuildingStoreySpaceFurnishingelementOpeningProperty.setIfcBuildingStoreySpaceFurnishingelementOpening(null);

    return ifcBuildingStoreySpaceFurnishingelementOpeningProperty;
  }

  public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
    return ifcBuildingStoreySpaceFurnishingelement;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelement(final IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
    this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
  }

}
