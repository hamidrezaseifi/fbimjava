package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcProject;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the ifc_project database table.
 *
 */
public class IfcProjectRender {

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
  private final List<IfcProjectSiteRender> sites = new ArrayList<>();

  public IfcProject toModel(final ProjectIfc model) {

    final IfcProject p = new IfcProject();
    p.setId(id);
    p.setPhase(phase);
    p.setProjectIfc(model);
    p.setProjectIfcId(model.getId());
    p.setProjectLongName(projectLongName);
    p.setProjectName(projectName);

    for (final IfcProjectSiteRender site : sites) {
      p.addIfcProjectSites(site.toModel(p));
    }

    return p;
  }
}
