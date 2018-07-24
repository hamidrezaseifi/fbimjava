package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcPropertyValueEdo;

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
  
  private final String type = "IfcPropertySingleValue";
  
  private final List children = new ArrayList<>();

  public GuiIfcPropertyValue(final IfcPropertyValueEdo edo){
    setNominalValue(edo.getNominalValue());
    setValueName(edo.getValueName());
  }

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

  public String getType() {
    return type;
  }
  
  public List getChildren() {
    return children;
  }
  
}
