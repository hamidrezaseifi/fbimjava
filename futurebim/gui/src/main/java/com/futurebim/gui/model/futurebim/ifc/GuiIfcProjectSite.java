package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_project_site database table.
 *
 */

public class GuiIfcProjectSite {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String siteName;

  @JacksonXmlProperty(localName = "ObjectType", isAttribute = true)
  private String objectType;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "CompositionType", isAttribute = true)
  private String compositionType;

  @JacksonXmlProperty(localName = "RefLatitude", isAttribute = true)
  private String refLatitude;

  @JacksonXmlProperty(localName = "RefLongitude", isAttribute = true)
  private String refLongitude;

  @JacksonXmlProperty(localName = "RefElevation", isAttribute = true)
  private String refElevation;

  @JacksonXmlProperty(localName = "IfcBuilding")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<GuiIfcBuilding> buildingList = new ArrayList<>();

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

  public List<GuiIfcBuilding> getBuildingList() {
    return buildingList;
  }

  public void setBuildingList(final List<GuiIfcBuilding> buildingList) {
    this.buildingList = buildingList;
  }

  public void addBuilding(final GuiIfcBuilding building) {
    this.buildingList.add(building);
  }

}
