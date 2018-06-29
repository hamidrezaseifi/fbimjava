package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcPropertySingleValue;

/**
 * The persistent class for the ifc_properties_value database table.
 *
 */
public class IfcPropertyValueRender {

  @JacksonXmlProperty(localName = "NominalValue", isAttribute = true)
  private String nominalValue;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String valueName;

  public IfcPropertyValueRender() {

  }

  public IfcPropertyValueRender(final IfcPropertySingleValue model) {
    setNominalValue(model.getNominalValue());
    setValueName(model.getValueName());
  }

  public String getNominalValue() {
    return this.nominalValue;
  }

  public void setNominalValue(final String nominalValue) {
    this.nominalValue = nominalValue.length() < 150 ? nominalValue : nominalValue.substring(0, 145);
  }

  public String getValueName() {
    return this.valueName;
  }

  public void setValueName(final String valueName) {
    this.valueName = valueName;
  }

}
