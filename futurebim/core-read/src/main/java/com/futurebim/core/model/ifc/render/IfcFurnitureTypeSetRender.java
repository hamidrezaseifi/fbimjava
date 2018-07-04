package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcFurnitureTypeSetRender {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

  public String getPropertyId() {
    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    return pid;
  }
}
