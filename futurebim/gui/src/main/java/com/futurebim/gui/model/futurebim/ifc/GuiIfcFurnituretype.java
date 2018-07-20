package com.futurebim.gui.model.futurebim.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class GuiIfcFurnituretype {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String typeName;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  private String tag;

  @JacksonXmlProperty(localName = "ElementType", isAttribute = true)
  private String elementType;

  @JacksonXmlProperty(localName = "AssemblyPlace", isAttribute = true)
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
