package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcBuilding;
import com.futurebim.core.model.ifc.IfcBuildingProperty;

public class IfcPropertySetRender {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

  public IfcBuildingProperty toBuildingPropertyModel(final IfcBuilding model) {

    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    final IfcBuildingProperty p = new IfcBuildingProperty();

    p.setBuildingId(model.getId());
    p.setIfcBuilding(model);
    p.setPropertyId(pid);

    p.setIfcProperty(model.getIfcProjectSite().getIfcProject().getProjectIfc().findProperty(pid));

    return p;
  }
}
