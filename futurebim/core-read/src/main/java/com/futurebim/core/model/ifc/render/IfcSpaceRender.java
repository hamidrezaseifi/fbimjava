package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcSpaceRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String name;
  // Description="" ObjectPlacement="1 0 0 0 0 1 0 0 0 0 1 0 0 0 0 1" LongName="Living Room" CompositionType="ELEMENT"
  // InteriorOrExteriorSpace="INTERNAL"
  @JacksonXmlProperty(localName = "Description", isAttribute = true)
  private String Description;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "LongName", isAttribute = true)
  private String longName;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "InteriorOrExteriorSpace", isAttribute = true)
  private String interiorOrExteriorSpace;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcFurnishingElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcFurnishingElementRender> furnishingElementList;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList;

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getObjectPlacement() {
    return objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(final String description) {
    Description = description;
  }

  public String getLongName() {
    return longName;
  }

  public void setLongName(final String longName) {
    this.longName = longName;
  }

  public String getCompositionType() {
    return compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public String getInteriorOrExteriorSpace() {
    return interiorOrExteriorSpace;
  }

  public void setInteriorOrExteriorSpace(final String interiorOrExteriorSpace) {
    this.interiorOrExteriorSpace = interiorOrExteriorSpace;
  }

  public List<IfcPropertySetRender> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<IfcPropertySetRender> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public List<IfcPresentationLayerAssignmentSet> getPresentationLayerAssignmentList() {
    return presentationLayerAssignmentList;
  }

  public void setPresentationLayerAssignmentList(final List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList) {
    this.presentationLayerAssignmentList = presentationLayerAssignmentList;
  }

  public List<IfcFurnishingElementRender> getFurnishingElementList() {
    return furnishingElementList;
  }

  public void setFurnishingElementList(final List<IfcFurnishingElementRender> furnishingElementList) {
    this.furnishingElementList = furnishingElementList;
  }

}
