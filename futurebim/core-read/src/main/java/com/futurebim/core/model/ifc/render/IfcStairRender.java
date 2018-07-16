package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStair;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairProperty;

public class IfcStairRender {

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

  @JacksonXmlProperty(localName = "ShapeType", isAttribute = true)
  private String shapeType;

  @JacksonXmlProperty(localName = "IfcStairFlight")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairFlightRender> stairFlightList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcMember")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairMemberRender> memberList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRailing")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairRailingRender> railingList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreyStair toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyStair p = new IfcBuildingStoreyStair();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setIfcBuildingStorey(model);
    p.setStairName(name);
    p.setShapeType(shapeType);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyStairProperty(new IfcBuildingStoreyStairProperty(id, prop.getPropertyId()));
    }

    for (final IfcStairFlightRender prop : stairFlightList) {
      p.addIfcBuildingStoreyStairFlight(prop.toModel(p));
    }

    for (final IfcStairMemberRender prop : memberList) {
      p.addIfcBuildingStoreyStairMember(prop.toModel(p));
    }

    for (final IfcStairRailingRender prop : railingList) {
      p.addIfcBuildingStoreyStairRailing(prop.toModel(p));
    }

    return p;
  }

}
