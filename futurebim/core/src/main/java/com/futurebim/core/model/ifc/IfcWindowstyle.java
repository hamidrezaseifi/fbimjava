package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_windowstyle database table.
 *
 */
@Entity
@Table(name = "ifc_windowstyle")
public class IfcWindowstyle extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column(name = "construction_type")
  private String constructionType;

  private LocalDateTime created;

  @Column(name = "operation_type")
  private String operationType;

  @Column(name = "parameter_takes_precedence")
  private String parameterTakesPrecedence;

  private String sizeable;

  private short status = 1;

  private String tag;

  @Column(name = "type_name")
  private String typeName;

  private LocalDateTime updated;

  private int version = 1;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  public IfcWindowstyle() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getConstructionType() {
    return this.constructionType;
  }

  public void setConstructionType(final String constructionType) {
    this.constructionType = constructionType;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getOperationType() {
    return this.operationType;
  }

  public void setOperationType(final String operationType) {
    this.operationType = operationType;
  }

  public String getParameterTakesPrecedence() {
    return this.parameterTakesPrecedence;
  }

  public void setParameterTakesPrecedence(final String parameterTakesPrecedence) {
    this.parameterTakesPrecedence = parameterTakesPrecedence;
  }

  public String getSizeable() {
    return this.sizeable;
  }

  public void setSizeable(final String sizeable) {
    this.sizeable = sizeable;
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
}
