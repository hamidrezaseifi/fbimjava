package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
public class IfcPropertyValueRender {

  @JacksonXmlProperty(localName = "NominalValue", isAttribute = true)
  private String nominalValue;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String valueName;

}
