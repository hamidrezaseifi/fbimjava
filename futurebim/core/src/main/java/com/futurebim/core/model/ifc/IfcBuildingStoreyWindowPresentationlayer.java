package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_window_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_window_presentationlayer")
public class IfcBuildingStoreyWindowPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "presentationlayer_id")
  private String presentationlayerId;

  @Column(name = "window_id")
  private String windowId;

  // bi-directional many-to-one association to IfcBuildingStoreyWindow
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "window_id", updatable = false, insertable = false)
  private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

  public IfcBuildingStoreyWindowPresentationlayer() {
  }

  public IfcBuildingStoreyWindowPresentationlayer(final String windowId, final String presentationlayerId) {
    this.windowId = windowId;
    this.presentationlayerId = presentationlayerId;
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

  public String getPresentationlayerId() {
    return presentationlayerId;
  }

  public void setPresentationlayerId(final String presentationlayerId) {
    this.presentationlayerId = presentationlayerId;
  }

  public String getWindowId() {
    return windowId;
  }

  public void setWindowId(final String windowId) {
    this.windowId = windowId;
  }

}
