package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcPropertyEdo;
import com.futurebim.common.model.edo.ifc.IfcPropertyValueEdo;

/**
 * The persistent class for the ifc_properties database table.
 *
 */

public class GuiIfcProperty {
  
  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;
  
  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String propertyName;
  
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcPropertySingleValue")
  private List<GuiIfcPropertyValue> children = new ArrayList<>();
  
  private final String type = "IfcPropertySet";

  public GuiIfcProperty(final IfcPropertyEdo edo){
    setId(edo.getId());
    setPropertyName(edo.getPropertyName());
    
    for(final IfcPropertyValueEdo val: edo.getValues()){
      addChild(new GuiIfcPropertyValue(val));
    }
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  public String getPropertyName() {
    return propertyName;
  }
  
  public void setPropertyName(final String propertyName) {
    this.propertyName = propertyName;
  }
  
  public void setChildren(final List<GuiIfcPropertyValue> values) {
    this.children = values;
  }
  
  public void addChild(final GuiIfcPropertyValue value) {
    this.children.add(value);
  }
  
  public String getType() {
    return type;
  }

  public List getChildren() {
    return children;
  }

}
