package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class IfcTypeWrapperRender {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  private List<IfcFurnituretypeRender> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  private List<IfcDoorstyleRender> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")// IfcWindowStyle
  private List<IfcWindowstyleRender> windowTypes = new ArrayList<>();

  public IfcTypeWrapperRender() {

  }

  public IfcTypeWrapperRender(final ProjectIfc model) {
    // units.addAll(IfcUnitRender.fromModelList(model.getIfcUnits()));
    // conversionUnits.addAll(IfcConversionBasedUnitRender.fromModelList(model.getIfcConversionBasedUnit()));
  }

  public List<IfcFurnituretypeRender> getFurnitureTypes() {
    return furnitureTypes;
  }

  public void setFurnitureTypes(final List<IfcFurnituretypeRender> furnitureTypes) {
    this.furnitureTypes = furnitureTypes;
  }

  public List<IfcDoorstyleRender> getDoorTypes() {
    return doorTypes;
  }

  public void setDoorTypes(final List<IfcDoorstyleRender> doorTypes) {
    this.doorTypes = doorTypes;
  }

  public List<IfcWindowstyleRender> getWindowTypes() {
    return windowTypes;
  }

  public void setWindowTypes(final List<IfcWindowstyleRender> windowTypes) {
    this.windowTypes = windowTypes;
  }

}
