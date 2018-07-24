package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.IfcPresentationlayerEdo;

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
  
  private final String type = "IfcPresentationLayerAssignment";
  
  private final List children = new ArrayList<>();

  public GuiIfcPresentationlayer(final IfcPresentationlayerEdo edo){
    setId(edo.getId());
    this.setLayerName(edo.getLayerName());
  }

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

  public String getType() {
    return type;
  }

  public List getChildren() {
    return children;
  }
}
