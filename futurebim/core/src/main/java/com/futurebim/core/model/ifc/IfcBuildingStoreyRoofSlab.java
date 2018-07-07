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

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_roof_slab database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_roof_slab")
public class IfcBuildingStoreyRoofSlab extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "predefined_type")
  private String predefinedType;

  @Column(name = "slab_name")
  private String slabName;

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStoreyRoof
  @ManyToOne
  @JoinColumn(name = "roof_id", updatable = false, insertable = false)
  private IfcBuildingStoreyRoof ifcBuildingStoreyRoof;

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpening
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofSlab", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlabOpening> ifcBuildingStoreyRoofSlabOpenings = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofSlab", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlabPresentationlayer> ifcBuildingStoreyRoofSlabPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyRoofSlabProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyRoofSlab", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyRoofSlabProperty> ifcBuildingStoreyRoofSlabProperties = new ArrayList<>();

  public IfcBuildingStoreyRoofSlab() {
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

  public IfcBuildingStoreyRoof getIfcBuildingStoreyRoof() {
    return this.ifcBuildingStoreyRoof;
  }

  public void setIfcBuildingStoreyRoof(final IfcBuildingStoreyRoof ifcBuildingStoreyRoof) {
    this.ifcBuildingStoreyRoof = ifcBuildingStoreyRoof;
  }

  public List<IfcBuildingStoreyRoofSlabOpening> getIfcBuildingStoreyRoofSlabOpenings() {
    return this.ifcBuildingStoreyRoofSlabOpenings;
  }

  public void setIfcBuildingStoreyRoofSlabOpenings(final List<IfcBuildingStoreyRoofSlabOpening> ifcBuildingStoreyRoofSlabOpenings) {
    this.ifcBuildingStoreyRoofSlabOpenings = ifcBuildingStoreyRoofSlabOpenings;
  }

  public IfcBuildingStoreyRoofSlabOpening
         addIfcBuildingStoreyRoofSlabOpening(final IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
    getIfcBuildingStoreyRoofSlabOpenings().add(ifcBuildingStoreyRoofSlabOpening);
    ifcBuildingStoreyRoofSlabOpening.setIfcBuildingStoreyRoofSlab(this);

    return ifcBuildingStoreyRoofSlabOpening;
  }

  public IfcBuildingStoreyRoofSlabOpening
         removeIfcBuildingStoreyRoofSlabOpening(final IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
    getIfcBuildingStoreyRoofSlabOpenings().remove(ifcBuildingStoreyRoofSlabOpening);
    ifcBuildingStoreyRoofSlabOpening.setIfcBuildingStoreyRoofSlab(null);

    return ifcBuildingStoreyRoofSlabOpening;
  }

  public List<IfcBuildingStoreyRoofSlabPresentationlayer> getIfcBuildingStoreyRoofSlabPresentationlayers() {
    return this.ifcBuildingStoreyRoofSlabPresentationlayers;
  }

  public void
         setIfcBuildingStoreyRoofSlabPresentationlayers(final List<IfcBuildingStoreyRoofSlabPresentationlayer> ifcBuildingStoreyRoofSlabPresentationlayers) {
    this.ifcBuildingStoreyRoofSlabPresentationlayers = ifcBuildingStoreyRoofSlabPresentationlayers;
  }

  public IfcBuildingStoreyRoofSlabPresentationlayer
         addIfcBuildingStoreyRoofSlabPresentationlayer(final IfcBuildingStoreyRoofSlabPresentationlayer ifcBuildingStoreyRoofSlabPresentationlayer) {
    getIfcBuildingStoreyRoofSlabPresentationlayers().add(ifcBuildingStoreyRoofSlabPresentationlayer);
    ifcBuildingStoreyRoofSlabPresentationlayer.setIfcBuildingStoreyRoofSlab(this);

    return ifcBuildingStoreyRoofSlabPresentationlayer;
  }

  public IfcBuildingStoreyRoofSlabPresentationlayer
         removeIfcBuildingStoreyRoofSlabPresentationlayer(final IfcBuildingStoreyRoofSlabPresentationlayer ifcBuildingStoreyRoofSlabPresentationlayer) {
    getIfcBuildingStoreyRoofSlabPresentationlayers().remove(ifcBuildingStoreyRoofSlabPresentationlayer);
    ifcBuildingStoreyRoofSlabPresentationlayer.setIfcBuildingStoreyRoofSlab(null);

    return ifcBuildingStoreyRoofSlabPresentationlayer;
  }

  public List<IfcBuildingStoreyRoofSlabProperty> getIfcBuildingStoreyRoofSlabProperties() {
    return this.ifcBuildingStoreyRoofSlabProperties;
  }

  public void setIfcBuildingStoreyRoofSlabProperties(final List<IfcBuildingStoreyRoofSlabProperty> ifcBuildingStoreyRoofSlabProperties) {
    this.ifcBuildingStoreyRoofSlabProperties = ifcBuildingStoreyRoofSlabProperties;
  }

  public IfcBuildingStoreyRoofSlabProperty
         addIfcBuildingStoreyRoofSlabProperty(final IfcBuildingStoreyRoofSlabProperty ifcBuildingStoreyRoofSlabProperty) {
    getIfcBuildingStoreyRoofSlabProperties().add(ifcBuildingStoreyRoofSlabProperty);
    ifcBuildingStoreyRoofSlabProperty.setIfcBuildingStoreyRoofSlab(this);

    return ifcBuildingStoreyRoofSlabProperty;
  }

  public IfcBuildingStoreyRoofSlabProperty
         removeIfcBuildingStoreyRoofSlabProperty(final IfcBuildingStoreyRoofSlabProperty ifcBuildingStoreyRoofSlabProperty) {
    getIfcBuildingStoreyRoofSlabProperties().remove(ifcBuildingStoreyRoofSlabProperty);
    ifcBuildingStoreyRoofSlabProperty.setIfcBuildingStoreyRoofSlab(null);

    return ifcBuildingStoreyRoofSlabProperty;
  }

}
