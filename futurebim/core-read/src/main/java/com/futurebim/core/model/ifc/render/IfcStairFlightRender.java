package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStair;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairFlight;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairFlightPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairFlightProperty;

public class IfcStairFlightRender {

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

  @JacksonXmlProperty(localName = "NumberOfRiser", isAttribute = true)
  private String numberOfRiser;

  @JacksonXmlProperty(localName = "NumberOfTreads", isAttribute = true)
  private String numberOfTreads;

  @JacksonXmlProperty(localName = "RiserHeight", isAttribute = true)
  private String riserHeight;

  @JacksonXmlProperty(localName = "TreadLength", isAttribute = true)
  private String treadLength;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  public IfcBuildingStoreyStairFlight toModel(final IfcBuildingStoreyStair model) {

    final IfcBuildingStoreyStairFlight p = new IfcBuildingStoreyStairFlight();
    p.setGuid(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setFlightName(name);
    p.setIfcBuildingStoreyStair(model);
    p.setNumberOfRiser(numberOfRiser);
    p.setNumberOfTreads(numberOfTreads);
    p.setRiserHeight(riserHeight);
    p.setTreadLength(treadLength);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyStairFlightProperty(new IfcBuildingStoreyStairFlightProperty(prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender prop : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyStairFlightPresentationlayer(new IfcBuildingStoreyStairFlightPresentationlayer(prop.getPropertyId()));
    }

    return p;
  }
}
