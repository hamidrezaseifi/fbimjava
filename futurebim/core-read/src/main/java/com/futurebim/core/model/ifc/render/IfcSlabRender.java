package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyFootingPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyFootingProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreySlab;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWallstandardcaseOpeningProperty;
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
  private List<IfcOpeningElementRender> openingElementList;

  public IfcBuildingStoreySlab toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreySlab p = new IfcBuildingStoreySlab();
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

    for (final IfcOpeningElementRender element : openingElementList) {

      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreyWallstandardcaseOpening open = new IfcBuildingStoreyWallstandardcaseOpening();
      open.setWallId(id);
      open.setId(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpeningName(px.getName());
      open.setTag(px.getTag());
      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreyWallstandardcaseOpeningProperty(new IfcBuildingStoreyWallstandardcaseOpeningProperty(px.getId(),
                                                                                                                      prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(new IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(px.getId(),
                                                                                                                                        pl.getPropertyId()));
      }

      p.addIfcBuildingStoreyWallstandardcaseOpening(open);
    }

    return p;
  }

}
