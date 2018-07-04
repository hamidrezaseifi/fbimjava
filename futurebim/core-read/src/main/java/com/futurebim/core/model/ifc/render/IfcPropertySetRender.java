package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.proxy.IfcPropertySetProxy;

public class IfcPropertySetRender {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

  public String getPropertyId() {
    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    return pid;
  }

  public IfcPropertySetProxy toProxy() {

    final IfcPropertySetProxy p = new IfcPropertySetProxy();

    p.setHref(href);

    return p;
  }
}
