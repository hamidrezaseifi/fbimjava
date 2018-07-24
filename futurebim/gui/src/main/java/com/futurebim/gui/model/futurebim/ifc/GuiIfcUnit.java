package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.IfcUnitEdo;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcSIUnit")
public class GuiIfcUnit {
  
  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  @JsonProperty(value = "SI_equivalent")
  protected String equivalent;
  
  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  protected String unitName;
  
  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  @JsonProperty(value = "UnitType")
  protected String unitType;
  
  private final String type = "IfcSIUnit";
  
  private final List children = new ArrayList<>();
  
  public GuiIfcUnit(final IfcUnitEdo edo){
    setEquivalent(edo.getEquivalent());
    setUnitName(edo.getUnitName());
    setUnitType(edo.getUnitType());
  }
  
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
  
  public String getType() {
    return type;
  }

  public List getChildren() {
    return children;
  }

}
