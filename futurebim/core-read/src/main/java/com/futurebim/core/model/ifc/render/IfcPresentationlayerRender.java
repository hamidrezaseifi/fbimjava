package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcPresentationlayer;

/**
 * The persistent class for the ifc_presentationlayers database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcPresentationLayerAssignment")
public class IfcPresentationlayerRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String layerName;

  public IfcPresentationlayer toModel(final String modelId) {

    final IfcPresentationlayer layer = new IfcPresentationlayer();
    layer.setId(id);
    layer.setLayerName(layerName);
    layer.setProjectIfcId(modelId);

    return layer;
  }
}
