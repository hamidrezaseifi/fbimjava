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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.IfcPropertyValueEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
@Entity
@Table(name = "ifc_properties_value")
@JacksonXmlRootElement(localName = "IfcPropertySingleValue")
public class IfcPropertySingleValue extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "property_id")
  private String propertyId;

  private LocalDateTime created;

  @JacksonXmlProperty(localName = "NominalValue")
  @Column(name = "nominal_value")
  private String nominalValue;

  private short status = 1;

  private LocalDateTime updated;

  @JacksonXmlProperty(localName = "Name")
  @Column(name = "value_name")
  private String valueName;

  private int version = 1;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property_id", insertable = false, updatable = false)
  private IfcProperty ifcProperty;

  public IfcPropertySingleValue() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getNominalValue() {
    return this.nominalValue;
  }

  public void setNominalValue(final String nominalValue) {
    this.nominalValue = nominalValue.length() < 150 ? nominalValue : nominalValue.substring(0, 145);
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
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

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(final String propertyId) {
    this.propertyId = propertyId;
  }

  public IfcPropertyValueEdo toEdo() {
    final IfcPropertyValueEdo edo = new IfcPropertyValueEdo();
    edo.setNominalValue(nominalValue);
    edo.setValueName(valueName);

    return edo;
  }
}
