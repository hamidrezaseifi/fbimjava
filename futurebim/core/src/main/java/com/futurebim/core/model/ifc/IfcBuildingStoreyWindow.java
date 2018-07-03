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
 * The persistent class for the ifc_building_storey_window database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_window")
public class IfcBuildingStoreyWindow extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  @Column(name = "overall_height")
  private String overallHeight;

  @Column(name = "overall_width")
  private String overallWidth;

  private short status = 1;

  private String tag;

  private Timestamp updated;

  private int version = 1;

  @Column(name = "window_name")
  private String windowName;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storey_id")
  private IfcBuildingStorey ifcBuildingStorey;

  // bi-directional many-to-one association to IfcBuildingStoreyWindowPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyWindow")
  private List<IfcBuildingStoreyWindowPresentationlayer> ifcBuildingStoreyWindowPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyWindowProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyWindow")
  private List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyWindowStyle
  @OneToMany(mappedBy = "ifcBuildingStoreyWindow")
  private List<IfcBuildingStoreyWindowStyle> ifcBuildingStoreyWindowStyles;

  public IfcBuildingStoreyWindow() {
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

  public String getWindowName() {
    return this.windowName;
  }

  public void setWindowName(final String windowName) {
    this.windowName = windowName;
  }

  public IfcBuildingStorey getIfcBuildingStorey() {
    return this.ifcBuildingStorey;
  }

  public void setIfcBuildingStorey(final IfcBuildingStorey ifcBuildingStorey) {
    this.ifcBuildingStorey = ifcBuildingStorey;
  }

  public List<IfcBuildingStoreyWindowPresentationlayer> getIfcBuildingStoreyWindowPresentationlayers() {
    return this.ifcBuildingStoreyWindowPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWindowPresentationlayers(final List<IfcBuildingStoreyWindowPresentationlayer> ifcBuildingStoreyWindowPresentationlayers) {
    this.ifcBuildingStoreyWindowPresentationlayers = ifcBuildingStoreyWindowPresentationlayers;
  }

  public IfcBuildingStoreyWindowPresentationlayer
         addIfcBuildingStoreyWindowPresentationlayer(final IfcBuildingStoreyWindowPresentationlayer ifcBuildingStoreyWindowPresentationlayer) {
    getIfcBuildingStoreyWindowPresentationlayers().add(ifcBuildingStoreyWindowPresentationlayer);
    ifcBuildingStoreyWindowPresentationlayer.setIfcBuildingStoreyWindow(this);

    return ifcBuildingStoreyWindowPresentationlayer;
  }

  public IfcBuildingStoreyWindowPresentationlayer
         removeIfcBuildingStoreyWindowPresentationlayer(final IfcBuildingStoreyWindowPresentationlayer ifcBuildingStoreyWindowPresentationlayer) {
    getIfcBuildingStoreyWindowPresentationlayers().remove(ifcBuildingStoreyWindowPresentationlayer);
    ifcBuildingStoreyWindowPresentationlayer.setIfcBuildingStoreyWindow(null);

    return ifcBuildingStoreyWindowPresentationlayer;
  }

  public List<IfcBuildingStoreyWindowProperty> getIfcBuildingStoreyWindowProperties() {
    return this.ifcBuildingStoreyWindowProperties;
  }

  public void setIfcBuildingStoreyWindowProperties(final List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties) {
    this.ifcBuildingStoreyWindowProperties = ifcBuildingStoreyWindowProperties;
  }

  public IfcBuildingStoreyWindowProperty
         addIfcBuildingStoreyWindowProperty(final IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
    getIfcBuildingStoreyWindowProperties().add(ifcBuildingStoreyWindowProperty);
    ifcBuildingStoreyWindowProperty.setIfcBuildingStoreyWindow(this);

    return ifcBuildingStoreyWindowProperty;
  }

  public IfcBuildingStoreyWindowProperty
         removeIfcBuildingStoreyWindowProperty(final IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
    getIfcBuildingStoreyWindowProperties().remove(ifcBuildingStoreyWindowProperty);
    ifcBuildingStoreyWindowProperty.setIfcBuildingStoreyWindow(null);

    return ifcBuildingStoreyWindowProperty;
  }

  public List<IfcBuildingStoreyWindowStyle> getIfcBuildingStoreyWindowStyles() {
    return this.ifcBuildingStoreyWindowStyles;
  }

  public void setIfcBuildingStoreyWindowStyles(final List<IfcBuildingStoreyWindowStyle> ifcBuildingStoreyWindowStyles) {
    this.ifcBuildingStoreyWindowStyles = ifcBuildingStoreyWindowStyles;
  }

  public IfcBuildingStoreyWindowStyle addIfcBuildingStoreyWindowStyle(final IfcBuildingStoreyWindowStyle ifcBuildingStoreyWindowStyle) {
    getIfcBuildingStoreyWindowStyles().add(ifcBuildingStoreyWindowStyle);
    ifcBuildingStoreyWindowStyle.setIfcBuildingStoreyWindow(this);

    return ifcBuildingStoreyWindowStyle;
  }

  public IfcBuildingStoreyWindowStyle removeIfcBuildingStoreyWindowStyle(final IfcBuildingStoreyWindowStyle ifcBuildingStoreyWindowStyle) {
    getIfcBuildingStoreyWindowStyles().remove(ifcBuildingStoreyWindowStyle);
    ifcBuildingStoreyWindowStyle.setIfcBuildingStoreyWindow(null);

    return ifcBuildingStoreyWindowStyle;
  }

}
