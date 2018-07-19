package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcase;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpeningProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcasePresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcWallStandardCaseRender {

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

  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementRender> openingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreyWallstandardcase toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyWallstandardcase p = new IfcBuildingStoreyWallstandardcase();
    p.setGuid(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setWallName(name);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyWallstandardcaseProperty(new IfcBuildingStoreyWallstandardcaseProperty(prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyWallstandardcasePresentationlayer(new IfcBuildingStoreyWallstandardcasePresentationlayer(
                                                                                                                     layer.getPropertyId()));
    }

    for (final IfcOpeningElementRender element : openingElementList) {

      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreyWallstandardcaseOpening open = new IfcBuildingStoreyWallstandardcaseOpening();
      open.setGuid(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpeningName(px.getName());
      open.setTag(px.getTag());
      open.setIfcBuildingStoreyWallstandardcase(p);

      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreyWallstandardcaseOpeningProperty(new IfcBuildingStoreyWallstandardcaseOpeningProperty(
                                                                                                                      prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(new IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(pl.getPropertyId()));
      }

      p.addIfcBuildingStoreyWallstandardcaseOpening(open);
    }

    return p;
  }

}
