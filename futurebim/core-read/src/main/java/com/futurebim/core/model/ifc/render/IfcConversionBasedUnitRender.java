package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcConversionBasedUnit;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcConversionBasedUnit")
public class IfcConversionBasedUnitRender {

  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  private String equivalent;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String unitName;

  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  private String unitType;

  public IfcConversionBasedUnitRender(final IfcConversionBasedUnit unit) {
    setEquivalent(unit.getEquivalent());
    setUnitName(unit.getUnitName());
    setUnitType(unit.getUnitType());
  }

  public static List<IfcConversionBasedUnitRender> fromModelList(final List<IfcConversionBasedUnit> modelList) {
    final List<IfcConversionBasedUnitRender> list = new ArrayList<>();
    for (final IfcConversionBasedUnit unit : modelList) {
      list.add(new IfcConversionBasedUnitRender(unit));
    }
    return list;
  }

  public String getEquivalent() {
    return this.equivalent;
  }

  public void setEquivalent(final String equivalent) {
    this.equivalent = equivalent;
  }

  public String getUnitName() {
    return this.unitName;
  }

  public void setUnitName(final String unitName) {
    this.unitName = unitName;
  }

  public String getUnitType() {
    return this.unitType;
  }

  public void setUnitType(final String unitType) {
    this.unitType = unitType;
  }
}
