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

import com.futurebim.common.model.edo.ifc.IfcFootingEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_footing database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_footing")
public class IfcBuildingStoreyFooting extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  private LocalDateTime created;

  @Column(name = "footing_name")
  private String footingName;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "predefined_type")
  private String predefinedType;

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStoreyFootingPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyFooting", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyFootingPresentationlayer> ifcBuildingStoreyFootingPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyFootingProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyFooting", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyFootingProperty> ifcBuildingStoreyFootingProperties = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  public IfcBuildingStoreyFooting() {
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

  public String getFootingName() {
    return this.footingName;
  }

  public void setFootingName(final String footingName) {
    this.footingName = footingName;
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

  public List<IfcBuildingStoreyFootingPresentationlayer> getIfcBuildingStoreyFootingPresentationlayers() {
    return this.ifcBuildingStoreyFootingPresentationlayers;
  }

  public void
         setIfcBuildingStoreyFootingPresentationlayers(final List<IfcBuildingStoreyFootingPresentationlayer> ifcBuildingStoreyFootingPresentationlayers) {
    this.ifcBuildingStoreyFootingPresentationlayers = ifcBuildingStoreyFootingPresentationlayers;
  }

  public IfcBuildingStoreyFootingPresentationlayer
         addIfcBuildingStoreyFootingPresentationlayer(final IfcBuildingStoreyFootingPresentationlayer ifcBuildingStoreyFootingPresentationlayer) {
    getIfcBuildingStoreyFootingPresentationlayers().add(ifcBuildingStoreyFootingPresentationlayer);
    ifcBuildingStoreyFootingPresentationlayer.setIfcBuildingStoreyFooting(this);

    return ifcBuildingStoreyFootingPresentationlayer;
  }

  public IfcBuildingStoreyFootingPresentationlayer
         removeIfcBuildingStoreyFootingPresentationlayer(final IfcBuildingStoreyFootingPresentationlayer ifcBuildingStoreyFootingPresentationlayer) {
    getIfcBuildingStoreyFootingPresentationlayers().remove(ifcBuildingStoreyFootingPresentationlayer);
    ifcBuildingStoreyFootingPresentationlayer.setIfcBuildingStoreyFooting(null);

    return ifcBuildingStoreyFootingPresentationlayer;
  }

  public List<IfcBuildingStoreyFootingProperty> getIfcBuildingStoreyFootingProperties() {
    return this.ifcBuildingStoreyFootingProperties;
  }

  public void setIfcBuildingStoreyFootingProperties(final List<IfcBuildingStoreyFootingProperty> ifcBuildingStoreyFootingProperties) {
    this.ifcBuildingStoreyFootingProperties = ifcBuildingStoreyFootingProperties;
  }

  public IfcBuildingStoreyFootingProperty
         addIfcBuildingStoreyFootingProperty(final IfcBuildingStoreyFootingProperty ifcBuildingStoreyFootingProperty) {
    getIfcBuildingStoreyFootingProperties().add(ifcBuildingStoreyFootingProperty);
    ifcBuildingStoreyFootingProperty.setIfcBuildingStoreyFooting(this);

    return ifcBuildingStoreyFootingProperty;
  }

  public IfcBuildingStoreyFootingProperty
         removeIfcBuildingStoreyFootingProperty(final IfcBuildingStoreyFootingProperty ifcBuildingStoreyFootingProperty) {
    getIfcBuildingStoreyFootingProperties().remove(ifcBuildingStoreyFootingProperty);
    ifcBuildingStoreyFootingProperty.setIfcBuildingStoreyFooting(null);

    return ifcBuildingStoreyFootingProperty;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public IfcFootingEdo toEdo() {

    final IfcFootingEdo edo = new IfcFootingEdo();
    edo.setId(guid);
    edo.setName(footingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);
    edo.setPredefinedType(predefinedType);

    for (final IfcBuildingStoreyFootingProperty item : ifcBuildingStoreyFootingProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreyFootingPresentationlayer item : ifcBuildingStoreyFootingPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    return edo;
  }
}
