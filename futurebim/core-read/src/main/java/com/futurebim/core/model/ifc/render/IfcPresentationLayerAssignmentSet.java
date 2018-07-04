package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.proxy.IfcPresentationLayerAssignmentSetProxy;

public class IfcPresentationLayerAssignmentSet {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

  public String getPropertyId() {
    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    return pid;
  }

  public IfcPresentationLayerAssignmentSetProxy toProxy() {

    final IfcPresentationLayerAssignmentSetProxy p = new IfcPresentationLayerAssignmentSetProxy();

    p.setHref(href);

    return p;
  }
}
