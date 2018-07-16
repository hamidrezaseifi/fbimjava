package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoof;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoofOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoofOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoofOpeningProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoofPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyRoofProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcRoofRender {

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

  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementRender> openingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcSlab")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcSlabRender> slabList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetRender> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreyRoof toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyRoof p = new IfcBuildingStoreyRoof();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setRoofName(name);
    p.setShapeType(shapeType);
    p.setStoreyId(model.getId());

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyRoofProperty(new IfcBuildingStoreyRoofProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSetRender prop : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyRoofPresentationlayer(new IfcBuildingStoreyRoofPresentationlayer(id, prop.getPropertyId()));
    }

    for (final IfcSlabRender slab : slabList) {
      p.addIfcBuildingStoreyRoofSlab(slab.toRoolSlabModel(p));
    }

    for (final IfcOpeningElementRender element : openingElementList) {
      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreyRoofOpening open = new IfcBuildingStoreyRoofOpening();
      open.setIfcBuildingStoreyRoof(p);
      open.setId(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpeningName(px.getName());
      open.setTag(px.getTag());
      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreyRoofOpeningProperty(new IfcBuildingStoreyRoofOpeningProperty(px.getId(), prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreyRoofOpeningPresentationlayer(new IfcBuildingStoreyRoofOpeningPresentationlayer(px.getId(),
                                                                                                                pl.getPropertyId()));
      }

      p.addIfcBuildingStoreyRoofOpening(open);
    }

    return p;
  }

}
