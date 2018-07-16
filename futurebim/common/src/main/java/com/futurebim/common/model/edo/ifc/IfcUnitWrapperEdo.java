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
public class IfcUnitWrapperEdo {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSIUnit")
  private List<IfcUnitEdo> units = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcConversionBasedUnit")
  private List<IfcConversionBasedUnitEdo> conversionUnits = new ArrayList<>();

  public void setUnits(final List<IfcUnitEdo> units) {
    this.units = units;
  }

  public void addUnit(final IfcUnitEdo unit) {
    this.units.add(unit);
  }

  public List<IfcConversionBasedUnitEdo> getConversionUnits() {
    return conversionUnits;
  }

  public void setConversionUnits(final List<IfcConversionBasedUnitEdo> conversionUnits) {
    this.conversionUnits = conversionUnits;
  }

  public void addConversionUnit(final IfcConversionBasedUnitEdo conversion) {
    this.conversionUnits.add(conversion);
  }

  public List<IfcUnitEdo> getUnits() {
    return units;
  }

}
