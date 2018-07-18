package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.common.model.edo.ifc.IfcWindowStyleSetEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_window_style database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_window_style")
public class IfcBuildingStoreyWindowStyle extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private short status = 1;

  @Column(name = "ifc_id")
  private Long ifcId;

  @Column(name = "style_id")
  private String styleId;

  @Column(name = "window_id")
  private String windowId;

  // bi-directional many-to-one association to IfcBuildingStoreyWindow
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "window_id", updatable = false, insertable = false)
  private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

  public IfcBuildingStoreyWindowStyle() {
  }

  public IfcBuildingStoreyWindowStyle(final String windowId, final String styleId) {
    this.windowId = windowId;
    this.styleId = styleId;
  }

  public Long getIfcId() {
    return ifcId;
  }

  public void setIfcId(final Long ifcId) {
    this.ifcId = ifcId;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public IfcBuildingStoreyWindow getIfcBuildingStoreyWindow() {
    return this.ifcBuildingStoreyWindow;
  }

  public void setIfcBuildingStoreyWindow(final IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
    this.ifcBuildingStoreyWindow = ifcBuildingStoreyWindow;
  }

  public String getStyleId() {
    return styleId;
  }

  public void setStyleId(final String styleId) {
    this.styleId = styleId;
  }

  public String getWindowId() {
    return windowId;
  }

  public void setWindowId(final String windowId) {
    this.windowId = windowId;
  }

  public IfcWindowStyleSetEdo toEdo() {

    final IfcWindowStyleSetEdo edo = new IfcWindowStyleSetEdo();
    edo.setHref(styleId);

    return edo;
  }
}
