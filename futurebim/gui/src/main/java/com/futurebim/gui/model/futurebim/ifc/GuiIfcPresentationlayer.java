package com.futurebim.gui.model.futurebim.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the ifc_presentationlayers database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcPresentationLayerAssignment")
public class GuiIfcPresentationlayer {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String layerName;

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getLayerName() {
    return layerName;
  }

  public void setLayerName(final String layerName) {
    this.layerName = layerName;
  }

}
