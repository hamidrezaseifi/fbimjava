package com.futurebim.gui.model.futurebim.ifc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
public class GuiIfcPropertyValue {

  @JacksonXmlProperty(localName = "NominalValue", isAttribute = true)
  @JsonProperty(value = "NominalValue")
  private String nominalValue;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
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
