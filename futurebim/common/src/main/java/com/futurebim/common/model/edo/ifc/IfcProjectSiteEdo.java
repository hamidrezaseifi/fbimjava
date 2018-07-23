package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_project_site database table.
 *
 */

public class IfcProjectSiteEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String siteName;

  @JacksonXmlProperty(localName = "ObjectType", isAttribute = true)
  @JsonProperty(value = "ObjectType")
  private String objectType;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  @JsonProperty(value = "ObjectPlacement")
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  @JsonProperty(value = "CompositionType")
  private String compositionType;

  @JacksonXmlProperty(localName = "RefLatitude", isAttribute = true)
  @JsonProperty(value = "RefLatitude")
  private String refLatitude;

  @JacksonXmlProperty(localName = "RefLongitude", isAttribute = true)
  @JsonProperty(value = "RefLongitude")
  private String refLongitude;

  @JacksonXmlProperty(localName = "RefElevation", isAttribute = true)
  @JsonProperty(value = "RefElevation")
  private String refElevation;

  @JacksonXmlProperty(localName = "IfcBuilding")
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonProperty(value = "IfcBuilding")
  private List<IfcBuildingEdo> buildingList = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getSiteName() {
    return siteName;
  }

  public void setSiteName(final String siteName) {
    this.siteName = siteName;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(final String objectType) {
    this.objectType = objectType;
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

  public String getRefLatitude() {
    return refLatitude;
  }

  public void setRefLatitude(final String refLatitude) {
    this.refLatitude = refLatitude;
  }

  public String getRefLongitude() {
    return refLongitude;
  }

  public void setRefLongitude(final String refLongitude) {
    this.refLongitude = refLongitude;
  }

  public String getRefElevation() {
    return refElevation;
  }

  public void setRefElevation(final String refElevation) {
    this.refElevation = refElevation;
  }

  public List<IfcBuildingEdo> getBuildingList() {
    return buildingList;
  }

  public void setBuildingList(final List<IfcBuildingEdo> buildingList) {
    this.buildingList = buildingList;
  }

  public void addBuilding(final IfcBuildingEdo building) {
    this.buildingList.add(building);
  }

}
