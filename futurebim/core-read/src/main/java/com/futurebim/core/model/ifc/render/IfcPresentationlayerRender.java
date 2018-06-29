package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcPresentationlayer;

/**
 * The persistent class for the ifc_presentationlayers database table.
 *
 */
public class IfcPresentationlayerRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String layerName;

  public IfcPresentationlayerRender() {
  }

  public IfcPresentationlayerRender(final IfcPresentationlayer model) {
    setId(model.getId());
    setLayerName(model.getLayerName());
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getLayerName() {
    return this.layerName;
  }

  public void setLayerName(final String layerName) {
    this.layerName = layerName;
  }

}
