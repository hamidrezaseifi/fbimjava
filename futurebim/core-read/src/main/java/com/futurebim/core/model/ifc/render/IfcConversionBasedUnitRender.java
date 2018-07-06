package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcConversionBasedUnit;
import com.futurebim.core.model.ifc.ProjectIfc;

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

  public IfcConversionBasedUnit toUnitModel(final ProjectIfc model) {

    final IfcConversionBasedUnit u = new IfcConversionBasedUnit();
    u.setProjectIfc(model);
    u.setUnitName(unitName);
    u.setUnitType(unitType);
    u.setEquivalent(equivalent);

    return u;

  }
}
