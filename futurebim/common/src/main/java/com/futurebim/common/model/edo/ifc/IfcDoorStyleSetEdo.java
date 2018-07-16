package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcDoorStyleSetEdo {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

  public String getStyleId() {
    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    return pid;
  }
}
