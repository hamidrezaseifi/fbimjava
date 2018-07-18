package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the ifc_building_storey_roof_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_opening")
public class IfcBuildingStoreyRoofOpening extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "ifc_id")
  private Long ifcId;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "opening_name")
  private String openingName;

  private short status;

  private String tag;

  private Timestamp updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStoreyRoof
  @ManyToOne
  @JoinColumn(name = "roof_id")
  private IfcBuildingStoreyRoof ifcBuildingStoreyRoof;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofOpeningPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofOpeningPresentationlayer> ifcBuildingStoreyRoofOpeningPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofOpeningProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofOpeningProperty> ifcBuildingStoreyRoofOpeningProperties = new ArrayList<>();

  public IfcBuildingStoreyRoofOpening() {
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

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
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

  public IfcBuildingStoreyRoof getIfcBuildingStoreyRoof() {
    return this.ifcBuildingStoreyRoof;
  }

  public void setIfcBuildingStoreyRoof(final IfcBuildingStoreyRoof ifcBuildingStoreyRoof) {
    this.ifcBuildingStoreyRoof = ifcBuildingStoreyRoof;
  }

  public List<IfcBuildingStoreyRoofOpeningPresentationlayer> getIfcBuildingStoreyRoofOpeningPresentationlayers() {
    return this.ifcBuildingStoreyRoofOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreyRoofOpeningPresentationlayers(final List<IfcBuildingStoreyRoofOpeningPresentationlayer> ifcBuildingStoreyRoofOpeningPresentationlayers) {
    this.ifcBuildingStoreyRoofOpeningPresentationlayers = ifcBuildingStoreyRoofOpeningPresentationlayers;
  }

  public IfcBuildingStoreyRoofOpeningPresentationlayer
         addIfcBuildingStoreyRoofOpeningPresentationlayer(final IfcBuildingStoreyRoofOpeningPresentationlayer ifcBuildingStoreyRoofOpeningPresentationlayer) {
    getIfcBuildingStoreyRoofOpeningPresentationlayers().add(ifcBuildingStoreyRoofOpeningPresentationlayer);
    ifcBuildingStoreyRoofOpeningPresentationlayer.setIfcBuildingStoreyRoofOpening(this);

    return ifcBuildingStoreyRoofOpeningPresentationlayer;
  }

  public IfcBuildingStoreyRoofOpeningPresentationlayer
         removeIfcBuildingStoreyRoofOpeningPresentationlayer(final IfcBuildingStoreyRoofOpeningPresentationlayer ifcBuildingStoreyRoofOpeningPresentationlayer) {
    getIfcBuildingStoreyRoofOpeningPresentationlayers().remove(ifcBuildingStoreyRoofOpeningPresentationlayer);
    ifcBuildingStoreyRoofOpeningPresentationlayer.setIfcBuildingStoreyRoofOpening(null);

    return ifcBuildingStoreyRoofOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreyRoofOpeningProperty> getIfcBuildingStoreyRoofOpeningProperties() {
    return this.ifcBuildingStoreyRoofOpeningProperties;
  }

  public void
         setIfcBuildingStoreyRoofOpeningProperties(final List<IfcBuildingStoreyRoofOpeningProperty> ifcBuildingStoreyRoofOpeningProperties) {
    this.ifcBuildingStoreyRoofOpeningProperties = ifcBuildingStoreyRoofOpeningProperties;
  }

  public IfcBuildingStoreyRoofOpeningProperty
         addIfcBuildingStoreyRoofOpeningProperty(final IfcBuildingStoreyRoofOpeningProperty ifcBuildingStoreyRoofOpeningProperty) {
    getIfcBuildingStoreyRoofOpeningProperties().add(ifcBuildingStoreyRoofOpeningProperty);
    ifcBuildingStoreyRoofOpeningProperty.setIfcBuildingStoreyRoofOpening(this);

    return ifcBuildingStoreyRoofOpeningProperty;
  }

  public IfcBuildingStoreyRoofOpeningProperty
         removeIfcBuildingStoreyRoofOpeningProperty(final IfcBuildingStoreyRoofOpeningProperty ifcBuildingStoreyRoofOpeningProperty) {
    getIfcBuildingStoreyRoofOpeningProperties().remove(ifcBuildingStoreyRoofOpeningProperty);
    ifcBuildingStoreyRoofOpeningProperty.setIfcBuildingStoreyRoofOpening(null);

    return ifcBuildingStoreyRoofOpeningProperty;
  }

  public IfcOpeningElementEdo toEdo() {

    final IfcOpeningElementEdo edo = new IfcOpeningElementEdo();
    edo.setId(id);
    edo.setName(openingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyRoofOpeningPresentationlayer item : ifcBuildingStoreyRoofOpeningPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyRoofOpeningProperty item : ifcBuildingStoreyRoofOpeningProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }
}
