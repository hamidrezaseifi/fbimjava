package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcBeamEdo;
import com.futurebim.common.model.edo.ifc.IfcBuildingStoreyEdo;
import com.futurebim.common.model.edo.ifc.IfcCoveringEdo;
import com.futurebim.common.model.edo.ifc.IfcDoorEdo;
import com.futurebim.common.model.edo.ifc.IfcFootingEdo;
import com.futurebim.common.model.edo.ifc.IfcPropertySetEdo;
import com.futurebim.common.model.edo.ifc.IfcRoofEdo;
import com.futurebim.common.model.edo.ifc.IfcSlabEdo;
import com.futurebim.common.model.edo.ifc.IfcSpaceEdo;
import com.futurebim.common.model.edo.ifc.IfcStairEdo;
import com.futurebim.common.model.edo.ifc.IfcWallEdo;
import com.futurebim.common.model.edo.ifc.IfcWallStandardCaseEdo;
import com.futurebim.common.model.edo.ifc.IfcWindowEdo;

public class GuiIfcBuildingStorey {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String storeyName;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  @JsonProperty(value = "ObjectPlacement")
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  @JsonProperty(value = "CompositionType")
  private String compositionType;

  @JacksonXmlProperty(localName = "Elevation", isAttribute = true)
  @JsonProperty(value = "Elevation")
  private String elevation;

  @JacksonXmlProperty(localName = "IfcWallStandardCase")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcWallStandardCase> wallStandardCaseList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcWall> wallList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcFooting> footingList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcRoof> roofList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcSlab> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcWindow> windowList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcDoor> doorList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcStair> stairList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcCovering> coveringList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcBeam> beamList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcSpace> spaceList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonIgnore
  private List<GuiIfcPropertySet> propertySetList = new ArrayList<>();

  private final String type = "IfcBuildingStorey";

  public GuiIfcBuildingStorey(final IfcBuildingStoreyEdo edo){
    setId(edo.getId());
    setCompositionType(edo.getCompositionType());
    setObjectPlacement(edo.getObjectPlacement());
    setElevation(edo.getElevation());
    setStoreyName(edo.getStoreyName());

    for(final IfcWallStandardCaseEdo item: edo.getWallStandardCaseList()){
      addWallStandardCase(new GuiIfcWallStandardCase(item));
    }

    for(final IfcWallEdo item: edo.getWallList()){
      addWall(new GuiIfcWall(item));
    }

    for(final IfcFootingEdo item: edo.getFootingList()){
      addFooting(new GuiIfcFooting(item));
    }

    for(final IfcSpaceEdo item: edo.getSpaceList()){
      addSpace(new GuiIfcSpace(item));
    }

    for(final IfcBeamEdo item: edo.getBeamList()){
      addBeam(new GuiIfcBeam(item));
    }

    for(final IfcCoveringEdo item: edo.getCoveringList()){
      addCovering(new GuiIfcCovering(item));
    }

    for(final IfcStairEdo item: edo.getStairList()){
      addStair(new GuiIfcStair(item));
    }

    for(final IfcDoorEdo item: edo.getDoorList()){
      addDoor(new GuiIfcDoor(item));
    }

    for(final IfcWindowEdo item: edo.getWindowList()){
      addWindow(new GuiIfcWindow(item));
    }

    for(final IfcSlabEdo item: edo.getSlabList()){
      addSlab(new GuiIfcSlab(item));
    }

    for(final IfcRoofEdo item: edo.getRoofList()){
      addRoof(new GuiIfcRoof(item));
    }

    for(final IfcPropertySetEdo item: edo.getPropertySetList()){
      this.addPropertySet(new GuiIfcPropertySet(item));
    }
  }

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
  
  public String getType() {
    return type;
  }
  
  public List<Object> getChildren() {
    
    final List<Object> children = new ArrayList<>();

    children.addAll(wallStandardCaseList);
    children.addAll(wallList);
    children.addAll(footingList);
    children.addAll(spaceList);
    children.addAll(beamList);
    children.addAll(coveringList);
    children.addAll(stairList);
    children.addAll(doorList);
    children.addAll(windowList);
    children.addAll(slabList);
    children.addAll(roofList);
    children.addAll(propertySetList);
    
    return children;
  }

}
