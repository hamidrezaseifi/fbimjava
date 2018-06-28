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
 * The persistent class for the ifc_building_storey_door database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_door")
public class IfcBuildingStoreyDoor extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "door_name")
  private String doorName;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "overall_height")
  private String overallHeight;

  @Column(name = "overall_width")
  private String overallWidth;

  private short status;

  private String tag;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyDoorPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyDoor")
  private List<IfcBuildingStoreyDoorPresentationlayer> ifcBuildingStoreyDoorPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyDoorProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyDoor")
  private List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyDoorStyle
  @OneToMany(mappedBy = "ifcBuildingStoreyDoor")
  private List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles;

  public IfcBuildingStoreyDoor() {
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

  public String getDoorName() {
    return this.doorName;
  }

  public void setDoorName(final String doorName) {
    this.doorName = doorName;
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

  public String getOverallHeight() {
    return this.overallHeight;
  }

  public void setOverallHeight(final String overallHeight) {
    this.overallHeight = overallHeight;
  }

  public String getOverallWidth() {
    return this.overallWidth;
  }

  public void setOverallWidth(final String overallWidth) {
    this.overallWidth = overallWidth;
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

  public List<IfcBuildingStoreyDoorPresentationlayer> getIfcBuildingStoreyDoorPresentationlayers() {
    return this.ifcBuildingStoreyDoorPresentationlayers;
  }

  public void
         setIfcBuildingStoreyDoorPresentationlayers(final List<IfcBuildingStoreyDoorPresentationlayer> ifcBuildingStoreyDoorPresentationlayers) {
    this.ifcBuildingStoreyDoorPresentationlayers = ifcBuildingStoreyDoorPresentationlayers;
  }

  public IfcBuildingStoreyDoorPresentationlayer
         addIfcBuildingStoreyDoorPresentationlayer(final IfcBuildingStoreyDoorPresentationlayer ifcBuildingStoreyDoorPresentationlayer) {
    getIfcBuildingStoreyDoorPresentationlayers().add(ifcBuildingStoreyDoorPresentationlayer);
    ifcBuildingStoreyDoorPresentationlayer.setIfcBuildingStoreyDoor(this);

    return ifcBuildingStoreyDoorPresentationlayer;
  }

  public IfcBuildingStoreyDoorPresentationlayer
         removeIfcBuildingStoreyDoorPresentationlayer(final IfcBuildingStoreyDoorPresentationlayer ifcBuildingStoreyDoorPresentationlayer) {
    getIfcBuildingStoreyDoorPresentationlayers().remove(ifcBuildingStoreyDoorPresentationlayer);
    ifcBuildingStoreyDoorPresentationlayer.setIfcBuildingStoreyDoor(null);

    return ifcBuildingStoreyDoorPresentationlayer;
  }

  public List<IfcBuildingStoreyDoorProperty> getIfcBuildingStoreyDoorProperties() {
    return this.ifcBuildingStoreyDoorProperties;
  }

  public void setIfcBuildingStoreyDoorProperties(final List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties) {
    this.ifcBuildingStoreyDoorProperties = ifcBuildingStoreyDoorProperties;
  }

  public IfcBuildingStoreyDoorProperty addIfcBuildingStoreyDoorProperty(final IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
    getIfcBuildingStoreyDoorProperties().add(ifcBuildingStoreyDoorProperty);
    ifcBuildingStoreyDoorProperty.setIfcBuildingStoreyDoor(this);

    return ifcBuildingStoreyDoorProperty;
  }

  public IfcBuildingStoreyDoorProperty
         removeIfcBuildingStoreyDoorProperty(final IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
    getIfcBuildingStoreyDoorProperties().remove(ifcBuildingStoreyDoorProperty);
    ifcBuildingStoreyDoorProperty.setIfcBuildingStoreyDoor(null);

    return ifcBuildingStoreyDoorProperty;
  }

  public List<IfcBuildingStoreyDoorStyle> getIfcBuildingStoreyDoorStyles() {
    return this.ifcBuildingStoreyDoorStyles;
  }

  public void setIfcBuildingStoreyDoorStyles(final List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles) {
    this.ifcBuildingStoreyDoorStyles = ifcBuildingStoreyDoorStyles;
  }

  public IfcBuildingStoreyDoorStyle addIfcBuildingStoreyDoorStyle(final IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
    getIfcBuildingStoreyDoorStyles().add(ifcBuildingStoreyDoorStyle);
    ifcBuildingStoreyDoorStyle.setIfcBuildingStoreyDoor(this);

    return ifcBuildingStoreyDoorStyle;
  }

  public IfcBuildingStoreyDoorStyle removeIfcBuildingStoreyDoorStyle(final IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
    getIfcBuildingStoreyDoorStyles().remove(ifcBuildingStoreyDoorStyle);
    ifcBuildingStoreyDoorStyle.setIfcBuildingStoreyDoor(null);

    return ifcBuildingStoreyDoorStyle;
  }

}
