package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcDoorstyleEdo;

/**
 * The persistent class for the ifc_doorstyle database table.
 *
 */
public class GuiIfcDoorstyle {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String typeName;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  @JsonProperty(value = "Tag")
  private String tag;

  @JacksonXmlProperty(localName = "ConstructionType", isAttribute = true)
  @JsonProperty(value = "ConstructionType")
  private String constructionType;

  @JacksonXmlProperty(localName = "OperationType", isAttribute = true)
  @JsonProperty(value = "OperationType")
  private String operationType;

  @JacksonXmlProperty(localName = "ParameterTakesPrecedence", isAttribute = true)
  @JsonProperty(value = "ParameterTakesPrecedence")
  private String parameterTakesPrecedence;

  @JacksonXmlProperty(localName = "Sizeable", isAttribute = true)
  @JsonProperty(value = "Sizeable")
  private String sizeable;

  private final String type = "IfcDoorstyle";

  private final List children = new ArrayList<>();


  public GuiIfcDoorstyle(final IfcDoorstyleEdo edo){
    this.setConstructionType(edo.getConstructionType());
    this.setId(edo.getId());
    this.setOperationType(edo.getOperationType());
    this.setParameterTakesPrecedence(edo.getParameterTakesPrecedence());
    this.setSizeable(edo.getSizeable());
    this.setTag(edo.getTag());
    this.setTypeName(edo.getTypeName());
    
  }

  
  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
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

  public String getType() {
    return type;
  }
  
  public List getChildren() {
    return children;
  }

}
