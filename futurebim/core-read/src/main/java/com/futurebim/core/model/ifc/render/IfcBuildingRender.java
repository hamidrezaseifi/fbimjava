package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuilding;
import com.futurebim.core.model.ifc.IfcBuildingProperty;
import com.futurebim.core.model.ifc.IfcProjectSite;

/**
 * The persistent class for the ifc_building database table.
 *
 */

public class IfcBuildingRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private final String buildingName = "-";

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "IfcBuildingStorey", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcBuildingStoreyRender> buildingStoreyList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  public IfcBuilding toModel(final IfcProjectSite model) {

    final IfcBuilding p = new IfcBuilding();
    p.setGuid(id);
    p.setCompositionType(compositionType);
    p.setObjectPlacement(objectPlacement);
    p.setBuildingName(buildingName);
    p.setIfcProjectSite(model);

    for (final IfcBuildingStoreyRender buildingStorey : buildingStoreyList) {
      p.addIfcBuildingStorey(buildingStorey.toModel(p));
    }

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingProperty(new IfcBuildingProperty(prop.getPropertyId()));
    }

    return p;
  }

}
