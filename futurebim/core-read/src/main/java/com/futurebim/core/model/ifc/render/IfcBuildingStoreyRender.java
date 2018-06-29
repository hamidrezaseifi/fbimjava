package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcBuildingStoreyRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String siteName;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "Elevation", isAttribute = true)
  private String elevation;

  @JacksonXmlProperty(localName = "IfcWallStandardCase", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> wallStandardCaseList;

  @JacksonXmlProperty(localName = "IfcWall", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> wallList;

  @JacksonXmlProperty(localName = "IfcFooting", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> footingList;

  @JacksonXmlProperty(localName = "IfcRoof", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> roofList;

  @JacksonXmlProperty(localName = "IfcSlab", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> slabList;

  @JacksonXmlProperty(localName = "IfcWindow", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> windowList;

  @JacksonXmlProperty(localName = "IfcDoor", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> doorList;

  @JacksonXmlProperty(localName = "IfcStair", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> stairList;

  @JacksonXmlProperty(localName = "IfcCovering", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> coveringList;

  @JacksonXmlProperty(localName = "IfcBeam", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> beamList;

  @JacksonXmlProperty(localName = "IfcSpace", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> spaceList;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getSiteName() {
    return siteName;
  }

  public void setSiteName(final String siteName) {
    this.siteName = siteName;
  }

  public String getObjectPlacement() {
    return objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getCompositionType() {
    return compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public String getElevation() {
    return elevation;
  }

  public void setElevation(final String elevation) {
    this.elevation = elevation;
  }

  public List<Object> getWallStandardCaseList() {
    return wallStandardCaseList;
  }

  public void setWallStandardCaseList(final List<Object> wallStandardCaseList) {
    this.wallStandardCaseList = wallStandardCaseList;
  }

  public List<Object> getSlabList() {
    return slabList;
  }

  public void setSlabList(final List<Object> slabList) {
    this.slabList = slabList;
  }

  public List<Object> getWindowList() {
    return windowList;
  }

  public void setWindowList(final List<Object> windowList) {
    this.windowList = windowList;
  }

  public List<Object> getDoorList() {
    return doorList;
  }

  public void setDoorList(final List<Object> doorList) {
    this.doorList = doorList;
  }

  public List<Object> getStairList() {
    return stairList;
  }

  public void setStairList(final List<Object> stairList) {
    this.stairList = stairList;
  }

  public List<Object> getCoveringList() {
    return coveringList;
  }

  public void setCoveringList(final List<Object> coveringList) {
    this.coveringList = coveringList;
  }

  public List<Object> getBeamList() {
    return beamList;
  }

  public void setBeamList(final List<Object> beamList) {
    this.beamList = beamList;
  }

  public List<Object> getSpaceList() {
    return spaceList;
  }

  public void setSpaceList(final List<Object> spaceList) {
    this.spaceList = spaceList;
  }

  public List<IfcPropertySetRender> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<IfcPropertySetRender> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public List<Object> getWallList() {
    return wallList;
  }

  public void setWallList(final List<Object> wallList) {
    this.wallList = wallList;
  }

  public List<Object> getFootingList() {
    return footingList;
  }

  public void setFootingList(final List<Object> footingList) {
    this.footingList = footingList;
  }

  public List<Object> getRoofList() {
    return roofList;
  }

  public void setRoofList(final List<Object> roofList) {
    this.roofList = roofList;
  }

}
