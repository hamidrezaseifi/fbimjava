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
 * The persistent class for the ifc_building_storey_stair database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair")
public class IfcBuildingStoreyStair extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "shape_type")
  private String shapeType;

  @Column(name = "stair_name")
  private String stairName;

  private short status;

  private String tag;

  private Timestamp updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyStairProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyStair")
  private List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties;

  public IfcBuildingStoreyStair() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
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

  public String getShapeType() {
    return this.shapeType;
  }

  public void setShapeType(final String shapeType) {
    this.shapeType = shapeType;
  }

  public String getStairName() {
    return this.stairName;
  }

  public void setStairName(final String stairName) {
    this.stairName = stairName;
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

  public List<IfcBuildingStoreyStairProperty> getIfcBuildingStoreyStairProperties() {
    return this.ifcBuildingStoreyStairProperties;
  }

  public void setIfcBuildingStoreyStairProperties(final List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties) {
    this.ifcBuildingStoreyStairProperties = ifcBuildingStoreyStairProperties;
  }

  public IfcBuildingStoreyStairProperty
         addIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().add(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(this);

    return ifcBuildingStoreyStairProperty;
  }

  public IfcBuildingStoreyStairProperty
         removeIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().remove(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(null);

    return ifcBuildingStoreyStairProperty;
  }

}
