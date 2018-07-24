package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcFurnituretypeEdo;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class GuiIfcFurnituretype {
  
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
  
  private final String type = "IfcFurnituretype";
  
  private final List children = new ArrayList<>();
  
  public GuiIfcFurnituretype(final IfcFurnituretypeEdo edo){
    this.setElementType(edo.getElementType());
    this.setId(edo.getId());
    this.setAssemblyPlace(edo.getAssemblyPlace());
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

  public String getType() {
    return type;
  }
  
  public List getChildren() {
    return children;
  }
  
}
