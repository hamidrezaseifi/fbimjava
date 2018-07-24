package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.common.model.edo.ifc.IfcWindowEdo;
import com.futurebim.common.model.edo.ifc.IfcWindowStyleSetEdo;

public class GuiIfcWindow {
  
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
  
  @JacksonXmlProperty(localName = "OverallHeight", isAttribute = true)
  @JsonProperty(value = "OverallHeight")
  private String overallHeight;
  
  @JacksonXmlProperty(localName = "OverallWidth", isAttribute = true)
  @JsonProperty(value = "OverallWidth")
  private String overallWidth;
  
  @JacksonXmlProperty(localName = "IfcWindowStyle")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcWindowStyleSet> windowStyleSetList = new ArrayList<>();
  
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();
  
  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();
  
  private final String type = "IfcWindow";

  public GuiIfcWindow(final IfcWindowEdo edo){
    setId(edo.getId());
    setName(edo.getName());
    setObjectPlacement(edo.getObjectPlacement());
    setObjectType(edo.getObjectType());
    setTag(edo.getTag());
    setOverallHeight(edo.getOverallHeight());
    setOverallWidth(edo.getOverallWidth());

    
    for(final IfcWindowStyleSetEdo item: edo.getWindowStyleSetList()){
      addWindowStyleSet(new GuiIfcWindowStyleSet(item));
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
  
  public String getOverallHeight() {
    return overallHeight;
  }
  
  public void setOverallHeight(final String overallHeight) {
    this.overallHeight = overallHeight;
  }
  
  public String getOverallWidth() {
    return overallWidth;
  }
  
  public void setOverallWidth(final String overallWidth) {
    this.overallWidth = overallWidth;
  }
  
  public List<GuiIfcWindowStyleSet> getWindowStyleSetList() {
    return windowStyleSetList;
  }
  
  public void setWindowStyleSetList(final List<GuiIfcWindowStyleSet> windowStyleSetList) {
    this.windowStyleSetList = windowStyleSetList;
  }
  
  public void addWindowStyleSet(final GuiIfcWindowStyleSet windowStyleSet) {
    this.windowStyleSetList.add(windowStyleSet);
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
  
  public void setPresentationLayerAssignment(final List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList) {
    this.presentationLayerAssignmentList = presentationLayerAssignmentList;
  }
  
  public void addPresentationLayerAssignment(final GuiIfcPresentationLayerAssignmentSet presentationLayerAssignment) {
    this.presentationLayerAssignmentList.add(presentationLayerAssignment);
  }
  
  public String getType() {
    return type;
  }

  public List<Object> getChildren() {

    final List<Object> children = new ArrayList<>();
    
    children.addAll(windowStyleSetList);
    children.addAll(presentationLayerAssignmentList);
    children.addAll(propertySetList);

    return children;
  }
}
