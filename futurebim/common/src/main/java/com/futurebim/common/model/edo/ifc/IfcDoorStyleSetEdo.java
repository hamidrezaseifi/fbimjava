package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcDoorStyleSetEdo {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  @JsonProperty(value = "href")
  private String href;

  public String getHref() {
    return href;
  }

  public void setHref(final String href) {
    this.href = href;
  }

}
