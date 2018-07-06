package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcUnit;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcSIUnit")
public class IfcUnitRender {

  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  protected String equivalent;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  protected String unitName;

  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  protected String unitType;

  public IfcUnit toUnitModel(final ProjectIfc model) {

    final IfcUnit u = new IfcUnit();

    u.setProjectIfc(model);
    u.setUnitName(unitName);
    u.setUnitType(unitType);
    u.setEquivalent(equivalent);

    return u;

  }
}
