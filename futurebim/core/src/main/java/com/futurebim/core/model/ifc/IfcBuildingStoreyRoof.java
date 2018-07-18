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

import com.futurebim.common.model.edo.ifc.IfcRoofEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_roof database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof")
public class IfcBuildingStoreyRoof extends SerializableModelBase {

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

  @Column(name = "roof_name")
  private String roofName;

  @Column(name = "shape_type")
  private String shapeType;

  @Column(name = "storey_id")
  private String storeyId;

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id", updatable = false, insertable = false)
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoof", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofPresentationlayer> ifcBuildingStoreyRoofPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoof", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofProperty> ifcBuildingStoreyRoofProperties = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoof", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlab> ifcBuildingStoreyRoofSlabs = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofOpening
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyRoof", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofOpening> ifcBuildingStoreyRoofOpenings = new ArrayList<>();

  public IfcBuildingStoreyRoof() {
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

  public String getRoofName() {
    return this.roofName;
  }

  public void setRoofName(final String roofName) {
    this.roofName = roofName;
  }

  public String getShapeType() {
    return this.shapeType;
  }

  public void setShapeType(final String shapeType) {
    this.shapeType = shapeType;
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

  public List<IfcBuildingStoreyRoofPresentationlayer> getIfcBuildingStoreyRoofPresentationlayers() {
    return this.ifcBuildingStoreyRoofPresentationlayers;
  }

  public void
         setIfcBuildingStoreyRoofPresentationlayers(final List<IfcBuildingStoreyRoofPresentationlayer> ifcBuildingStoreyRoofPresentationlayers) {
    this.ifcBuildingStoreyRoofPresentationlayers = ifcBuildingStoreyRoofPresentationlayers;
  }

  public IfcBuildingStoreyRoofPresentationlayer
         addIfcBuildingStoreyRoofPresentationlayer(final IfcBuildingStoreyRoofPresentationlayer ifcBuildingStoreyRoofPresentationlayer) {
    getIfcBuildingStoreyRoofPresentationlayers().add(ifcBuildingStoreyRoofPresentationlayer);
    ifcBuildingStoreyRoofPresentationlayer.setIfcBuildingStoreyRoof(this);

    return ifcBuildingStoreyRoofPresentationlayer;
  }

  public IfcBuildingStoreyRoofPresentationlayer
         removeIfcBuildingStoreyRoofPresentationlayer(final IfcBuildingStoreyRoofPresentationlayer ifcBuildingStoreyRoofPresentationlayer) {
    getIfcBuildingStoreyRoofPresentationlayers().remove(ifcBuildingStoreyRoofPresentationlayer);
    ifcBuildingStoreyRoofPresentationlayer.setIfcBuildingStoreyRoof(null);

    return ifcBuildingStoreyRoofPresentationlayer;
  }

  public List<IfcBuildingStoreyRoofProperty> getIfcBuildingStoreyRoofProperties() {
    return this.ifcBuildingStoreyRoofProperties;
  }

  public void setIfcBuildingStoreyRoofProperties(final List<IfcBuildingStoreyRoofProperty> ifcBuildingStoreyRoofProperties) {
    this.ifcBuildingStoreyRoofProperties = ifcBuildingStoreyRoofProperties;
  }

  public IfcBuildingStoreyRoofProperty addIfcBuildingStoreyRoofProperty(final IfcBuildingStoreyRoofProperty ifcBuildingStoreyRoofProperty) {
    getIfcBuildingStoreyRoofProperties().add(ifcBuildingStoreyRoofProperty);
    ifcBuildingStoreyRoofProperty.setIfcBuildingStoreyRoof(this);

    return ifcBuildingStoreyRoofProperty;
  }

  public IfcBuildingStoreyRoofProperty
         removeIfcBuildingStoreyRoofProperty(final IfcBuildingStoreyRoofProperty ifcBuildingStoreyRoofProperty) {
    getIfcBuildingStoreyRoofProperties().remove(ifcBuildingStoreyRoofProperty);
    ifcBuildingStoreyRoofProperty.setIfcBuildingStoreyRoof(null);

    return ifcBuildingStoreyRoofProperty;
  }

  public List<IfcBuildingStoreyRoofSlab> getIfcBuildingStoreyRoofSlabs() {
    return this.ifcBuildingStoreyRoofSlabs;
  }

  public void setIfcBuildingStoreyRoofSlabs(final List<IfcBuildingStoreyRoofSlab> ifcBuildingStoreyRoofSlabs) {
    this.ifcBuildingStoreyRoofSlabs = ifcBuildingStoreyRoofSlabs;
  }

  public IfcBuildingStoreyRoofSlab addIfcBuildingStoreyRoofSlab(final IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
    getIfcBuildingStoreyRoofSlabs().add(ifcBuildingStoreyRoofSlab);
    ifcBuildingStoreyRoofSlab.setIfcBuildingStoreyRoof(this);

    return ifcBuildingStoreyRoofSlab;
  }

  public IfcBuildingStoreyRoofSlab removeIfcBuildingStoreyRoofSlab(final IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
    getIfcBuildingStoreyRoofSlabs().remove(ifcBuildingStoreyRoofSlab);
    ifcBuildingStoreyRoofSlab.setIfcBuildingStoreyRoof(null);

    return ifcBuildingStoreyRoofSlab;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyRoofOpening> getIfcBuildingStoreyRoofOpenings() {
    return ifcBuildingStoreyRoofOpenings;
  }

  public void setIfcBuildingStoreyRoofOpenings(final List<IfcBuildingStoreyRoofOpening> ifcBuildingStoreyRoofOpenings) {
    this.ifcBuildingStoreyRoofOpenings = ifcBuildingStoreyRoofOpenings;
  }

  public void addIfcBuildingStoreyRoofOpening(final IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening) {
    this.ifcBuildingStoreyRoofOpenings.add(ifcBuildingStoreyRoofOpening);
    ifcBuildingStoreyRoofOpening.setIfcBuildingStoreyRoof(this);
  }

  public String getStoreyId() {
    return storeyId;
  }

  public void setStoreyId(final String storeyId) {
    this.storeyId = storeyId;
  }

  public IfcRoofEdo toEdo() {

    final IfcRoofEdo edo = new IfcRoofEdo();
    edo.setId(id);
    edo.setName(roofName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);
    edo.setShapeType(shapeType);

    for (final IfcBuildingStoreyRoofProperty item : ifcBuildingStoreyRoofProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreyRoofPresentationlayer item : ifcBuildingStoreyRoofPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyRoofSlab item : ifcBuildingStoreyRoofSlabs) {
      edo.addSlab(item.toEdo());
    }

    for (final IfcBuildingStoreyRoofOpening item : ifcBuildingStoreyRoofOpenings) {
      edo.addOpeningElement(item.toEdo());
    }

    return edo;
  }
}
