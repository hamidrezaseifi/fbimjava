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

  @JacksonXmlProperty(localName = "IfcWallStandardCase")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWallStandardCaseRender> wallStandardCaseList;

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> wallList;

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> footingList;

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Object> roofList;

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcSlabRender> slabList;

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWindowRender> windowList;

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcDoorRender> doorList;

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcStairRender> stairList;

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcCoveringRender> coveringList;

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcBeamRender> beamList;

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcSpaceRender> spaceList;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
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

  public List<IfcWallStandardCaseRender> getWallStandardCaseList() {
    return wallStandardCaseList;
  }

  public void setWallStandardCaseList(final List<IfcWallStandardCaseRender> wallStandardCaseList) {
    this.wallStandardCaseList = wallStandardCaseList;
  }

  public List<IfcSlabRender> getSlabList() {
    return slabList;
  }

  public void setSlabList(final List<IfcSlabRender> slabList) {
    this.slabList = slabList;
  }

  public List<IfcWindowRender> getWindowList() {
    return windowList;
  }

  public void setWindowList(final List<IfcWindowRender> windowList) {
    this.windowList = windowList;
  }

  public List<IfcDoorRender> getDoorList() {
    return doorList;
  }

  public void setDoorList(final List<IfcDoorRender> doorList) {
    this.doorList = doorList;
  }

  public List<IfcStairRender> getStairList() {
    return stairList;
  }

  public void setStairList(final List<IfcStairRender> stairList) {
    this.stairList = stairList;
  }

  public List<IfcCoveringRender> getCoveringList() {
    return coveringList;
  }

  public void setCoveringList(final List<IfcCoveringRender> coveringList) {
    this.coveringList = coveringList;
  }

  public List<IfcBeamRender> getBeamList() {
    return beamList;
  }

  public void setBeamList(final List<IfcBeamRender> beamList) {
    this.beamList = beamList;
  }

  public List<IfcSpaceRender> getSpaceList() {
    return spaceList;
  }

  public void setSpaceList(final List<IfcSpaceRender> spaceList) {
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
