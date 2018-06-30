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
public class IfcUnitWrapperRender {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSIUnit")
  private final List<IfcUnitRender> units = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcConversionBasedUnit")
  private final List<IfcConversionBasedUnitRender> conversionUnits = new ArrayList<>();

  public IfcUnitWrapperRender() {

  }

  public IfcUnitWrapperRender(final ProjectIfc model) {
    // units.addAll(IfcUnitRender.fromModelList(model.getIfcUnits()));
    // conversionUnits.addAll(IfcConversionBasedUnitRender.fromModelList(model.getIfcConversionBasedUnit()));
  }

  public List<IfcUnitRender> getUnits() {
    return units;
  }

  public List<IfcConversionBasedUnitRender> getConversionUnits() {
    return conversionUnits;
  }

  public void setUnits(final List<IfcUnitRender> units) {
    this.units.addAll(units);
  }

  public void setConversionUnits(final List<IfcConversionBasedUnitRender> conversionUnits) {
    this.conversionUnits.addAll(conversionUnits);
  }

}
