package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStair;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairRailing;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairRailingPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairRailingProperty;

public class IfcStairRailingRender {

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

  @JacksonXmlProperty(localName = "PredefinedType", isAttribute = true)
  private String predefinedType;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  public IfcBuildingStoreyStairRailing toModel(final IfcBuildingStoreyStair model) {

    final IfcBuildingStoreyStairRailing p = new IfcBuildingStoreyStairRailing();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setRailingName(name);
    p.setIfcBuildingStoreyStair(model);
    p.setPredefinedType(predefinedType);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyStairRailingProperty(new IfcBuildingStoreyStairRailingProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender prop : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyStairRailingPresentationlayer(new IfcBuildingStoreyStairRailingPresentationlayer(id, prop.getPropertyId()));
    }

    return p;
  }

}
