package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_project database table.
 *
 */
public class IfcProjectEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String projectName;

  @JacksonXmlProperty(localName = "LongName", isAttribute = true)
  private String projectLongName;

  @JacksonXmlProperty(localName = "Phase", isAttribute = true)
  private String phase;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSite")
  private final List<IfcProjectSiteEdo> sites = new ArrayList<>();

}
