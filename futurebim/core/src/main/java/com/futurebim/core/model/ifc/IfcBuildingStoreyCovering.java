package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
  private String id;

  @Column(name = "covering_name")
  private String coveringName;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "predefined_type")
  private String predefinedType;

  private short status = 1;

  private String tag;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stair_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyCovering")
  private List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyCovering")
  private List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties;

  public IfcBuildingStoreyCovering() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getCoveringName() {
    return this.coveringName;
  }

  public void setCoveringName(final String coveringName) {
    this.coveringName = coveringName;
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

}
