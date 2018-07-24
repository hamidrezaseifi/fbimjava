package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcPresentationLayerAssignmentSetEdo;
import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.common.model.edo.ifc.IfcStairEdo;
import com.futurebim.common.model.edo.ifc.IfcStairFlightEdo;
import com.futurebim.common.model.edo.ifc.IfcStairMemberEdo;
import com.futurebim.common.model.edo.ifc.IfcStairRailingEdo;

public class GuiIfcStair {

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

  @JacksonXmlProperty(localName = "ShapeType", isAttribute = true)
  @JsonProperty(value = "ShapeType")
  private String shapeType;

  @JacksonXmlProperty(localName = "IfcStairFlight")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcStairFlight> stairFlightList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcMember")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcStairMember> memberList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRailing")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcStairRailing> railingList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JsonIgnore
  @JsonProperty(value = "IfcPresentationLayerAssignment")
  private List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  private final String type = "IfcStair";
  
  public GuiIfcStair(final IfcStairEdo edo){
    setId(edo.getId());
    setName(edo.getName());
    setObjectPlacement(edo.getObjectPlacement());
    setObjectType(edo.getObjectType());
    setTag(edo.getTag());
    setShapeType(edo.getShapeType());

    for(final IfcStairFlightEdo item: edo.getStairFlightList()){
      addStairFlight(new GuiIfcStairFlight(item));
    }

    for(final IfcStairMemberEdo item: edo.getMemberList()){
      addMember(new GuiIfcStairMember(item));
    }

    for(final IfcStairRailingEdo item: edo.getRailingList()){
      addRailing(new GuiIfcStairRailing(item));
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

  public String getShapeType() {
    return shapeType;
  }

  public void setShapeType(final String shapeType) {
    this.shapeType = shapeType;
  }

  public List<GuiIfcStairFlight> getStairFlightList() {
    return stairFlightList;
  }

  public void setStairFlightList(final List<GuiIfcStairFlight> stairFlightList) {
    this.stairFlightList = stairFlightList;
  }

  public void addStairFlight(final GuiIfcStairFlight stairFlight) {
    this.stairFlightList.add(stairFlight);
  }

  public List<GuiIfcStairMember> getMemberList() {
    return memberList;
  }

  public void setMemberList(final List<GuiIfcStairMember> memberList) {
    this.memberList = memberList;
  }

  public void addMember(final GuiIfcStairMember member) {
    this.memberList.add(member);
  }

  public List<GuiIfcStairRailing> getRailingList() {
    return railingList;
  }

  public void setRailingList(final List<GuiIfcStairRailing> railingList) {
    this.railingList = railingList;
  }

  public void addRailing(final GuiIfcStairRailing railing) {
    this.railingList.add(railing);
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

  public String getType() {
    return type;
  }

  public List<Object> getChildren() {

    final List<Object> children = new ArrayList<>();
    
    children.addAll(stairFlightList);
    children.addAll(memberList);
    children.addAll(railingList);
    children.addAll(presentationLayerAssignmentList);
    children.addAll(propertySetList);

    return children;
  }

}
