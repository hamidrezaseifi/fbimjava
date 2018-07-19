package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.List;

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

import com.futurebim.common.model.edo.ifc.IfcOpeningElementEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_wallstandardcase_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wallstandardcase_opening")
public class IfcBuildingStoreyWallstandardcaseOpening extends SerializableModelBase {

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

  private short status;

  private String tag;

  private LocalDateTime updated;

  private int version;

  @Column(name = "opening_name")
  private String openingName;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcase
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id")
  private IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallstandardcaseOpening")
  private List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpeningProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallstandardcaseOpening")
  private List<IfcBuildingStoreyWallstandardcaseOpeningProperty> ifcBuildingStoreyWallstandardcaseOpeningProperties;

  public IfcBuildingStoreyWallstandardcaseOpening() {
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

  public String getOpeningName() {
    return openingName;
  }

  public void setOpeningName(final String openingName) {
    this.openingName = openingName;
  }

  public IfcBuildingStoreyWallstandardcase getIfcBuildingStoreyWallstandardcase() {
    return this.ifcBuildingStoreyWallstandardcase;
  }

  public void setIfcBuildingStoreyWallstandardcase(final IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase) {
    this.ifcBuildingStoreyWallstandardcase = ifcBuildingStoreyWallstandardcase;
  }

  public List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers() {
    return this.ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers(final List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers) {
    this.ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers = ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;
  }

  public IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer
         addIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(final IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer) {
    getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers().add(ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer);
    ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer.setIfcBuildingStoreyWallstandardcaseOpening(this);

    return ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
  }

  public IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer
         removeIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(final IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer) {
    getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers().remove(ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer);
    ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer.setIfcBuildingStoreyWallstandardcaseOpening(null);

    return ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreyWallstandardcaseOpeningProperty> getIfcBuildingStoreyWallstandardcaseOpeningProperties() {
    return this.ifcBuildingStoreyWallstandardcaseOpeningProperties;
  }

  public void
         setIfcBuildingStoreyWallstandardcaseOpeningProperties(final List<IfcBuildingStoreyWallstandardcaseOpeningProperty> ifcBuildingStoreyWallstandardcaseOpeningProperties) {
    this.ifcBuildingStoreyWallstandardcaseOpeningProperties = ifcBuildingStoreyWallstandardcaseOpeningProperties;
  }

  public IfcBuildingStoreyWallstandardcaseOpeningProperty
         addIfcBuildingStoreyWallstandardcaseOpeningProperty(final IfcBuildingStoreyWallstandardcaseOpeningProperty ifcBuildingStoreyWallstandardcaseOpeningProperty) {
    getIfcBuildingStoreyWallstandardcaseOpeningProperties().add(ifcBuildingStoreyWallstandardcaseOpeningProperty);
    ifcBuildingStoreyWallstandardcaseOpeningProperty.setIfcBuildingStoreyWallstandardcaseOpening(this);

    return ifcBuildingStoreyWallstandardcaseOpeningProperty;
  }

  public IfcBuildingStoreyWallstandardcaseOpeningProperty
         removeIfcBuildingStoreyWallstandardcaseOpeningProperty(final IfcBuildingStoreyWallstandardcaseOpeningProperty ifcBuildingStoreyWallstandardcaseOpeningProperty) {
    getIfcBuildingStoreyWallstandardcaseOpeningProperties().remove(ifcBuildingStoreyWallstandardcaseOpeningProperty);
    ifcBuildingStoreyWallstandardcaseOpeningProperty.setIfcBuildingStoreyWallstandardcaseOpening(null);

    return ifcBuildingStoreyWallstandardcaseOpeningProperty;
  }

  public IfcOpeningElementEdo toEdo() {

    final IfcOpeningElementEdo edo = new IfcOpeningElementEdo();
    edo.setId(guid);
    edo.setName(openingName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer item : ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyWallstandardcaseOpeningProperty item : ifcBuildingStoreyWallstandardcaseOpeningProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }
}
