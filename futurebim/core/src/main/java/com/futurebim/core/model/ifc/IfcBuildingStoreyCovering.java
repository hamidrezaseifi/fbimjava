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

import com.futurebim.common.model.edo.ifc.IfcCoveringEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_covering database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_covering")
public class IfcBuildingStoreyCovering extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  @Column(name = "covering_name")
  private String coveringName;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "predefined_type")
  private String predefinedType;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyCovering", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyCovering", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties = new ArrayList<>();

  public IfcBuildingStoreyCovering() {
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

  public String getCoveringName() {
    return this.coveringName;
  }

  public void setCoveringName(final String coveringName) {
    this.coveringName = coveringName;
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

  public List<IfcBuildingStoreyCoveringPresentationlayer> getIfcBuildingStoreyCoveringPresentationlayers() {
    return this.ifcBuildingStoreyCoveringPresentationlayers;
  }

  public void
         setIfcBuildingStoreyCoveringPresentationlayers(final List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers) {
    this.ifcBuildingStoreyCoveringPresentationlayers = ifcBuildingStoreyCoveringPresentationlayers;
  }

  public IfcBuildingStoreyCoveringPresentationlayer
         addIfcBuildingStoreyCoveringPresentationlayer(final IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
    getIfcBuildingStoreyCoveringPresentationlayers().add(ifcBuildingStoreyCoveringPresentationlayer);
    ifcBuildingStoreyCoveringPresentationlayer.setIfcBuildingStoreyCovering(this);

    return ifcBuildingStoreyCoveringPresentationlayer;
  }

  public IfcBuildingStoreyCoveringPresentationlayer
         removeIfcBuildingStoreyCoveringPresentationlayer(final IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
    getIfcBuildingStoreyCoveringPresentationlayers().remove(ifcBuildingStoreyCoveringPresentationlayer);
    ifcBuildingStoreyCoveringPresentationlayer.setIfcBuildingStoreyCovering(null);

    return ifcBuildingStoreyCoveringPresentationlayer;
  }

  public List<IfcBuildingStoreyCoveringProperty> getIfcBuildingStoreyCoveringProperties() {
    return this.ifcBuildingStoreyCoveringProperties;
  }

  public void setIfcBuildingStoreyCoveringProperties(final List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties) {
    this.ifcBuildingStoreyCoveringProperties = ifcBuildingStoreyCoveringProperties;
  }

  public IfcBuildingStoreyCoveringProperty
         addIfcBuildingStoreyCoveringProperty(final IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
    getIfcBuildingStoreyCoveringProperties().add(ifcBuildingStoreyCoveringProperty);
    ifcBuildingStoreyCoveringProperty.setIfcBuildingStoreyCovering(this);

    return ifcBuildingStoreyCoveringProperty;
  }

  public IfcBuildingStoreyCoveringProperty
         removeIfcBuildingStoreyCoveringProperty(final IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
    getIfcBuildingStoreyCoveringProperties().remove(ifcBuildingStoreyCoveringProperty);
    ifcBuildingStoreyCoveringProperty.setIfcBuildingStoreyCovering(null);

    return ifcBuildingStoreyCoveringProperty;
  }

  public IfcCoveringEdo toEdo() {

    final IfcCoveringEdo edo = new IfcCoveringEdo();
    edo.setId(guid);
    edo.setName(coveringName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);
    edo.setPredefinedType(predefinedType);

    for (final IfcBuildingStoreyCoveringPresentationlayer item : ifcBuildingStoreyCoveringPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyCoveringProperty item : ifcBuildingStoreyCoveringProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }

}
