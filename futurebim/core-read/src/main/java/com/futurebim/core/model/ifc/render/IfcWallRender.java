package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWall;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallOpeningProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcWallRender {

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

  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementRender> openingElementList = new ArrayList<>();

  public IfcBuildingStoreyWall toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyWall p = new IfcBuildingStoreyWall();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setStoreyId(model.getId());
    p.setWallName(name);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyWallProperty(new IfcBuildingStoreyWallProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyWallPresentationlayer(new IfcBuildingStoreyWallPresentationlayer(id, layer.getPropertyId()));
    }

    for (final IfcOpeningElementRender element : openingElementList) {

      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreyWallOpening open = new IfcBuildingStoreyWallOpening();
      open.setWallId(id);
      open.setId(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpeningName(px.getName());
      open.setTag(px.getTag());
      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreyWallOpeningProperty(new IfcBuildingStoreyWallOpeningProperty(px.getId(), prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreyWallOpeningPresentationlayer(new IfcBuildingStoreyWallOpeningPresentationlayer(px.getId(),
                                                                                                                pl.getPropertyId()));
      }

      p.addIfcBuildingStoreyWallOpening(open);
    }

    return p;
  }
}
