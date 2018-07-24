package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcFurnitureTypeSetEdo;

public class GuiIfcFurnitureTypeSet {

  @JacksonXmlProperty(namespace = "xlink", localName = "href", isAttribute = true)
  @JsonProperty(value = "xlink:href")
  private String href;

  private final String type = "IfcFurnitureType";

  public GuiIfcFurnitureTypeSet(final IfcFurnitureTypeSetEdo edo){
    setHref(edo.getHref());
  }

  public String getHref() {
    return href;
  }

  public void setHref(final String href) {
    this.href = href;
  }

  public String getType() {
    return type;
  }

  public List<Object> getChildren() {

    return new ArrayList<>();
  }

}
