package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStair;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairMember;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairMemberPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyStairMemberProperty;

public class IfcStairMemberRender {

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

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  public IfcBuildingStoreyStairMember toModel(final IfcBuildingStoreyStair model) {

    final IfcBuildingStoreyStairMember p = new IfcBuildingStoreyStairMember();
    p.setGuid(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setMemberName(name);
    p.setIfcBuildingStoreyStair(model);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyStairMemberProperty(new IfcBuildingStoreyStairMemberProperty(prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender prop : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyStairMemberPresentationlayer(new IfcBuildingStoreyStairMemberPresentationlayer(prop.getPropertyId()));
    }

    return p;
  }

}
