package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcFurnishingElementEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String name;

  @JacksonXmlProperty(localName = "ObjectType", isAttribute = true)
  private String objectType;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  private String tag;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcOpeningElementEdo> openingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcFurnitureTypeSetEdo> furnitureTypeList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPresentationLayerAssignmentSetEdo> presentationLayerAssignmentList = new ArrayList<>();

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

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(final String objectType) {
    this.objectType = objectType;
  }

  public String getObjectPlacement() {
    return objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
  }

  public List<IfcPropertySetEdo> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<IfcPropertySetEdo> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public void addPropertySet(final IfcPropertySetEdo propertySet) {
    this.propertySetList.add(propertySet);
  }

  public List<IfcOpeningElementEdo> getOpeningElementList() {
    return openingElementList;
  }

  public void setOpeningElementList(final List<IfcOpeningElementEdo> openingElementList) {
    this.openingElementList = openingElementList;
  }

  public void addOpeningElement(final IfcOpeningElementEdo openingElement) {
    this.openingElementList.add(openingElement);
  }

  public List<IfcFurnitureTypeSetEdo> getFurnitureTypeList() {
    return furnitureTypeList;
  }

  public void setFurnitureTypeList(final List<IfcFurnitureTypeSetEdo> furnitureTypeList) {
    this.furnitureTypeList = furnitureTypeList;
  }

  public void addFurnitureType(final IfcFurnitureTypeSetEdo furnitureType) {
    this.furnitureTypeList.add(furnitureType);
  }

  public List<IfcPresentationLayerAssignmentSetEdo> getPresentationLayerAssignmentList() {
    return presentationLayerAssignmentList;
  }

  public void setPresentationLayerAssignmentList(final List<IfcPresentationLayerAssignmentSetEdo> presentationLayerAssignmentList) {
    this.presentationLayerAssignmentList = presentationLayerAssignmentList;
  }

  public void addPresentationLayerAssignment(final IfcPresentationLayerAssignmentSetEdo presentationLayerAssignment) {
    this.presentationLayerAssignmentList.add(presentationLayerAssignment);
  }

}
