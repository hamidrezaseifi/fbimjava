package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcWindowStyleSetEdo {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  private String href;

}
