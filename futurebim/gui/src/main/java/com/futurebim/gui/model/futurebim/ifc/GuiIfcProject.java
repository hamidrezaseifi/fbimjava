package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_project database table.
 *
 */
public class GuiIfcProject {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  @JsonProperty(value = "guid")
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  @JsonProperty(value = "name")
  private String projectName;

  @JacksonXmlProperty(localName = "LongName", isAttribute = true)
  @JsonProperty(value = "LongName")
  private String projectLongName;

  @JacksonXmlProperty(localName = "Phase", isAttribute = true)
  @JsonProperty(value = "Phase")
  private String phase;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSite")
  @JsonProperty(value = "IfcSite")
  private List<GuiIfcProjectSite> sites = new ArrayList<>();

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

  public List<GuiIfcProjectSite> getSites() {
    return sites;
  }

  public void setSites(final List<GuiIfcProjectSite> sites) {
    this.sites = sites;
  }

  public void addSite(final GuiIfcProjectSite site) {
    this.sites.add(site);
  }

}
