package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
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
 * The persistent class for the ifc_building_storey_space database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_space")
public class IfcBuildingStoreySpace extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "composition_type")
  private String compositionType;

  private Timestamp created;

  private String description;

  @Column(name = "interior_or_exterior_space")
  private String interiorOrExteriorSpace;

  @Column(name = "long_name")
  private String longName;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "space_name")
  private String spaceName;

  @Column(name = "storey_id")
  private String storeyId;

  private short status = 1;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id", updatable = false, insertable = false)
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreySpacePresentationlayer
  @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySpaceProperty
  @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySpaceProperty
  @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySpaceFurnishingelement> furnishingElementList = new ArrayList<>();

  public IfcBuildingStoreySpace() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getCompositionType() {
    return this.compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public String getInteriorOrExteriorSpace() {
    return this.interiorOrExteriorSpace;
  }

  public void setInteriorOrExteriorSpace(final String interiorOrExteriorSpace) {
    this.interiorOrExteriorSpace = interiorOrExteriorSpace;
  }

  public String getLongName() {
    return this.longName;
  }

  public void setLongName(final String longName) {
    this.longName = longName;
  }

  public String getObjectPlacement() {
    return this.objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getSpaceName() {
    return this.spaceName;
  }

  public void setSpaceName(final String spaceName) {
    this.spaceName = spaceName;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
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

  public List<IfcBuildingStoreySpacePresentationlayer> getIfcBuildingStoreySpacePresentationlayers() {
    return this.ifcBuildingStoreySpacePresentationlayers;
  }

  public void
         setIfcBuildingStoreySpacePresentationlayers(final List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers) {
    this.ifcBuildingStoreySpacePresentationlayers = ifcBuildingStoreySpacePresentationlayers;
  }

  public IfcBuildingStoreySpacePresentationlayer
         addIfcBuildingStoreySpacePresentationlayer(final IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
    getIfcBuildingStoreySpacePresentationlayers().add(ifcBuildingStoreySpacePresentationlayer);
    ifcBuildingStoreySpacePresentationlayer.setIfcBuildingStoreySpace(this);

    return ifcBuildingStoreySpacePresentationlayer;
  }

  public IfcBuildingStoreySpacePresentationlayer
         removeIfcBuildingStoreySpacePresentationlayer(final IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
    getIfcBuildingStoreySpacePresentationlayers().remove(ifcBuildingStoreySpacePresentationlayer);
    ifcBuildingStoreySpacePresentationlayer.setIfcBuildingStoreySpace(null);

    return ifcBuildingStoreySpacePresentationlayer;
  }

  public List<IfcBuildingStoreySpaceProperty> getIfcBuildingStoreySpaceProperties() {
    return this.ifcBuildingStoreySpaceProperties;
  }

  public void setIfcBuildingStoreySpaceProperties(final List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties) {
    this.ifcBuildingStoreySpaceProperties = ifcBuildingStoreySpaceProperties;
  }

  public IfcBuildingStoreySpaceProperty
         addIfcBuildingStoreySpaceProperty(final IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
    getIfcBuildingStoreySpaceProperties().add(ifcBuildingStoreySpaceProperty);
    ifcBuildingStoreySpaceProperty.setIfcBuildingStoreySpace(this);

    return ifcBuildingStoreySpaceProperty;
  }

  public IfcBuildingStoreySpaceProperty
         removeIfcBuildingStoreySpaceProperty(final IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
    getIfcBuildingStoreySpaceProperties().remove(ifcBuildingStoreySpaceProperty);
    ifcBuildingStoreySpaceProperty.setIfcBuildingStoreySpace(null);

    return ifcBuildingStoreySpaceProperty;
  }

  public String getStoreyId() {
    return storeyId;
  }

  public void setStoreyId(final String storeyId) {
    this.storeyId = storeyId;
  }

  public List<IfcBuildingStoreySpaceFurnishingelement> getFurnishingElementList() {
    return furnishingElementList;
  }

  public void setFurnishingElementList(final List<IfcBuildingStoreySpaceFurnishingelement> furnishingElementList) {
    this.furnishingElementList = furnishingElementList;
  }

  public void addFurnishingElement(final IfcBuildingStoreySpaceFurnishingelement furnishingElement) {
    this.furnishingElementList.add(furnishingElement);
  }

}
