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
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
@Entity
@Table(name = "ifc_furnituretypes")
public class IfcFurnituretype extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "assembly_place")
  private String assemblyPlace;

  private Timestamp created;

  @Column(name = "element_type")
  private String elementType;

  private short status;

  private String tag;

  @Column(name = "type_name")
  private String typeName;

  private Timestamp updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementFurnituretype
  @OneToMany(mappedBy = "ifcFurnituretype")
  private List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes;

  // bi-directional many-to-one association to ProjectIfc
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcFurnituretype() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getAssemblyPlace() {
    return this.assemblyPlace;
  }

  public void setAssemblyPlace(final String assemblyPlace) {
    this.assemblyPlace = assemblyPlace;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getElementType() {
    return this.elementType;
  }

  public void setElementType(final String elementType) {
    this.elementType = elementType;
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

  public String getTypeName() {
    return this.typeName;
  }

  public void setTypeName(final String typeName) {
    this.typeName = typeName;
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

  public List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> getIfcBuildingStoreySpaceFurnishingelementFurnituretypes() {
    return this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementFurnituretypes(final List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes) {
    this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes = ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
  }

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype
         addIfcBuildingStoreySpaceFurnishingelementFurnituretype(final IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
    getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().add(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
    ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcFurnituretype(this);

    return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
  }

  public IfcBuildingStoreySpaceFurnishingelementFurnituretype
         removeIfcBuildingStoreySpaceFurnishingelementFurnituretype(final IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
    getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().remove(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
    ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcFurnituretype(null);

    return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
  }

  public ProjectIfc getProjectIfc() {
    return this.projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

}
