package com.futurebim.gui.model.futurebim.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcConversionBasedUnit")
public class GuiIfcConversionBasedUnit {

  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  @JsonProperty(value = "SI_equivalent")
  private String equivalent;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String unitName;

  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  @JsonProperty(value = "UnitType")
  private String unitType;

  public String getEquivalent() {
    return equivalent;
  }

  public void setEquivalent(final String equivalent) {
    this.equivalent = equivalent;
  }

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(final String unitName) {
    this.unitName = unitName;
  }

  public String getUnitType() {
    return unitType;
  }

  public void setUnitType(final String unitType) {
    this.unitType = unitType;
  }

}
