package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
  private int id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcWindowstyle
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "style_id")
  private IfcWindowstyle ifcWindowstyle;

  // bi-directional many-to-one association to IfcBuildingStoreyWindow
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "window_id")
  private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

  public IfcBuildingStoreyWindowStyle() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
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

  public IfcWindowstyle getIfcWindowstyle() {
    return this.ifcWindowstyle;
  }

  public void setIfcWindowstyle(final IfcWindowstyle ifcWindowstyle) {
    this.ifcWindowstyle = ifcWindowstyle;
  }

  public IfcBuildingStoreyWindow getIfcBuildingStoreyWindow() {
    return this.ifcBuildingStoreyWindow;
  }

  public void setIfcBuildingStoreyWindow(final IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
    this.ifcBuildingStoreyWindow = ifcBuildingStoreyWindow;
  }

}
