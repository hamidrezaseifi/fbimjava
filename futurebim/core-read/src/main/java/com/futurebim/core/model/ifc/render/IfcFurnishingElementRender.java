package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpace;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelement;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementFurnituretype;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementOpening;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementOpeningProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreySpaceFurnishingelementProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcFurnishingElementRender {

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
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementRender> openingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcFurnitureTypeSetRender> furnitureTypeList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreySpaceFurnishingelement toModel(final IfcBuildingStoreySpace model) {

    final IfcBuildingStoreySpaceFurnishingelement p = new IfcBuildingStoreySpaceFurnishingelement();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setIfcBuildingStorey(model);
    p.setElementName(name);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setSpaceId(model.getId());

    for (final IfcOpeningElementRender element : openingElementList) {

      final IfcOpeningElementProxy px = element.toProxy();

      final IfcBuildingStoreySpaceFurnishingelementOpening open = new IfcBuildingStoreySpaceFurnishingelementOpening();
      open.setElementId(id);
      open.setId(px.getId());
      open.setObjectPlacement(px.getObjectPlacement());
      open.setObjectType(px.getObjectType());
      open.setOpenName(px.getName());
      open.setTag(px.getTag());
      for (final IfcPropertySetProxy prp : px.getPropertySetList()) {
        open.addIfcBuildingStoreySpaceFurnishingelementOpeningProperty(new IfcBuildingStoreySpaceFurnishingelementOpeningProperty(px.getId(),
                                                                                                                                  prp.getPropertyId()));
      }
      for (final IfcPresentationLayerAssignmentSetProxy pl : px.getPresentationLayerAssignmentList()) {
        open.addIfcBuildingStoreySpaceFelementOpeningPresentationlayer(new IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer(px.getId(),
                                                                                                                                           pl.getPropertyId()));
      }

      // p.addIfcBuildingStoreySpaceFurnishingelementOpening(open);
    }

    for (final IfcFurnitureTypeSetRender type : furnitureTypeList) {
      p.addIfcBuildingStoreySpaceFurnishingelementFurnituretype(new IfcBuildingStoreySpaceFurnishingelementFurnituretype(id,
                                                                                                                         type.getPropertyId()));
    }

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreySpaceFurnishingelementProperty(new IfcBuildingStoreySpaceFurnishingelementProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSet layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreySpaceFurnishingelementPresentationlayer(new IfcBuildingStoreySpaceFurnishingelementPresentationlayer(id,
                                                                                                                                 layer.getPropertyId()));
    }

    return p;
  }
}
