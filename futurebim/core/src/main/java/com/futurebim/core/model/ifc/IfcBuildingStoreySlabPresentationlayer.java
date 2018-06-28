package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_building_storey_slab_presentationlayer database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_slab_presentationlayer")
public class IfcBuildingStoreySlabPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreySlab
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "slab_id")
  private IfcBuildingStoreySlab ifcBuildingStoreySlab;

  // bi-directional many-to-one association to IfcPresentationlayer
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "presentationlayer_id")
  private IfcPresentationlayer ifcPresentationlayer;

  public IfcBuildingStoreySlabPresentationlayer() {
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

  public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
    return this.ifcBuildingStoreySlab;
  }

  public void setIfcBuildingStoreySlab(final IfcBuildingStoreySlab ifcBuildingStoreySlab) {
    this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
  }

  public IfcPresentationlayer getIfcPresentationlayer() {
    return this.ifcPresentationlayer;
  }

  public void setIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    this.ifcPresentationlayer = ifcPresentationlayer;
  }

}
