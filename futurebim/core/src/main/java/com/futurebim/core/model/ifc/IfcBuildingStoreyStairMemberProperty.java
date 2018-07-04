package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
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
 * The persistent class for the ifc_building_storey_stair_member_properties database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_member_properties")
public class IfcBuildingStoreyStairMemberProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp created;

  private short status = 1;

  @Column(name = "property_id")
  private String propertyId;

  @Column(name = "member_id")
  private String memberId;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMember
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", updatable = false, insertable = false)
  private IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember;

  public IfcBuildingStoreyStairMemberProperty() {
  }

  public IfcBuildingStoreyStairMemberProperty(final String memberId, final String propertyId) {
    this.memberId = memberId;
    this.propertyId = propertyId;
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

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(final String propertyId) {
    this.propertyId = propertyId;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(final String memberId) {
    this.memberId = memberId;
  }

  public IfcBuildingStoreyStairMember getIfcBuildingStoreyStairMember() {
    return this.ifcBuildingStoreyStairMember;
  }

  public void setIfcBuildingStoreyStairMember(final IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
    this.ifcBuildingStoreyStairMember = ifcBuildingStoreyStairMember;
  }

}
