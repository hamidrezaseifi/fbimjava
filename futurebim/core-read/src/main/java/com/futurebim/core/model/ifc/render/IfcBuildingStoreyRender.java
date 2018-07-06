package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuilding;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyProperty;

public class IfcBuildingStoreyRender {

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
  private final List<IfcWallStandardCaseRender> wallStandardCaseList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcWallRender> wallList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcFootingRender> footingList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcRoofRender> roofList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcSlabRender> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcWindow")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcWindowRender> windowList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcDoor")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcDoorRender> doorList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcStair")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairRender> stairList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcCovering")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcCoveringRender> coveringList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcBeam")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcBeamRender> beamList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcSpace")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcSpaceRender> spaceList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  public IfcBuildingStorey toModel(final IfcBuilding model) {

    final IfcBuildingStorey p = new IfcBuildingStorey();
    p.setId(id);
    p.setCompositionType(compositionType);
    p.setObjectPlacement(objectPlacement);
    p.setElevation(elevation);
    p.setIfcBuilding(model);
    p.setBuildingId(model.getId());
    p.setStoreyName(storeyName);

    for (final IfcWallStandardCaseRender wall : wallStandardCaseList) {
      p.addIfcBuildingStoreyWallCase(wall.toModel(p));
    }

    for (final IfcWallRender wall : wallList) {
      p.addIfcBuildingStoreyWall(wall.toModel(p));
    }

    for (final IfcFootingRender footing : footingList) {
      p.addIfcBuildingStoreyFooting(footing.toModel(p));
    }

    for (final IfcRoofRender roof : roofList) {

    }

    for (final IfcSlabRender slab : slabList) {
      p.addIfcBuildingStoreySlab(slab.toModel(p));

    }

    for (final IfcWindowRender window : windowList) {
      p.addIfcBuildingStoreyWindow(window.toModel(p));

    }

    for (final IfcDoorRender door : doorList) {

    }

    for (final IfcStairRender stair : stairList) {

      p.addIfcBuildingStoreyStair(stair.toModel(p));
    }

    for (final IfcCoveringRender cover : coveringList) {
      p.addIfcBuildingStoreyCovering(cover.toModel(p));
    }

    for (final IfcBeamRender beam : beamList) {
      p.addIfcBuildingStoreyBeam(beam.toModel(p));
    }

    for (final IfcSpaceRender space : spaceList) {
      p.addIfcBuildingStoreySpace(space.toModel(p));

    }

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyProperty(new IfcBuildingStoreyProperty(id, prop.getPropertyId()));
    }

    return p;
  }
}
