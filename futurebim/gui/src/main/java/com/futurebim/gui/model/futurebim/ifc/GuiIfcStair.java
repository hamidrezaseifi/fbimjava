package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GuiIfcStair {

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

  @JacksonXmlProperty(localName = "ShapeType", isAttribute = true)
  private String shapeType;

  @JacksonXmlProperty(localName = "IfcStairFlight")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcStairFlight> stairFlightList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcMember")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcStairMember> memberList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRailing")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcStairRailing> railingList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

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

}
