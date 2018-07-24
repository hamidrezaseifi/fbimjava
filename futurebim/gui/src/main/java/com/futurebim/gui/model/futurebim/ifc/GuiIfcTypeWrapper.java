package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class GuiIfcTypeWrapper {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  @JsonProperty(value = "IfcFurnitureType")
  private List<GuiIfcFurnituretype> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  @JsonProperty(value = "IfcDoorStyle")
  private List<GuiIfcDoorstyle> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")
  @JsonProperty(value = "IfcWindowStyle")
  private List<GuiIfcWindowstyle> windowTypes = new ArrayList<>();

  public List<GuiIfcFurnituretype> getFurnitureTypes() {
    return furnitureTypes;
  }

  public void setFurnitureTypes(final List<GuiIfcFurnituretype> furnitureTypes) {
    this.furnitureTypes = furnitureTypes;
  }

  public void addFurnitureType(final GuiIfcFurnituretype furnitureType) {
    this.furnitureTypes.add(furnitureType);
  }

  public List<GuiIfcDoorstyle> getDoorTypes() {
    return doorTypes;
  }

  public void setDoorTypes(final List<GuiIfcDoorstyle> doorTypes) {
    this.doorTypes = doorTypes;
  }

  public void addDoorType(final GuiIfcDoorstyle doorType) {
    this.doorTypes.add(doorType);
  }

  public List<GuiIfcWindowstyle> getWindowTypes() {
    return windowTypes;
  }

  public void setWindowTypes(final List<GuiIfcWindowstyle> windowTypes) {
    this.windowTypes = windowTypes;
  }

  public void addWindowType(final GuiIfcWindowstyle windowType) {
    this.windowTypes.add(windowType);
  }

}
