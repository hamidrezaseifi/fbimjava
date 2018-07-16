package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class IfcTypeWrapperEdo {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  private List<IfcFurnituretypeEdo> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  private List<IfcDoorstyleEdo> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")
  private List<IfcWindowstyleEdo> windowTypes = new ArrayList<>();

  public List<IfcFurnituretypeEdo> getFurnitureTypes() {
    return furnitureTypes;
  }

  public void setFurnitureTypes(final List<IfcFurnituretypeEdo> furnitureTypes) {
    this.furnitureTypes = furnitureTypes;
  }

  public void addFurnitureType(final IfcFurnituretypeEdo furnitureType) {
    this.furnitureTypes.add(furnitureType);
  }

  public List<IfcDoorstyleEdo> getDoorTypes() {
    return doorTypes;
  }

  public void setDoorTypes(final List<IfcDoorstyleEdo> doorTypes) {
    this.doorTypes = doorTypes;
  }

  public void addDoorType(final IfcDoorstyleEdo doorType) {
    this.doorTypes.add(doorType);
  }

  public List<IfcWindowstyleEdo> getWindowTypes() {
    return windowTypes;
  }

  public void setWindowTypes(final List<IfcWindowstyleEdo> windowTypes) {
    this.windowTypes = windowTypes;
  }

  public void addWindowType(final IfcWindowstyleEdo windowType) {
    this.windowTypes.add(windowType);
  }

}
