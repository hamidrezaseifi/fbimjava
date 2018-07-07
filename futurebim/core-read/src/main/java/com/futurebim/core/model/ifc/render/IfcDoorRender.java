package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyDoor;
import com.futurebim.core.model.ifc.IfcBuildingStoreyDoorPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyDoorProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyDoorStyle;

public class IfcDoorRender {

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

  @JacksonXmlProperty(localName = "OverallHeight", isAttribute = true)
  private String overallHeight;

  @JacksonXmlProperty(localName = "OverallWidth", isAttribute = true)
  private String overallWidth;

  // @JacksonXmlProperty(localName = "IfcOpeningElement")
  // @JacksonXmlElementWrapper(useWrapping = false)
  // private List<Object> openingElementList;

  @JacksonXmlProperty(localName = "IfcDoorStyle")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcDoorStyleSet> doorStyleList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreyDoor toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyDoor p = new IfcBuildingStoreyDoor();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setDoorName(name);
    p.setOverallHeight(overallHeight);
    p.setOverallWidth(overallWidth);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyDoorProperty(new IfcBuildingStoreyDoorProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSet prop : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyDoorPresentationlayer(new IfcBuildingStoreyDoorPresentationlayer(id, prop.getPropertyId()));
    }

    for (final IfcDoorStyleSet style : doorStyleList) {
      p.addIfcBuildingStoreyDoorStyle(new IfcBuildingStoreyDoorStyle(id, style.getStyleId()));
    }

    return p;
  }
}
