package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcWindowstyle;

/**
 * The persistent class for the ifc_windowstyle database table.
 *
 */
public class IfcWindowstyleRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String typeName;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  private String tag;

  @JacksonXmlProperty(localName = "ConstructionType", isAttribute = true)
  private String constructionType;

  @JacksonXmlProperty(localName = "OperationType", isAttribute = true)
  private String operationType;

  @JacksonXmlProperty(localName = "ParameterTakesPrecedence", isAttribute = true)
  private String parameterTakesPrecedence;

  @JacksonXmlProperty(localName = "Sizeable", isAttribute = true)
  private String sizeable;

  public IfcWindowstyleRender() {
  }

  public IfcWindowstyleRender(final IfcWindowstyle model) {
    setId(model.getId());
    setConstructionType(model.getConstructionType());
    setOperationType(model.getOperationType());
    setParameterTakesPrecedence(model.getParameterTakesPrecedence());
    setSizeable(model.getSizeable());
    setTag(model.getTag());
    setTypeName(model.getTypeName());
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getConstructionType() {
    return constructionType;
  }

  public void setConstructionType(final String constructionType) {
    this.constructionType = constructionType;
  }

  public String getOperationType() {
    return operationType;
  }

  public void setOperationType(final String operationType) {
    this.operationType = operationType;
  }

  public String getParameterTakesPrecedence() {
    return parameterTakesPrecedence;
  }

  public void setParameterTakesPrecedence(final String parameterTakesPrecedence) {
    this.parameterTakesPrecedence = parameterTakesPrecedence;
  }

  public String getSizeable() {
    return sizeable;
  }

  public void setSizeable(final String sizeable) {
    this.sizeable = sizeable;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }

}
