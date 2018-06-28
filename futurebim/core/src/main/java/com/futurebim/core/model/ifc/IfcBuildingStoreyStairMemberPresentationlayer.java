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
 * The persistent class for the ifc_building_storey_stair_member_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_member_presentationlayers")
public class IfcBuildingStoreyStairMemberPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMember
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember;

  // bi-directional many-to-one association to IfcPresentationlayer
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "presentationlayer_id")
  private IfcPresentationlayer ifcPresentationlayer;

  public IfcBuildingStoreyStairMemberPresentationlayer() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
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

  public IfcBuildingStoreyStairMember getIfcBuildingStoreyStairMember() {
    return this.ifcBuildingStoreyStairMember;
  }

  public void setIfcBuildingStoreyStairMember(final IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
    this.ifcBuildingStoreyStairMember = ifcBuildingStoreyStairMember;
  }

  public IfcPresentationlayer getIfcPresentationlayer() {
    return this.ifcPresentationlayer;
  }

  public void setIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    this.ifcPresentationlayer = ifcPresentationlayer;
  }

}
