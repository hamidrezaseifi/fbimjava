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

import com.futurebim.common.model.edo.ifc.IfcSlabEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_slab database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab")
public class IfcBuildingStoreySlab extends SerializableModelBase {

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

  @Column(name = "predefined_type")
  private String predefinedType;

  @Column(name = "slab_name")
  private String slabName;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreySlabPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySlab", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySlabProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySlab", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySlabOpening
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreySlab")
  private List<IfcBuildingStoreySlabOpening> ifcBuildingStoreySlabOpenings = new ArrayList<>();

  public IfcBuildingStoreySlab() {
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

  public String getPredefinedType() {
    return this.predefinedType;
  }

  public void setPredefinedType(final String predefinedType) {
    this.predefinedType = predefinedType;
  }

  public String getSlabName() {
    return this.slabName;
  }

  public void setSlabName(final String slabName) {
    this.slabName = slabName;
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

  public List<IfcBuildingStoreySlabPresentationlayer> getIfcBuildingStoreySlabPresentationlayers() {
    return this.ifcBuildingStoreySlabPresentationlayers;
  }

  public void
         setIfcBuildingStoreySlabPresentationlayers(final List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers) {
    this.ifcBuildingStoreySlabPresentationlayers = ifcBuildingStoreySlabPresentationlayers;
  }

  public IfcBuildingStoreySlabPresentationlayer
         addIfcBuildingStoreySlabPresentationlayer(final IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
    getIfcBuildingStoreySlabPresentationlayers().add(ifcBuildingStoreySlabPresentationlayer);
    ifcBuildingStoreySlabPresentationlayer.setIfcBuildingStoreySlab(this);

    return ifcBuildingStoreySlabPresentationlayer;
  }

  public IfcBuildingStoreySlabPresentationlayer
         removeIfcBuildingStoreySlabPresentationlayer(final IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
    getIfcBuildingStoreySlabPresentationlayers().remove(ifcBuildingStoreySlabPresentationlayer);
    ifcBuildingStoreySlabPresentationlayer.setIfcBuildingStoreySlab(null);

    return ifcBuildingStoreySlabPresentationlayer;
  }

  public List<IfcBuildingStoreySlabProperty> getIfcBuildingStoreySlabProperties() {
    return this.ifcBuildingStoreySlabProperties;
  }

  public void setIfcBuildingStoreySlabProperties(final List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties) {
    this.ifcBuildingStoreySlabProperties = ifcBuildingStoreySlabProperties;
  }

  public IfcBuildingStoreySlabProperty addIfcBuildingStoreySlabProperty(final IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
    getIfcBuildingStoreySlabProperties().add(ifcBuildingStoreySlabProperty);
    ifcBuildingStoreySlabProperty.setIfcBuildingStoreySlab(this);

    return ifcBuildingStoreySlabProperty;
  }

  public IfcBuildingStoreySlabProperty
         removeIfcBuildingStoreySlabProperty(final IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
    getIfcBuildingStoreySlabProperties().remove(ifcBuildingStoreySlabProperty);
    ifcBuildingStoreySlabProperty.setIfcBuildingStoreySlab(null);

    return ifcBuildingStoreySlabProperty;
  }

  public List<IfcBuildingStoreySlabOpening> getIfcBuildingStoreySlabOpenings() {
    return ifcBuildingStoreySlabOpenings;
  }

  public void setIfcBuildingStoreySlabOpenings(final List<IfcBuildingStoreySlabOpening> ifcBuildingStoreySlabOpenings) {
    this.ifcBuildingStoreySlabOpenings = ifcBuildingStoreySlabOpenings;
  }

  public void addIfcBuildingStoreySlabOpening(final IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
    ifcBuildingStoreySlabOpening.setIfcBuildingStoreySlab(this);
    this.ifcBuildingStoreySlabOpenings.add(ifcBuildingStoreySlabOpening);
  }

  public IfcSlabEdo toEdo() {

    final IfcSlabEdo edo = new IfcSlabEdo();
    edo.setId(guid);
    edo.setName(slabName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreySlabPresentationlayer item : ifcBuildingStoreySlabPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreySlabProperty item : ifcBuildingStoreySlabProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreySlabOpening item : ifcBuildingStoreySlabOpenings) {
      edo.addOpeningElement(item.toEdo());
    }

    return edo;
  }

}
