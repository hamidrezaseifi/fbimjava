package com.futurebim.core.model.ifc;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.IfcOpeningElementEdo;

/**
 * The persistent class for the ifc_building_storey_slab_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_opening")
@NamedQuery(name = "IfcBuildingStoreySlabOpening.findAll", query = "SELECT i FROM IfcBuildingStoreySlabOpening i")
public class IfcBuildingStoreySlabOpening implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "opening_name")
  private String openingName;

  @Column(name = "slab_id")
  private String slabId;

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStoreySlab
  @ManyToOne
  @JoinColumn(name = "slab_id", insertable = false, updatable = false)
  private IfcBuildingStoreySlab ifcBuildingStoreySlab;

  // bi-directional many-to-one association to IfcBuildingStoreySlabOpeningPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreySlabOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySlabOpeningPresentationlayer> ifcBuildingStoreySlabOpeningPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreySlabOpeningProperty
  @OneToMany(mappedBy = "ifcBuildingStoreySlabOpening", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreySlabOpeningProperty> ifcBuildingStoreySlabOpeningProperties = new ArrayList<>();

  public IfcBuildingStoreySlabOpening() {
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

  public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
    return this.ifcBuildingStoreySlab;
  }

  public void setIfcBuildingStoreySlab(final IfcBuildingStoreySlab ifcBuildingStoreySlab) {
    this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
  }

  public List<IfcBuildingStoreySlabOpeningPresentationlayer> getIfcBuildingStoreySlabOpeningPresentationlayers() {
    return this.ifcBuildingStoreySlabOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreySlabOpeningPresentationlayers(final List<IfcBuildingStoreySlabOpeningPresentationlayer> ifcBuildingStoreySlabOpeningPresentationlayers) {
    this.ifcBuildingStoreySlabOpeningPresentationlayers = ifcBuildingStoreySlabOpeningPresentationlayers;
  }

  public IfcBuildingStoreySlabOpeningPresentationlayer
         addIfcBuildingStoreySlabOpeningPresentationlayer(final IfcBuildingStoreySlabOpeningPresentationlayer ifcBuildingStoreySlabOpeningPresentationlayer) {
    getIfcBuildingStoreySlabOpeningPresentationlayers().add(ifcBuildingStoreySlabOpeningPresentationlayer);
    ifcBuildingStoreySlabOpeningPresentationlayer.setIfcBuildingStoreySlabOpening(this);

    return ifcBuildingStoreySlabOpeningPresentationlayer;
  }

  public IfcBuildingStoreySlabOpeningPresentationlayer
         removeIfcBuildingStoreySlabOpeningPresentationlayer(final IfcBuildingStoreySlabOpeningPresentationlayer ifcBuildingStoreySlabOpeningPresentationlayer) {
    getIfcBuildingStoreySlabOpeningPresentationlayers().remove(ifcBuildingStoreySlabOpeningPresentationlayer);
    ifcBuildingStoreySlabOpeningPresentationlayer.setIfcBuildingStoreySlabOpening(null);

    return ifcBuildingStoreySlabOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreySlabOpeningProperty> getIfcBuildingStoreySlabOpeningProperties() {
    return this.ifcBuildingStoreySlabOpeningProperties;
  }

  public void
         setIfcBuildingStoreySlabOpeningProperties(final List<IfcBuildingStoreySlabOpeningProperty> ifcBuildingStoreySlabOpeningProperties) {
    this.ifcBuildingStoreySlabOpeningProperties = ifcBuildingStoreySlabOpeningProperties;
  }

  public IfcBuildingStoreySlabOpeningProperty
         addIfcBuildingStoreySlabOpeningProperty(final IfcBuildingStoreySlabOpeningProperty ifcBuildingStoreySlabOpeningProperty) {
    getIfcBuildingStoreySlabOpeningProperties().add(ifcBuildingStoreySlabOpeningProperty);
    ifcBuildingStoreySlabOpeningProperty.setIfcBuildingStoreySlabOpening(this);

    return ifcBuildingStoreySlabOpeningProperty;
  }

  public IfcBuildingStoreySlabOpeningProperty
         removeIfcBuildingStoreySlabOpeningProperty(final IfcBuildingStoreySlabOpeningProperty ifcBuildingStoreySlabOpeningProperty) {
    getIfcBuildingStoreySlabOpeningProperties().remove(ifcBuildingStoreySlabOpeningProperty);
    ifcBuildingStoreySlabOpeningProperty.setIfcBuildingStoreySlabOpening(null);

    return ifcBuildingStoreySlabOpeningProperty;
  }

  public String getSlabId() {
    return slabId;
  }

  public void setSlabId(final String slabId) {
    this.slabId = slabId;
  }

  public IfcOpeningElementEdo toEdo() {

    final IfcOpeningElementEdo edo = new IfcOpeningElementEdo();
    edo.setId(id);
    edo.setName(openingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreySlabOpeningPresentationlayer item : ifcBuildingStoreySlabOpeningPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreySlabOpeningProperty item : ifcBuildingStoreySlabOpeningProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }
}
