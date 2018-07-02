package com.futurebim.core.model.ifc.render;

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

  public IfcConversionBasedUnit toUnitModel(final String modelId) {

    final IfcConversionBasedUnit u = new IfcConversionBasedUnit();
    u.setIfcId(modelId);
    u.setUnitName(unitName);
    u.setUnitType(unitType);
    u.setEquivalent(equivalent);

    return u;

  }
}
