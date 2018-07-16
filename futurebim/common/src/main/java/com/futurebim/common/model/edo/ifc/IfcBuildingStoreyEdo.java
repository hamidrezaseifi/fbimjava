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
  private final List<IfcWallStandardCaseEdo> wallStandardCaseList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcWallEdo> wallList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcFootingEdo> footingList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcRoofEdo> roofList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcSlabEdo> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcWindowEdo> windowList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcDoorEdo> doorList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairEdo> stairList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcCoveringEdo> coveringList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcBeamEdo> beamList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcSpaceEdo> spaceList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

}
