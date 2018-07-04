package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuilding;
import com.futurebim.core.model.ifc.IfcBuildingStorey;

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
  private List<IfcWallStandardCaseRender> wallStandardCaseList;

  @JacksonXmlProperty(localName = "IfcWall")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcWallRender> wallList;

  @JacksonXmlProperty(localName = "IfcFooting")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcFootingRender> footingList;

  @JacksonXmlProperty(localName = "IfcRoof")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcRoofRender> roofList;

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

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

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
      p.addifc(wall.toModel(p));

    }

    for (final IfcWallRender wall : wallList) {
      // p.addIfcBuildingStoreySpace(wall.toModel(p));

    }

    for (final IfcFootingRender footing : footingList) {
      // p.addIfcBuildingStoreySpace(footing.toModel(p));

    }

    for (final IfcRoofRender roof : roofList) {
      // p.addIfcBuildingStoreySpace(roof.toModel(p));

    }

    for (final IfcSlabRender slab : slabList) {
      // p.addIfcBuildingStoreySpace(slab.toModel(p));

    }

    for (final IfcWindowRender window : windowList) {
      // p.addIfcBuildingStoreySpace(window.toModel(p));

    }

    for (final IfcDoorRender door : doorList) {
      // p.addIfcBuildingStoreySpace(door.toModel(p));

    }

    for (final IfcStairRender stair : stairList) {
      // p.addIfcBuildingStoreySpace(stair.toModel(p));

    }

    for (final IfcCoveringRender cover : coveringList) {
      // p.addIfcBuildingStoreySpace(cover.toModel(p));

    }

    for (final IfcBeamRender beam : beamList) {
      // p.addIfcBuildingStoreySpace(beam.toModel(p));

    }

    for (final IfcSpaceRender space : spaceList) {
      // p.addIfcBuildingStoreySpace(space.toModel(p));

    }

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyProperty(prop.toIfcBuildingStoreyPropertyModel(p));
    }

    return p;
  }
}
