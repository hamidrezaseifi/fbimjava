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

import com.futurebim.common.model.edo.ifc.IfcWallStandardCaseEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_wallstandardcase database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wallstandardcase")
public class IfcBuildingStoreyWallstandardcase extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status;

  private String tag;

  @Column(name = "storey_id")
  private String storeyId;

  private LocalDateTime updated;

  private int version;

  @Column(name = "wall_name")
  private String wallName;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id", insertable = false, updatable = false)
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpening
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallstandardcase", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallstandardcaseOpening> ifcBuildingStoreyWallstandardcaseOpenings = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcasePresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallstandardcase", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallstandardcasePresentationlayer> ifcBuildingStoreyWallstandardcasePresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyWallstandardcase", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyWallstandardcaseProperty> ifcBuildingStoreyWallstandardcaseProperties = new ArrayList<>();

  public IfcBuildingStoreyWallstandardcase() {
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

  public String getWallName() {
    return this.wallName;
  }

  public void setWallName(final String wallName) {
    this.wallName = wallName;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return this.ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyWallstandardcaseOpening> getIfcBuildingStoreyWallstandardcaseOpenings() {
    return this.ifcBuildingStoreyWallstandardcaseOpenings;
  }

  public void
         setIfcBuildingStoreyWallstandardcaseOpenings(final List<IfcBuildingStoreyWallstandardcaseOpening> ifcBuildingStoreyWallstandardcaseOpenings) {
    this.ifcBuildingStoreyWallstandardcaseOpenings = ifcBuildingStoreyWallstandardcaseOpenings;
  }

  public IfcBuildingStoreyWallstandardcaseOpening
         addIfcBuildingStoreyWallstandardcaseOpening(final IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening) {
    getIfcBuildingStoreyWallstandardcaseOpenings().add(ifcBuildingStoreyWallstandardcaseOpening);
    ifcBuildingStoreyWallstandardcaseOpening.setIfcBuildingStoreyWallstandardcase(this);

    return ifcBuildingStoreyWallstandardcaseOpening;
  }

  public IfcBuildingStoreyWallstandardcaseOpening
         removeIfcBuildingStoreyWallstandardcaseOpening(final IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening) {
    getIfcBuildingStoreyWallstandardcaseOpenings().remove(ifcBuildingStoreyWallstandardcaseOpening);
    ifcBuildingStoreyWallstandardcaseOpening.setIfcBuildingStoreyWallstandardcase(null);

    return ifcBuildingStoreyWallstandardcaseOpening;
  }

  public List<IfcBuildingStoreyWallstandardcasePresentationlayer> getIfcBuildingStoreyWallstandardcasePresentationlayers() {
    return this.ifcBuildingStoreyWallstandardcasePresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallstandardcasePresentationlayers(final List<IfcBuildingStoreyWallstandardcasePresentationlayer> ifcBuildingStoreyWallstandardcasePresentationlayers) {
    this.ifcBuildingStoreyWallstandardcasePresentationlayers = ifcBuildingStoreyWallstandardcasePresentationlayers;
  }

  public IfcBuildingStoreyWallstandardcasePresentationlayer
         addIfcBuildingStoreyWallstandardcasePresentationlayer(final IfcBuildingStoreyWallstandardcasePresentationlayer ifcBuildingStoreyWallstandardcasePresentationlayer) {
    getIfcBuildingStoreyWallstandardcasePresentationlayers().add(ifcBuildingStoreyWallstandardcasePresentationlayer);
    ifcBuildingStoreyWallstandardcasePresentationlayer.setIfcBuildingStoreyWallstandardcase(this);

    return ifcBuildingStoreyWallstandardcasePresentationlayer;
  }

  public IfcBuildingStoreyWallstandardcasePresentationlayer
         removeIfcBuildingStoreyWallstandardcasePresentationlayer(final IfcBuildingStoreyWallstandardcasePresentationlayer ifcBuildingStoreyWallstandardcasePresentationlayer) {
    getIfcBuildingStoreyWallstandardcasePresentationlayers().remove(ifcBuildingStoreyWallstandardcasePresentationlayer);
    ifcBuildingStoreyWallstandardcasePresentationlayer.setIfcBuildingStoreyWallstandardcase(null);

    return ifcBuildingStoreyWallstandardcasePresentationlayer;
  }

  public List<IfcBuildingStoreyWallstandardcaseProperty> getIfcBuildingStoreyWallstandardcaseProperties() {
    return this.ifcBuildingStoreyWallstandardcaseProperties;
  }

  public void
         setIfcBuildingStoreyWallstandardcaseProperties(final List<IfcBuildingStoreyWallstandardcaseProperty> ifcBuildingStoreyWallstandardcaseProperties) {
    this.ifcBuildingStoreyWallstandardcaseProperties = ifcBuildingStoreyWallstandardcaseProperties;
  }

  public IfcBuildingStoreyWallstandardcaseProperty
         addIfcBuildingStoreyWallstandardcaseProperty(final IfcBuildingStoreyWallstandardcaseProperty ifcBuildingStoreyWallstandardcaseProperty) {
    getIfcBuildingStoreyWallstandardcaseProperties().add(ifcBuildingStoreyWallstandardcaseProperty);
    ifcBuildingStoreyWallstandardcaseProperty.setIfcBuildingStoreyWallstandardcase(this);

    return ifcBuildingStoreyWallstandardcaseProperty;
  }

  public IfcBuildingStoreyWallstandardcaseProperty
         removeIfcBuildingStoreyWallstandardcaseProperty(final IfcBuildingStoreyWallstandardcaseProperty ifcBuildingStoreyWallstandardcaseProperty) {
    getIfcBuildingStoreyWallstandardcaseProperties().remove(ifcBuildingStoreyWallstandardcaseProperty);
    ifcBuildingStoreyWallstandardcaseProperty.setIfcBuildingStoreyWallstandardcase(null);

    return ifcBuildingStoreyWallstandardcaseProperty;
  }

  public String getStoreyId() {
    return storeyId;
  }

  public void setStoreyId(final String storeyId) {
    this.storeyId = storeyId;
  }

  public IfcWallStandardCaseEdo toEdo() {

    final IfcWallStandardCaseEdo edo = new IfcWallStandardCaseEdo();
    edo.setId(id);
    edo.setName(wallName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyWallstandardcaseProperty item : ifcBuildingStoreyWallstandardcaseProperties) {
      edo.addPropertySet(item.toEdo());
    }

    for (final IfcBuildingStoreyWallstandardcasePresentationlayer item : ifcBuildingStoreyWallstandardcasePresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyWallstandardcaseOpening item : ifcBuildingStoreyWallstandardcaseOpenings) {
      edo.addOpeningElement(item.toEdo());
    }

    return edo;
  }
}
