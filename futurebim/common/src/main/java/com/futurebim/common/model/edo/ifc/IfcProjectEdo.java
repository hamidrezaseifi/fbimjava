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
  private List<IfcProjectSiteEdo> sites = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }

  public String getProjectLongName() {
    return projectLongName;
  }

  public void setProjectLongName(final String projectLongName) {
    this.projectLongName = projectLongName;
  }

  public String getPhase() {
    return phase;
  }

  public void setPhase(final String phase) {
    this.phase = phase;
  }

  public List<IfcProjectSiteEdo> getSites() {
    return sites;
  }

  public void setSites(final List<IfcProjectSiteEdo> sites) {
    this.sites = sites;
  }

  public void addSite(final IfcProjectSiteEdo site) {
    this.sites.add(site);
  }

}
