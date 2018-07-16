package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "IfcSIUnit")
public class IfcUnitEdo {

  @JacksonXmlProperty(localName = "SI_equivalent", isAttribute = true)
  protected String equivalent;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  protected String unitName;

  @JacksonXmlProperty(localName = "UnitType", isAttribute = true)
  protected String unitType;

}
