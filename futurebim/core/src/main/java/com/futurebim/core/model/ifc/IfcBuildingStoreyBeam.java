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

import com.futurebim.common.model.edo.ifc.IfcBeamEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_beam database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_beam")
public class IfcBuildingStoreyBeam extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  @Column(name = "beam_name")
  private String beamName;

  private LocalDateTime created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyBeamPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyBeam", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcBuildingStoreyBeamProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcBuildingStoreyBeam", cascade = CascadeType.ALL)
  private List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties = new ArrayList<>();

  public IfcBuildingStoreyBeam() {
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

  public String getBeamName() {
    return this.beamName;
  }

  public void setBeamName(final String beamName) {
    this.beamName = beamName;
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

  public IfcBuildingStorey getIfcBuildingStorey() {
    return this.ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyBeamPresentationlayer> getIfcBuildingStoreyBeamPresentationlayers() {
    return this.ifcBuildingStoreyBeamPresentationlayers;
  }

  public void
         setIfcBuildingStoreyBeamPresentationlayers(final List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers) {
    this.ifcBuildingStoreyBeamPresentationlayers = ifcBuildingStoreyBeamPresentationlayers;
  }

  public IfcBuildingStoreyBeamPresentationlayer
         addIfcBuildingStoreyBeamPresentationlayer(final IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
    getIfcBuildingStoreyBeamPresentationlayers().add(ifcBuildingStoreyBeamPresentationlayer);
    ifcBuildingStoreyBeamPresentationlayer.setIfcBuildingStoreyBeam(this);

    return ifcBuildingStoreyBeamPresentationlayer;
  }

  public IfcBuildingStoreyBeamPresentationlayer
         removeIfcBuildingStoreyBeamPresentationlayer(final IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
    getIfcBuildingStoreyBeamPresentationlayers().remove(ifcBuildingStoreyBeamPresentationlayer);
    ifcBuildingStoreyBeamPresentationlayer.setIfcBuildingStoreyBeam(null);

    return ifcBuildingStoreyBeamPresentationlayer;
  }

  public List<IfcBuildingStoreyBeamProperty> getIfcBuildingStoreyBeamProperties() {
    return this.ifcBuildingStoreyBeamProperties;
  }

  public void setIfcBuildingStoreyBeamProperties(final List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties) {
    this.ifcBuildingStoreyBeamProperties = ifcBuildingStoreyBeamProperties;
  }

  public IfcBuildingStoreyBeamProperty addIfcBuildingStoreyBeamProperty(final IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
    getIfcBuildingStoreyBeamProperties().add(ifcBuildingStoreyBeamProperty);
    ifcBuildingStoreyBeamProperty.setIfcBuildingStoreyBeam(this);

    return ifcBuildingStoreyBeamProperty;
  }

  public IfcBuildingStoreyBeamProperty
         removeIfcBuildingStoreyBeamProperty(final IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
    getIfcBuildingStoreyBeamProperties().remove(ifcBuildingStoreyBeamProperty);
    ifcBuildingStoreyBeamProperty.setIfcBuildingStoreyBeam(null);

    return ifcBuildingStoreyBeamProperty;
  }

  public IfcBeamEdo toEdo() {

    final IfcBeamEdo edo = new IfcBeamEdo();
    edo.setId(guid);
    edo.setName(beamName);
    edo.setObjectPlacement(objectPlacement);
    edo.setObjectType(objectType);
    edo.setTag(tag);

    for (final IfcBuildingStoreyBeamPresentationlayer item : ifcBuildingStoreyBeamPresentationlayers) {
      edo.addPresentationLayerAssignment(item.toEdo());
    }

    for (final IfcBuildingStoreyBeamProperty item : ifcBuildingStoreyBeamProperties) {
      edo.addPropertySet(item.toEdo());
    }

    return edo;
  }

}
