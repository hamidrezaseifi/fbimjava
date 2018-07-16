package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_project_site database table.
 *
 */

public class IfcProjectSiteEdo {

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
  private final List<IfcBuildingEdo> buildingList = new ArrayList<>();

}
