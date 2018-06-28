package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@Entity
@Table(name = "ifc_units")
@NamedQuery(name = "IfcUnit.findAll", query = "SELECT i FROM IfcUnit i")
public class IfcUnit extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  private String equivalent;

  @Column(name = "ifc_id")
  private String ifcId;

  private short status;

  @Column(name = "unit_name")
  private String unitName;

  @Column(name = "unit_type")
  private String unitType;

  private Timestamp updated;

  private int version;

  public IfcUnit() {
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

  public String getEquivalent() {
    return this.equivalent;
  }

  public void setEquivalent(final String equivalent) {
    this.equivalent = equivalent;
  }

  public String getIfcId() {
    return this.ifcId;
  }

  public void setIfcId(final String ifcId) {
    this.ifcId = ifcId;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public String getUnitName() {
    return this.unitName;
  }

  public void setUnitName(final String unitName) {
    this.unitName = unitName;
  }

  public String getUnitType() {
    return this.unitType;
  }

  public void setUnitType(final String unitType) {
    this.unitType = unitType;
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

}
