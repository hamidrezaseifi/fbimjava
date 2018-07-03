package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_properties database table.
 *
 */
@Entity
@Table(name = "ifc_properties")
@JacksonXmlRootElement()
public class IfcProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "ifc_id")
  private String ifcId;

  private Timestamp created;

  @JacksonXmlProperty(localName = "Name")
  @Column(name = "property_name")
  private String propertyName;

  private short status = 1;

  private Timestamp updated;

  private int version = 1;

  // @JacksonXmlElementWrapper(localName = "IfcPropertySet")
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "ifcProperty", cascade = CascadeType.ALL)
  private List<IfcPropertySingleValue> ifcPropertySingleValue = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id", insertable = false, updatable = false)
  private ProjectIfc projectIfc;

  public IfcProperty() {
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

  public String getPropertyName() {
    return this.propertyName;
  }

  public void setPropertyName(final String propertyName) {
    this.propertyName = propertyName;
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

  public List<IfcPropertySingleValue> getIfcPropertiesValues() {
    return this.ifcPropertySingleValue;
  }

  public void setIfcPropertiesValues(final List<IfcPropertySingleValue> ifcPropertiesValues) {
    this.ifcPropertySingleValue = ifcPropertiesValues;
  }

  public void addIfcPropertiesValues(final IfcPropertySingleValue ifcPropertiesValue) {
    this.ifcPropertySingleValue.add(ifcPropertiesValue);
  }

  public String getIfcId() {
    return ifcId;
  }

  public void setIfcId(final String ifcId) {
    this.ifcId = ifcId;
  }

  public ProjectIfc getProjectIfc() {
    return projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

}
