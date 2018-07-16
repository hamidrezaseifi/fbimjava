package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyBeam;
import com.futurebim.core.model.ifc.IfcBuildingStoreyBeamPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyBeamProperty;

public class IfcBeamRender {

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

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList;

  public IfcBuildingStoreyBeam toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyBeam p = new IfcBuildingStoreyBeam();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setBeamName(name);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setStoreyId(model.getId());

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyBeamProperty(new IfcBuildingStoreyBeamProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyBeamPresentationlayer(new IfcBuildingStoreyBeamPresentationlayer(id, layer.getPropertyId()));
    }

    return p;
  }

}
