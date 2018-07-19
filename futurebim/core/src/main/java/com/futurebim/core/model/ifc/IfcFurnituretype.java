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

import com.futurebim.common.model.edo.ifc.IfcFurnituretypeEdo;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "guid")
  private String guid;

  @Column(name = "assembly_place")
  private String assemblyPlace;

  private LocalDateTime created;

  @Column(name = "element_type")
  private String elementType;

  private short status = 1;

  @Column(name = "type_name")
  private String typeName;

  @Column(name = "tag")
  private String tag;

  private LocalDateTime updated;

  private int version = 1;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcFurnituretype() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(final String guid) {
    this.guid = guid;
  }

  public String getAssemblyPlace() {
    return this.assemblyPlace;
  }

  public void setAssemblyPlace(final String assemblyPlace) {
    this.assemblyPlace = assemblyPlace;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
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

  public String getTypeName() {
    return this.typeName;
  }

  public void setTypeName(final String typeName) {
    this.typeName = typeName;
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

  public ProjectIfc getProjectIfc() {
    return this.projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
  }

  public IfcFurnituretypeEdo toEdo() {
    final IfcFurnituretypeEdo edo = new IfcFurnituretypeEdo();
    edo.setId(guid);
    edo.setTag(tag);
    edo.setTypeName(typeName);
    edo.setAssemblyPlace(assemblyPlace);
    edo.setElementType(elementType);

    return edo;
  }
}
