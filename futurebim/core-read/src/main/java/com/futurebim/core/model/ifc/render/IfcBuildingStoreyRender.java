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

  public IfcBuildingStorey toModel(final IfcBuilding model) {

    final IfcBuildingStorey p = new IfcBuildingStorey();
    p.setId(id);
    p.setCompositionType(compositionType);
    p.setObjectPlacement(objectPlacement);
    p.setElevation(elevation);
    p.setIfcBuilding(model);
    p.setBuildingId(model.getId());
    p.setStoreyName(storeyName);

    /*
     * for (final IfcBuildingStoreyRender buildingStorey : buildingStoreyList) { p.addIfcBuildingStorey(buildingStorey.toModel(p)); //
     * p.addIfcBuildings(building.toModel(p)); }
     */

    return p;
  }
}
