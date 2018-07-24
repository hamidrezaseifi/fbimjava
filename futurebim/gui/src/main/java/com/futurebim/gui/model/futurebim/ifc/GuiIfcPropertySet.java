package com.futurebim.gui.model.futurebim.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GuiIfcPropertySet {

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
