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
 * The persistent class for the ifc_building_storey_wall_opening database table.
 *
 */
@Entity
@Table(name = "ifc_building_storey_wall_opening")
public class IfcBuildingStoreyWallOpening extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "object_placement")
  private String objectPlacement;

  @Column(name = "object_type")
  private String objectType;

  private short status = 1;

  private String tag;

  private Timestamp updated;

  private int version = 1;

  @Column(name = "wall_name")
  private String wallName;

  // bi-directional many-to-one association to IfcBuildingStoreyWall
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wall_id")
  private IfcBuildingStoreyWall ifcBuildingStoreyWall;

  // bi-directional many-to-one association to IfcBuildingStoreyWallOpeningPresentationlayer
  @OneToMany(mappedBy = "ifcBuildingStoreyWallOpening")
  private List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers;

  public IfcBuildingStoreyWallOpening() {
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

  public String getWallName() {
    return this.wallName;
  }

  public void setWallName(final String wallName) {
    this.wallName = wallName;
  }

  public IfcBuildingStoreyWall getIfcBuildingStoreyWall() {
    return this.ifcBuildingStoreyWall;
  }

  public void setIfcBuildingStoreyWall(final IfcBuildingStoreyWall ifcBuildingStoreyWall) {
    this.ifcBuildingStoreyWall = ifcBuildingStoreyWall;
  }

  public List<IfcBuildingStoreyWallOpeningPresentationlayer> getIfcBuildingStoreyWallOpeningPresentationlayers() {
    return this.ifcBuildingStoreyWallOpeningPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallOpeningPresentationlayers(final List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers) {
    this.ifcBuildingStoreyWallOpeningPresentationlayers = ifcBuildingStoreyWallOpeningPresentationlayers;
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer
         addIfcBuildingStoreyWallOpeningPresentationlayer(final IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
    getIfcBuildingStoreyWallOpeningPresentationlayers().add(ifcBuildingStoreyWallOpeningPresentationlayer);
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(this);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer
         removeIfcBuildingStoreyWallOpeningPresentationlayer(final IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
    getIfcBuildingStoreyWallOpeningPresentationlayers().remove(ifcBuildingStoreyWallOpeningPresentationlayer);
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(null);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

}
