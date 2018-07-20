package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_properties database table.
 *
 */

public class GuiIfcProperty {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String propertyName;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcPropertySingleValue")
  private List<GuiIfcPropertyValue> values = new ArrayList<>();

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

  public List<GuiIfcPropertyValue> getValues() {
    return values;
  }

  public void setValues(final List<GuiIfcPropertyValue> values) {
    this.values = values;
  }

  public void addValue(final GuiIfcPropertyValue value) {
    this.values.add(value);
  }

}
