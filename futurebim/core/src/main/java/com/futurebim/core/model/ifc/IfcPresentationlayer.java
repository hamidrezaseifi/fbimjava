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
 * The persistent class for the ifc_presentationlayers database table.
 *
 */
@Entity
@Table(name = "ifc_presentationlayers")
public class IfcPresentationlayer extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "layer_name")
  private String layerName;

  private short status;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStoreyBeamPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyDoorPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyDoorPresentationlayer> ifcBuildingStoreyDoorPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreySlabPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreySpacePresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlightPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMemberPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyStairMemberPresentationlayer> ifcBuildingStoreyStairMemberPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyStairRailingPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyStairRailingPresentationlayer> ifcBuildingStoreyStairRailingPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyWallOpeningPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyWallPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers;

  // bi-directional many-to-one association to IfcBuildingStoreyWindowPresentationlayer
  @OneToMany(mappedBy = "ifcPresentationlayer")
  private List<IfcBuildingStoreyWindowPresentationlayer> ifcBuildingStoreyWindowPresentationlayers;

  // bi-directional many-to-one association to ProjectIfc
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcPresentationlayer() {
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

  public String getLayerName() {
    return this.layerName;
  }

  public void setLayerName(final String layerName) {
    this.layerName = layerName;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
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

  public List<IfcBuildingStoreyBeamPresentationlayer> getIfcBuildingStoreyBeamPresentationlayers() {
    return this.ifcBuildingStoreyBeamPresentationlayers;
  }

  public void
         setIfcBuildingStoreyBeamPresentationlayers(final List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers) {
    this.ifcBuildingStoreyBeamPresentationlayers = ifcBuildingStoreyBeamPresentationlayers;
  }

  public IfcBuildingStoreyBeamPresentationlayer
         addIfcBuildingStoreyBeamPresentationlayer(final IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
    getIfcBuildingStoreyBeamPresentationlayers().add(ifcBuildingStoreyBeamPresentationlayer);
    ifcBuildingStoreyBeamPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyBeamPresentationlayer;
  }

  public IfcBuildingStoreyBeamPresentationlayer
         removeIfcBuildingStoreyBeamPresentationlayer(final IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
    getIfcBuildingStoreyBeamPresentationlayers().remove(ifcBuildingStoreyBeamPresentationlayer);
    ifcBuildingStoreyBeamPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyBeamPresentationlayer;
  }

  public List<IfcBuildingStoreyCoveringPresentationlayer> getIfcBuildingStoreyCoveringPresentationlayers() {
    return this.ifcBuildingStoreyCoveringPresentationlayers;
  }

  public void
         setIfcBuildingStoreyCoveringPresentationlayers(final List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers) {
    this.ifcBuildingStoreyCoveringPresentationlayers = ifcBuildingStoreyCoveringPresentationlayers;
  }

  public IfcBuildingStoreyCoveringPresentationlayer
         addIfcBuildingStoreyCoveringPresentationlayer(final IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
    getIfcBuildingStoreyCoveringPresentationlayers().add(ifcBuildingStoreyCoveringPresentationlayer);
    ifcBuildingStoreyCoveringPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyCoveringPresentationlayer;
  }

  public IfcBuildingStoreyCoveringPresentationlayer
         removeIfcBuildingStoreyCoveringPresentationlayer(final IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
    getIfcBuildingStoreyCoveringPresentationlayers().remove(ifcBuildingStoreyCoveringPresentationlayer);
    ifcBuildingStoreyCoveringPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyCoveringPresentationlayer;
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
    ifcBuildingStoreyDoorPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyDoorPresentationlayer;
  }

  public IfcBuildingStoreyDoorPresentationlayer
         removeIfcBuildingStoreyDoorPresentationlayer(final IfcBuildingStoreyDoorPresentationlayer ifcBuildingStoreyDoorPresentationlayer) {
    getIfcBuildingStoreyDoorPresentationlayers().remove(ifcBuildingStoreyDoorPresentationlayer);
    ifcBuildingStoreyDoorPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyDoorPresentationlayer;
  }

  public List<IfcBuildingStoreySlabPresentationlayer> getIfcBuildingStoreySlabPresentationlayers() {
    return this.ifcBuildingStoreySlabPresentationlayers;
  }

  public void
         setIfcBuildingStoreySlabPresentationlayers(final List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers) {
    this.ifcBuildingStoreySlabPresentationlayers = ifcBuildingStoreySlabPresentationlayers;
  }

  public IfcBuildingStoreySlabPresentationlayer
         addIfcBuildingStoreySlabPresentationlayer(final IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
    getIfcBuildingStoreySlabPresentationlayers().add(ifcBuildingStoreySlabPresentationlayer);
    ifcBuildingStoreySlabPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreySlabPresentationlayer;
  }

  public IfcBuildingStoreySlabPresentationlayer
         removeIfcBuildingStoreySlabPresentationlayer(final IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
    getIfcBuildingStoreySlabPresentationlayers().remove(ifcBuildingStoreySlabPresentationlayer);
    ifcBuildingStoreySlabPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreySlabPresentationlayer;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> getIfcBuildingStoreySpaceFurnishingelementPresentationlayers() {
    return this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementPresentationlayers(final List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers) {
    this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers = ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
  }

  public IfcBuildingStoreySpaceFurnishingelementPresentationlayer
         addIfcBuildingStoreySpaceFurnishingelementPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
    getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().add(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
    ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
  }

  public IfcBuildingStoreySpaceFurnishingelementPresentationlayer
         removeIfcBuildingStoreySpaceFurnishingelementPresentationlayer(final IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
    getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().remove(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
    ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
  }

  public List<IfcBuildingStoreySpacePresentationlayer> getIfcBuildingStoreySpacePresentationlayers() {
    return this.ifcBuildingStoreySpacePresentationlayers;
  }

  public void
         setIfcBuildingStoreySpacePresentationlayers(final List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers) {
    this.ifcBuildingStoreySpacePresentationlayers = ifcBuildingStoreySpacePresentationlayers;
  }

  public IfcBuildingStoreySpacePresentationlayer
         addIfcBuildingStoreySpacePresentationlayer(final IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
    getIfcBuildingStoreySpacePresentationlayers().add(ifcBuildingStoreySpacePresentationlayer);
    ifcBuildingStoreySpacePresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreySpacePresentationlayer;
  }

  public IfcBuildingStoreySpacePresentationlayer
         removeIfcBuildingStoreySpacePresentationlayer(final IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
    getIfcBuildingStoreySpacePresentationlayers().remove(ifcBuildingStoreySpacePresentationlayer);
    ifcBuildingStoreySpacePresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreySpacePresentationlayer;
  }

  public List<IfcBuildingStoreyStairFlightPresentationlayer> getIfcBuildingStoreyStairFlightPresentationlayers() {
    return this.ifcBuildingStoreyStairFlightPresentationlayers;
  }

  public void
         setIfcBuildingStoreyStairFlightPresentationlayers(final List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers) {
    this.ifcBuildingStoreyStairFlightPresentationlayers = ifcBuildingStoreyStairFlightPresentationlayers;
  }

  public IfcBuildingStoreyStairFlightPresentationlayer
         addIfcBuildingStoreyStairFlightPresentationlayer(final IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
    getIfcBuildingStoreyStairFlightPresentationlayers().add(ifcBuildingStoreyStairFlightPresentationlayer);
    ifcBuildingStoreyStairFlightPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyStairFlightPresentationlayer;
  }

  public IfcBuildingStoreyStairFlightPresentationlayer
         removeIfcBuildingStoreyStairFlightPresentationlayer(final IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
    getIfcBuildingStoreyStairFlightPresentationlayers().remove(ifcBuildingStoreyStairFlightPresentationlayer);
    ifcBuildingStoreyStairFlightPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyStairFlightPresentationlayer;
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
    ifcBuildingStoreyStairMemberPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyStairMemberPresentationlayer;
  }

  public IfcBuildingStoreyStairMemberPresentationlayer
         removeIfcBuildingStoreyStairMemberPresentationlayer(final IfcBuildingStoreyStairMemberPresentationlayer ifcBuildingStoreyStairMemberPresentationlayer) {
    getIfcBuildingStoreyStairMemberPresentationlayers().remove(ifcBuildingStoreyStairMemberPresentationlayer);
    ifcBuildingStoreyStairMemberPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyStairMemberPresentationlayer;
  }

  public List<IfcBuildingStoreyStairRailingPresentationlayer> getIfcBuildingStoreyStairRailingPresentationlayers() {
    return this.ifcBuildingStoreyStairRailingPresentationlayers;
  }

  public void
         setIfcBuildingStoreyStairRailingPresentationlayers(final List<IfcBuildingStoreyStairRailingPresentationlayer> ifcBuildingStoreyStairRailingPresentationlayers) {
    this.ifcBuildingStoreyStairRailingPresentationlayers = ifcBuildingStoreyStairRailingPresentationlayers;
  }

  public IfcBuildingStoreyStairRailingPresentationlayer
         addIfcBuildingStoreyStairRailingPresentationlayer(final IfcBuildingStoreyStairRailingPresentationlayer ifcBuildingStoreyStairRailingPresentationlayer) {
    getIfcBuildingStoreyStairRailingPresentationlayers().add(ifcBuildingStoreyStairRailingPresentationlayer);
    ifcBuildingStoreyStairRailingPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyStairRailingPresentationlayer;
  }

  public IfcBuildingStoreyStairRailingPresentationlayer
         removeIfcBuildingStoreyStairRailingPresentationlayer(final IfcBuildingStoreyStairRailingPresentationlayer ifcBuildingStoreyStairRailingPresentationlayer) {
    getIfcBuildingStoreyStairRailingPresentationlayers().remove(ifcBuildingStoreyStairRailingPresentationlayer);
    ifcBuildingStoreyStairRailingPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyStairRailingPresentationlayer;
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
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

  public IfcBuildingStoreyWallOpeningPresentationlayer
         removeIfcBuildingStoreyWallOpeningPresentationlayer(final IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
    getIfcBuildingStoreyWallOpeningPresentationlayers().remove(ifcBuildingStoreyWallOpeningPresentationlayer);
    ifcBuildingStoreyWallOpeningPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyWallOpeningPresentationlayer;
  }

  public List<IfcBuildingStoreyWallPresentationlayer> getIfcBuildingStoreyWallPresentationlayers() {
    return this.ifcBuildingStoreyWallPresentationlayers;
  }

  public void
         setIfcBuildingStoreyWallPresentationlayers(final List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers) {
    this.ifcBuildingStoreyWallPresentationlayers = ifcBuildingStoreyWallPresentationlayers;
  }

  public IfcBuildingStoreyWallPresentationlayer
         addIfcBuildingStoreyWallPresentationlayer(final IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
    getIfcBuildingStoreyWallPresentationlayers().add(ifcBuildingStoreyWallPresentationlayer);
    ifcBuildingStoreyWallPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyWallPresentationlayer;
  }

  public IfcBuildingStoreyWallPresentationlayer
         removeIfcBuildingStoreyWallPresentationlayer(final IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
    getIfcBuildingStoreyWallPresentationlayers().remove(ifcBuildingStoreyWallPresentationlayer);
    ifcBuildingStoreyWallPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyWallPresentationlayer;
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
    ifcBuildingStoreyWindowPresentationlayer.setIfcPresentationlayer(this);

    return ifcBuildingStoreyWindowPresentationlayer;
  }

  public IfcBuildingStoreyWindowPresentationlayer
         removeIfcBuildingStoreyWindowPresentationlayer(final IfcBuildingStoreyWindowPresentationlayer ifcBuildingStoreyWindowPresentationlayer) {
    getIfcBuildingStoreyWindowPresentationlayers().remove(ifcBuildingStoreyWindowPresentationlayer);
    ifcBuildingStoreyWindowPresentationlayer.setIfcPresentationlayer(null);

    return ifcBuildingStoreyWindowPresentationlayer;
  }

  public ProjectIfc getProjectIfc() {
    return this.projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

}
