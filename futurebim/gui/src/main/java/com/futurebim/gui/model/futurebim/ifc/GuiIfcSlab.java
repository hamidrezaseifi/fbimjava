package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcOpeningElementEdo;
import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.common.model.edo.ifc.IfcSlabEdo;

public class GuiIfcSlab {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String name;

  @JacksonXmlProperty(localName = "ObjectType", isAttribute = true)
  @JsonProperty(value = "ObjectType")
  private String objectType;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  @JsonProperty(value = "ObjectPlacement")
  private String objectPlacement;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  @JsonProperty(value = "Tag")
  private String tag;

  @JacksonXmlProperty(localName = "PredefinedType", isAttribute = true)
  @JsonProperty(value = "PredefinedType")
  private String predefinedType;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcOpeningElement> openingElementList = new ArrayList<>();

  private final String type = "IfcSlab";
  
  public GuiIfcSlab(final IfcSlabEdo edo){
    setId(edo.getId());
    setName(edo.getName());
    setObjectPlacement(edo.getObjectPlacement());
    setObjectType(edo.getObjectType());
    setTag(edo.getTag());
    setPredefinedType(edo.getPredefinedType());

    for(final IfcOpeningElementEdo item: edo.getOpeningElementList()){
      addOpeningElement(new GuiIfcOpeningElement(item));
    }

    for(final IfcPropertySetEdo item: edo.getPropertySetList()){
      this.addPropertySet(new GuiIfcPropertySet(item));
    }

    for(final IfcPresentationLayerAssignmentSetEdo item: edo.getPresentationLayerAssignmentList()){
      this.addPresentationLayerAssignment(new GuiIfcPresentationLayerAssignmentSet(item));
    }

  }
  

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

  public String getPredefinedType() {
    return predefinedType;
  }

  public void setPredefinedType(final String predefinedType) {
    this.predefinedType = predefinedType;
  }

  public List<GuiIfcPropertySet> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<GuiIfcPropertySet> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public void addPropertySet(final GuiIfcPropertySet propertySet) {
    this.propertySetList.add(propertySet);
  }

  public List<GuiIfcPresentationLayerAssignmentSet> getPresentationLayerAssignmentList() {
    return presentationLayerAssignmentList;
  }

  public void setPresentationLayerAssignmentList(final List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList) {
    this.presentationLayerAssignmentList = presentationLayerAssignmentList;
  }

  public void addPresentationLayerAssignment(final GuiIfcPresentationLayerAssignmentSet presentationLayerAssignment) {
    this.presentationLayerAssignmentList.add(presentationLayerAssignment);
  }

  public List<GuiIfcOpeningElement> getOpeningElementList() {
    return openingElementList;
  }

  public void setOpeningElementList(final List<GuiIfcOpeningElement> openingElementList) {
    this.openingElementList = openingElementList;
  }

  public void addOpeningElement(final GuiIfcOpeningElement openingElement) {
    this.openingElementList.add(openingElement);
  }

  public String getType() {
    return type;
  }

  public List<Object> getChildren() {

    final List<Object> children = new ArrayList<>();
    
    children.addAll(openingElementList);
    children.addAll(presentationLayerAssignmentList);
    children.addAll(propertySetList);

    return children;
  }

}
