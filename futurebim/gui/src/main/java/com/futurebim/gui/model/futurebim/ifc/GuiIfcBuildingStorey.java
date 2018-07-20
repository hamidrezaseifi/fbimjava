package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GuiIfcBuildingStorey {

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
  private List<GuiIfcWallStandardCase> wallStandardCaseList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcWall> wallList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcFooting> footingList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcRoof> roofList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcSlab> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcWindow> windowList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcDoor> doorList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcStair> stairList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcCovering> coveringList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcBeam> beamList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcSpace> spaceList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

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

  public List<GuiIfcWallStandardCase> getWallStandardCaseList() {
    return wallStandardCaseList;
  }

  public void setWallStandardCaseList(final List<GuiIfcWallStandardCase> wallStandardCaseList) {
    this.wallStandardCaseList = wallStandardCaseList;
  }

  public void addWallStandardCase(final GuiIfcWallStandardCase wallStandardCase) {
    this.wallStandardCaseList.add(wallStandardCase);
  }

  public List<GuiIfcWall> getWallList() {
    return wallList;
  }

  public void setWallList(final List<GuiIfcWall> wallList) {
    this.wallList = wallList;
  }

  public void addWall(final GuiIfcWall wall) {
    this.wallList.add(wall);
  }

  public List<GuiIfcFooting> getFootingList() {
    return footingList;
  }

  public void setFootingList(final List<GuiIfcFooting> footingList) {
    this.footingList = footingList;
  }

  public void addFooting(final GuiIfcFooting footing) {
    this.footingList.add(footing);
  }

  public List<GuiIfcRoof> getRoofList() {
    return roofList;
  }

  public void setRoofList(final List<GuiIfcRoof> roofList) {
    this.roofList = roofList;
  }

  public void addRoof(final GuiIfcRoof roof) {
    this.roofList.add(roof);
  }

  public List<GuiIfcSlab> getSlabList() {
    return slabList;
  }

  public void setSlabList(final List<GuiIfcSlab> slabList) {
    this.slabList = slabList;
  }

  public void addSlab(final GuiIfcSlab slab) {
    this.slabList.add(slab);
  }

  public List<GuiIfcWindow> getWindowList() {
    return windowList;
  }

  public void setWindowList(final List<GuiIfcWindow> windowList) {
    this.windowList = windowList;
  }

  public void addWindow(final GuiIfcWindow window) {
    this.windowList.add(window);
  }

  public List<GuiIfcDoor> getDoorList() {
    return doorList;
  }

  public void setDoorList(final List<GuiIfcDoor> doorList) {
    this.doorList = doorList;
  }

  public void addDoor(final GuiIfcDoor door) {
    this.doorList.add(door);
  }

  public List<GuiIfcStair> getStairList() {
    return stairList;
  }

  public void setStairList(final List<GuiIfcStair> stairList) {
    this.stairList = stairList;
  }

  public void addStair(final GuiIfcStair stair) {
    this.stairList.add(stair);
  }

  public List<GuiIfcCovering> getCoveringList() {
    return coveringList;
  }

  public void setCoveringList(final List<GuiIfcCovering> coveringList) {
    this.coveringList = coveringList;
  }

  public void addCovering(final GuiIfcCovering covering) {
    this.coveringList.add(covering);
  }

  public List<GuiIfcBeam> getBeamList() {
    return beamList;
  }

  public void setBeamList(final List<GuiIfcBeam> beamList) {
    this.beamList = beamList;
  }

  public void addBeam(final GuiIfcBeam beam) {
    this.beamList.add(beam);
  }

  public List<GuiIfcSpace> getSpaceList() {
    return spaceList;
  }

  public void setSpaceList(final List<GuiIfcSpace> spaceList) {
    this.spaceList = spaceList;
  }

  public void addSpace(final GuiIfcSpace space) {
    this.spaceList.add(space);
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
