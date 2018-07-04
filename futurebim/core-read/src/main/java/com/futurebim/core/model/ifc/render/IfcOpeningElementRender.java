package com.futurebim.core.model.ifc.render;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.proxy.IfcOpeningElementProxy;

public class IfcOpeningElementRender {

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
  private List<IfcPresentationLayerAssignmentSet> presentationLayerAssignmentList;

  public IfcOpeningElementProxy toProxy() {

    final IfcOpeningElementProxy p = new IfcOpeningElementProxy();

    p.setId(id);
    p.setName(name);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setTag(tag);

    for (final IfcPropertySetRender el : propertySetList) {
      p.addPropertySetList(el.toProxy());
    }

    for (final IfcPresentationLayerAssignmentSet el : presentationLayerAssignmentList) {
      p.addPresentationLayerAssignmentList(el.toProxy());
    }

    return p;
  }
}
