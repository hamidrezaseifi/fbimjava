package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcProject;
import com.futurebim.core.model.ifc.IfcProjectSite;

/**
 * The persistent class for the ifc_project_site database table.
 *
 */

public class IfcProjectSiteRender {

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
  private final List<IfcBuildingRender> buildingList = new ArrayList<>();

  public IfcProjectSite toModel(final IfcProject model) {

    final IfcProjectSite p = new IfcProjectSite();
    p.setGuid(id);
    p.setCompositionType(compositionType);
    p.setIfcProject(model);
    p.setObjectPlacement(objectPlacement);
    p.setObjectType(objectType);
    p.setRefElevation(refElevation);
    p.setRefLatitude(refLatitude);
    p.setRefLongitude(refLongitude);
    p.setSiteName(siteName);
    p.setTag("");

    for (final IfcBuildingRender building : buildingList) {
      p.addIfcBuilding(building.toModel(p));
    }

    return p;
  }
}
