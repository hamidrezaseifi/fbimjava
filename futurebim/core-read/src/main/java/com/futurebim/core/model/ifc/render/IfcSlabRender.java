package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlab;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlabOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlabOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlabOpeningProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlabPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlabProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcSlabRender {

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

  // @JacksonXmlProperty(localName = "IfcOpeningElement")
  // @JacksonXmlElementWrapper(useWrapping = false)
  // private List<Object> openingElementList;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPropertySetRender> propertySetList;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList;

  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementRender> openingElementList = new ArrayList<>();

  public IfcBuildingStoreySlab toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreySlab p = new IfcBuildingStoreySlab();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);
    p.setStoreyId(model.getId());
    p.setSlabName(name);
    p.setPredefinedType(predefinedType);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreySlabProperty(new IfcBuildingStoreySlabProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSet layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreySlabPresentationlayer(new IfcBuildingStoreySlabPresentationlayer(id, layer.getPropertyId()));
    }

    for (final IfcOpeningElementRender element : openingElementList) {

      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreySlabOpening open = new IfcBuildingStoreySlabOpening();
      open.setSlabId(id);
      open.setId(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpeningName(px.getName());
      open.setTag(px.getTag());
      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreySlabOpeningProperty(new IfcBuildingStoreySlabOpeningProperty(px.getId(), prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreySlabOpeningPresentationlayer(new IfcBuildingStoreySlabOpeningPresentationlayer(px.getId(),
                                                                                                                pl.getPropertyId()));
      }

      p.addIfcBuildingStoreySlabOpening(open);
    }

    return p;
  }

}
