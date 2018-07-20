package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GuiIfcStairFlight {

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

  @JacksonXmlProperty(localName = "NumberOfRiser", isAttribute = true)
  private String numberOfRiser;

  @JacksonXmlProperty(localName = "NumberOfTreads", isAttribute = true)
  private String numberOfTreads;

  @JacksonXmlProperty(localName = "RiserHeight", isAttribute = true)
  private String riserHeight;

  @JacksonXmlProperty(localName = "TreadLength", isAttribute = true)
  private String treadLength;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

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

  public String getNumberOfRiser() {
    return numberOfRiser;
  }

  public void setNumberOfRiser(final String numberOfRiser) {
    this.numberOfRiser = numberOfRiser;
  }

  public String getNumberOfTreads() {
    return numberOfTreads;
  }

  public void setNumberOfTreads(final String numberOfTreads) {
    this.numberOfTreads = numberOfTreads;
  }

  public String getRiserHeight() {
    return riserHeight;
  }

  public void setRiserHeight(final String riserHeight) {
    this.riserHeight = riserHeight;
  }

  public String getTreadLength() {
    return treadLength;
  }

  public void setTreadLength(final String treadLength) {
    this.treadLength = treadLength;
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

  public List<GuiIfcPropertySet> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<GuiIfcPropertySet> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public void addPropertySet(final GuiIfcPropertySet propertySet) {
    this.propertySetList.add(propertySet);
  }

}
