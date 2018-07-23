package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class IfcFurnituretypeEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String typeName;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  @JsonProperty(value = "Tag")
  private String tag;

  @JacksonXmlProperty(localName = "ElementType", isAttribute = true)
  @JsonProperty(value = "ElementType")
  private String elementType;

  @JacksonXmlProperty(localName = "AssemblyPlace", isAttribute = true)
  @JsonProperty(value = "AssemblyPlace")
  private String assemblyPlace;

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

  public String getElementType() {
    return elementType;
  }

  public void setElementType(final String elementType) {
    this.elementType = elementType;
  }

  public String getAssemblyPlace() {
    return assemblyPlace;
  }

  public void setAssemblyPlace(final String assemblyPlace) {
    this.assemblyPlace = assemblyPlace;
  }

}
