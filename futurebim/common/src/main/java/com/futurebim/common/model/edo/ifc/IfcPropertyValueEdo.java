package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
public class IfcPropertyValueEdo {

  @JacksonXmlProperty(localName = "NominalValue", isAttribute = true)
  private String nominalValue;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String valueName;

  public String getNominalValue() {
    return nominalValue;
  }

  public void setNominalValue(final String nominalValue) {
    this.nominalValue = nominalValue;
  }

  public String getValueName() {
    return valueName;
  }

  public void setValueName(final String valueName) {
    this.valueName = valueName;
  }

}
