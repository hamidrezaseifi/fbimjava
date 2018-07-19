package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpace;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpacePresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceProperty;

public class IfcSpaceRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String name;

  @JacksonXmlProperty(localName = "Description", isAttribute = true)
  private String description;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "LongName", isAttribute = true)
  private String longName;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "InteriorOrExteriorSpace", isAttribute = true)
  private String interiorOrExteriorSpace;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcFurnishingElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcFurnishingElementRender> furnishingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreySpace toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreySpace p = new IfcBuildingStoreySpace();
    p.setGuid(id);
    p.setCompositionType(compositionType);
    p.setObjectPlacement(objectPlacement);
    p.setDescription(description);
    p.setIfcBuildingStorey(model);
    p.setLongName(longName);
    p.setSpaceName(name);
    p.setInteriorOrExteriorSpace(interiorOrExteriorSpace);

    for (final IfcFurnishingElementRender element : furnishingElementList) {
      p.addFurnishingElement(element.toModel(p));
    }

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreySpaceProperty(new IfcBuildingStoreySpaceProperty(prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreySpacePresentationlayer(new IfcBuildingStoreySpacePresentationlayer(layer.getPropertyId()));
    }

    return p;
  }
}
