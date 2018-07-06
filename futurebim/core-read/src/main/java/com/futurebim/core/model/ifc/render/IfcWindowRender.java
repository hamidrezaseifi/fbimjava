package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuildingStorey;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWindow;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWindowPresentationlayer;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWindowProperty;
import com.futurebim.core.model.ifc.IfcBuildingStoreyWindowStyle;

public class IfcWindowRender {

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

  @JacksonXmlProperty(localName = "OverallHeight", isAttribute = true)
  private String overallHeight;

  @JacksonXmlProperty(localName = "OverallWidth", isAttribute = true)
  private String overallWidth;

  @JacksonXmlProperty(localName = "IfcWindowStyle")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcWindowStyleSet> windowStyleSetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetRender> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList = new ArrayList<>();

  public IfcBuildingStoreyWindow toModel(final IfcBuildingStorey model) {

    final IfcBuildingStoreyWindow p = new IfcBuildingStoreyWindow();
    p.setId(id);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);
    p.setIfcBuildingStorey(model);

    p.setWindowName(name);
    p.setOverallHeight(overallHeight);
    p.setOverallWidth(overallWidth);

    for (final IfcPropertySetRender prop : propertySetList) {
      p.addIfcBuildingStoreyWindowProperty(new IfcBuildingStoreyWindowProperty(id, prop.getPropertyId()));
    }

    for (final IfcPresentationLayerAssignmentSet layer : presentationLayerAssignmentList) {
      p.addIfcBuildingStoreyWindowPresentationlayer(new IfcBuildingStoreyWindowPresentationlayer(id, layer.getPropertyId()));
    }

    for (final IfcWindowStyleSet style : windowStyleSetList) {
      p.addIfcBuildingStoreyWindowStyle(new IfcBuildingStoreyWindowStyle(id, style.getStyleId()));
    }

    return p;
  }

}
