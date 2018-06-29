package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcUnit;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcSIUnit")
public class IfcUnitRender {

  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  private String equivalent;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String unitName;

  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  private String unitType;

  public IfcUnitRender() {

  }

  public IfcUnitRender(final IfcUnit unit) {
    setEquivalent(unit.getEquivalent());
    setUnitName(unit.getUnitName());
    setUnitType(unit.getUnitType());
  }

  public static List<IfcUnitRender> fromModelList(final List<IfcUnit> modelList) {
    final List<IfcUnitRender> list = new ArrayList<>();
    for (final IfcUnit unit : modelList) {
      list.add(new IfcUnitRender(unit));
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
