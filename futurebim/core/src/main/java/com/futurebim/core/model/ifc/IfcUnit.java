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

import com.futurebim.common.model.edo.ifc.IfcUnitEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@Entity
@Table(name = "ifc_units")
public class IfcUnit extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime created;

  private String equivalent;

  private short status = 1;

  @Column(name = "unit_name")
  private String unitName;

  @Column(name = "unit_type")
  private String unitType;

  private LocalDateTime updated;

  private int version = 1;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcUnit() {
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

  public String getEquivalent() {
    return this.equivalent;
  }

  public void setEquivalent(final String equivalent) {
    this.equivalent = equivalent;
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
    return projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

  public IfcUnitEdo toEdo() {
    final IfcUnitEdo edo = new IfcUnitEdo();
    edo.setEquivalent(equivalent);
    edo.setUnitName(unitName);
    edo.setUnitType(unitType);

    return edo;
  }

}
