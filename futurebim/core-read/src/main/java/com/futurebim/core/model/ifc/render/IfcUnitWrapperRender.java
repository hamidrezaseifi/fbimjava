package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcConversionBasedUnit;
import com.futurebim.core.model.ifc.IfcUnit;
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

  public void setUnits(final List<IfcUnitRender> units) {
    this.units.addAll(units);
  }

  public List<IfcUnit> toUnitModel(final ProjectIfc model) {

    final List<IfcUnit> list = new ArrayList<>();
    for (final IfcUnitRender unit : units) {

      list.add(unit.toUnitModel(model));
    }
    return list;
  }

  public List<IfcConversionBasedUnit> toConversionBasedUnitModel(final Long modelId) {

    final List<IfcConversionBasedUnit> list = new ArrayList<>();
    for (final IfcConversionBasedUnitRender unit : conversionUnits) {

      list.add(unit.toUnitModel(modelId));
    }
    return list;
  }
}
