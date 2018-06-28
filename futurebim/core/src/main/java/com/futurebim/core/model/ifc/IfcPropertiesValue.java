package com.futurebim.core.model.ifc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
@Entity
@Table(name = "ifc_properties_value")
@NamedQuery(name = "IfcPropertiesValue.findAll", query = "SELECT i FROM IfcPropertiesValue i")
public class IfcPropertiesValue extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "nominal_value")
  private String nominalValue;

  private short status;

  private Timestamp updated;

  @Column(name = "value_name")
  private String valueName;

  private int version;

  // bi-directional many-to-one association to IfcProperty
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property_id")
  private IfcProperty ifcProperty;

  public IfcPropertiesValue() {
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

  public String getNominalValue() {
    return this.nominalValue;
  }

  public void setNominalValue(final String nominalValue) {
    this.nominalValue = nominalValue;
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

  public String getValueName() {
    return this.valueName;
  }

  public void setValueName(final String valueName) {
    this.valueName = valueName;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public IfcProperty getIfcProperty() {
    return this.ifcProperty;
  }

  public void setIfcProperty(final IfcProperty ifcProperty) {
    this.ifcProperty = ifcProperty;
  }

}
