package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
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
 * The persistent class for the ifc_building_storey_stair_member database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_stair_member")
public class IfcBuildingStoreyStairMember extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private LocalDateTime created;

  @Column(name = "member_name")
  private String memberName;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status = 1;

  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStorey
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stair_id")
  private IfcBuildingStoreyStair ifcBuildingStoreyStair;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMemberPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyStairMember")
  private List<IfcBuildingStoreyStairMemberPresentationlayer> ifcBuildingStoreyStairMemberPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMemberProperty
  @OneToMany(mappedBy = "ifcBuildingStoreyStairMember")
  private List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties;

  public IfcBuildingStoreyStairMember() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getMemberName() {
    return this.memberName;
  }

  public void setMemberName(final String memberName) {
    this.memberName = memberName;
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

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
    return this.ifcBuildingStoreyStair;
  }

  public void setIfcBuildingStoreyStair(final IfcBuildingStoreyStair ifcBuildingStoreyStair) {
    this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
  }

  public List<IfcBuildingStoreyStairMemberPresentationlayer> getIfcBuildingStoreyStairMemberPresentationlayers() {
    return this.ifcBuildingStoreyStairMemberPresentationlayers;
  }

  public void
         setIfcBuildingStoreyStairMemberPresentationlayers(final List<IfcBuildingStoreyStairMemberPresentationlayer> ifcBuildingStoreyStairMemberPresentationlayers) {
    this.ifcBuildingStoreyStairMemberPresentationlayers = ifcBuildingStoreyStairMemberPresentationlayers;
  }

  public IfcBuildingStoreyStairMemberPresentationlayer
         addIfcBuildingStoreyStairMemberPresentationlayer(final IfcBuildingStoreyStairMemberPresentationlayer ifcBuildingStoreyStairMemberPresentationlayer) {
    getIfcBuildingStoreyStairMemberPresentationlayers().add(ifcBuildingStoreyStairMemberPresentationlayer);
    ifcBuildingStoreyStairMemberPresentationlayer.setIfcBuildingStoreyStairMember(this);

    return ifcBuildingStoreyStairMemberPresentationlayer;
  }

  public IfcBuildingStoreyStairMemberPresentationlayer
         removeIfcBuildingStoreyStairMemberPresentationlayer(final IfcBuildingStoreyStairMemberPresentationlayer ifcBuildingStoreyStairMemberPresentationlayer) {
    getIfcBuildingStoreyStairMemberPresentationlayers().remove(ifcBuildingStoreyStairMemberPresentationlayer);
    ifcBuildingStoreyStairMemberPresentationlayer.setIfcBuildingStoreyStairMember(null);

    return ifcBuildingStoreyStairMemberPresentationlayer;
  }

  public List<IfcBuildingStoreyStairMemberProperty> getIfcBuildingStoreyStairMemberProperties() {
    return this.ifcBuildingStoreyStairMemberProperties;
  }

  public void
         setIfcBuildingStoreyStairMemberProperties(final List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties) {
    this.ifcBuildingStoreyStairMemberProperties = ifcBuildingStoreyStairMemberProperties;
  }

  public IfcBuildingStoreyStairMemberProperty
         addIfcBuildingStoreyStairMemberProperty(final IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
    getIfcBuildingStoreyStairMemberProperties().add(ifcBuildingStoreyStairMemberProperty);
    ifcBuildingStoreyStairMemberProperty.setIfcBuildingStoreyStairMember(this);

    return ifcBuildingStoreyStairMemberProperty;
  }

  public IfcBuildingStoreyStairMemberProperty
         removeIfcBuildingStoreyStairMemberProperty(final IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
    getIfcBuildingStoreyStairMemberProperties().remove(ifcBuildingStoreyStairMemberProperty);
    ifcBuildingStoreyStairMemberProperty.setIfcBuildingStoreyStairMember(null);

    return ifcBuildingStoreyStairMemberProperty;
  }

}
