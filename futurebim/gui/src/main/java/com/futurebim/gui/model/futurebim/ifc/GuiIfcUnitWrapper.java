package com.futurebim.gui.model.futurebim.ifc;

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
public class GuiIfcUnitWrapper {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSIUnit")
  private List<GuiIfcUnit> units = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcConversionBasedUnit")
  private List<GuiIfcConversionBasedUnit> conversionUnits = new ArrayList<>();

  public void setUnits(final List<GuiIfcUnit> units) {
    this.units = units;
  }

  public void addUnit(final GuiIfcUnit unit) {
    this.units.add(unit);
  }

  public List<GuiIfcConversionBasedUnit> getConversionUnits() {
    return conversionUnits;
  }

  public void setConversionUnits(final List<GuiIfcConversionBasedUnit> conversionUnits) {
    this.conversionUnits = conversionUnits;
  }

  public void addConversionUnit(final GuiIfcConversionBasedUnit conversion) {
    this.conversionUnits.add(conversion);
  }

  public List<GuiIfcUnit> getUnits() {
    return units;
  }

}
