package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyCovering;
import com.futurebim.core.model.ifc.IfcBuildingStoreyCoveringPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyCoveringProperty;

public class IfcCoveringRender {

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
  private List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList;

  public IfcBuildingStoreyCovering toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyCovering p = new IfcBuildingStoreyCovering();
    p.setGuid(id);
    p.setObjectPlacement(objectPlacement);
    p.setCoveringName(name);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setPredefinedType(predefinedType);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyCoveringProperty(new IfcBuildingStoreyCoveringProperty(prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyCoveringPresentationlayer(new IfcBuildingStoreyCoveringPresentationlayer(layer.getPropertyId()));
    }

    return p;
  }
}
