package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcBuildingStoreyEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String storeyName;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "Elevation", isAttribute = true)
  private String elevation;

  @JacksonXmlProperty(localName = "IfcWallStandardCase")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWallStandardCaseEdo> wallStandardCaseList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWallEdo> wallList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcFootingEdo> footingList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcRoofEdo> roofList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcSlabEdo> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWindowEdo> windowList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcDoorEdo> doorList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcStairEdo> stairList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcCoveringEdo> coveringList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcBeamEdo> beamList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcSpaceEdo> spaceList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getStoreyName() {
    return storeyName;
  }

  public void setStoreyName(final String storeyName) {
    this.storeyName = storeyName;
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

  public List<IfcWallStandardCaseEdo> getWallStandardCaseList() {
    return wallStandardCaseList;
  }

  public void setWallStandardCaseList(final List<IfcWallStandardCaseEdo> wallStandardCaseList) {
    this.wallStandardCaseList = wallStandardCaseList;
  }

  public void addWallStandardCase(final IfcWallStandardCaseEdo wallStandardCase) {
    this.wallStandardCaseList.add(wallStandardCase);
  }

  public List<IfcWallEdo> getWallList() {
    return wallList;
  }

  public void setWallList(final List<IfcWallEdo> wallList) {
    this.wallList = wallList;
  }

  public void addWall(final IfcWallEdo wall) {
    this.wallList.add(wall);
  }

  public List<IfcFootingEdo> getFootingList() {
    return footingList;
  }

  public void setFootingList(final List<IfcFootingEdo> footingList) {
    this.footingList = footingList;
  }

  public void addFooting(final IfcFootingEdo footing) {
    this.footingList.add(footing);
  }

  public List<IfcRoofEdo> getRoofList() {
    return roofList;
  }

  public void setRoofList(final List<IfcRoofEdo> roofList) {
    this.roofList = roofList;
  }

  public void addRoofList(final IfcRoofEdo roof) {
    this.roofList.add(roof);
  }

  public List<IfcSlabEdo> getSlabList() {
    return slabList;
  }

  public void setSlabList(final List<IfcSlabEdo> slabList) {
    this.slabList = slabList;
  }

  public void addSlab(final IfcSlabEdo slab) {
    this.slabList.add(slab);
  }

  public List<IfcWindowEdo> getWindowList() {
    return windowList;
  }

  public void setWindowList(final List<IfcWindowEdo> windowList) {
    this.windowList = windowList;
  }

  public void addWindow(final IfcWindowEdo window) {
    this.windowList.add(window);
  }

  public List<IfcDoorEdo> getDoorList() {
    return doorList;
  }

  public void setDoorList(final List<IfcDoorEdo> doorList) {
    this.doorList = doorList;
  }

  public void addDoor(final IfcDoorEdo door) {
    this.doorList.add(door);
  }

  public List<IfcStairEdo> getStairList() {
    return stairList;
  }

  public void setStairList(final List<IfcStairEdo> stairList) {
    this.stairList = stairList;
  }

  public void addStair(final IfcStairEdo stair) {
    this.stairList.add(stair);
  }

  public List<IfcCoveringEdo> getCoveringList() {
    return coveringList;
  }

  public void setCoveringList(final List<IfcCoveringEdo> coveringList) {
    this.coveringList = coveringList;
  }

  public void addCovering(final IfcCoveringEdo covering) {
    this.coveringList.add(covering);
  }

  public List<IfcBeamEdo> getBeamList() {
    return beamList;
  }

  public void setBeamList(final List<IfcBeamEdo> beamList) {
    this.beamList = beamList;
  }

  public void addBeam(final IfcBeamEdo beam) {
    this.beamList.add(beam);
  }

  public List<IfcSpaceEdo> getSpaceList() {
    return spaceList;
  }

  public void setSpaceList(final List<IfcSpaceEdo> spaceList) {
    this.spaceList = spaceList;
  }

  public void addSpace(final IfcSpaceEdo space) {
    this.spaceList.add(space);
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

}
