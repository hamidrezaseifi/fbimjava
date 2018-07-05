package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyFooting;
import com.futurebim.core.model.ifc.IfcBuildingStoreyFootingPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyFootingProperty;

public class IfcFootingRender {

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

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList;

  public IfcBuildingStoreyFooting toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyFooting p = new IfcBuildingStoreyFooting();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setStoreyId(model.getId());
    p.setFootingName(name);
    p.setPredefinedType(predefinedType);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyFootingProperty(new IfcBuildingStoreyFootingProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSet layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyFootingPresentationlayer(new IfcBuildingStoreyFootingPresentationlayer(id, layer.getPropertyId()));
    }

    return p;
  }
}
