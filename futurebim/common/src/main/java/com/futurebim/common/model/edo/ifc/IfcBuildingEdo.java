package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_building database table.
 *
 */

public class IfcBuildingEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private final String buildingName = "-";

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  @JsonProperty(value = "ObjectPlacement")
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  @JsonProperty(value = "CompositionType")
  private String compositionType;

  @JacksonXmlProperty(localName = "IfcBuildingStorey", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonProperty(value = "IfcBuildingStorey")
  private List<IfcBuildingStoreyEdo> buildingStoreyList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPropertySet", isAttribute = true)
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonProperty(value = "IfcPropertySet")
  private List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getObjectPlacement() {
    return objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getCompositionType() {
    return compositionType;
  }

  public void setCompositionType(final String compositionType) {
    this.compositionType = compositionType;
  }

  public List<IfcBuildingStoreyEdo> getBuildingStoreyList() {
    return buildingStoreyList;
  }

  public void setBuildingStoreyList(final List<IfcBuildingStoreyEdo> buildingStoreyList) {
    this.buildingStoreyList = buildingStoreyList;
  }

  public void addBuildingStorey(final IfcBuildingStoreyEdo buildingStorey) {
    this.buildingStoreyList.add(buildingStorey);
  }

  public List<IfcPropertySetEdo> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<IfcPropertySetEdo> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public void addPropertySet(final IfcPropertySetEdo propertySet) {
    this.propertySetList.add(propertySet);
  }

  public String getBuildingName() {
    return buildingName;
  }

}
