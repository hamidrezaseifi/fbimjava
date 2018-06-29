package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcProperty;
import com.futurebim.core.model.ifc.IfcPropertySingleValue;

/**
 * The persistent class for the ifc_properties database table.
 *
 */

public class IfcPropertyRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String propertyName;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcPropertySingleValue")
  private List<IfcPropertyValueRender> values = new ArrayList<>();

  public IfcPropertyRender() {

  }

  public IfcPropertyRender(final IfcProperty model) {
    setId(model.getId());
    setPropertyName(model.getPropertyName());

    for (final IfcPropertySingleValue val : model.getIfcPropertiesValues()) {
      values.add(new IfcPropertyValueRender(val));
    }
  }

  public static List<IfcPropertyRender> fromModelList(final List<IfcProperty> modelList) {
    final List<IfcPropertyRender> list = new ArrayList<>();
    for (final IfcProperty prop : modelList) {
      list.add(new IfcPropertyRender(prop));
    }
    return list;
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getPropertyName() {
    return this.propertyName;
  }

  public void setPropertyName(final String propertyName) {
    this.propertyName = propertyName;
  }

  public List<IfcPropertyValueRender> getValues() {
    return values;
  }

  public void setValues(final List<IfcPropertyValueRender> values) {
    this.values = values;
  }

}
