package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DecompositionWrapperRender {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcProject")
  private List<IfcProjectRender> projects = new ArrayList<>();

  public List<IfcProjectRender> getProjects() {
    return projects;
  }

  public void setProjects(final List<IfcProjectRender> projects) {
    this.projects = projects;
  }

}
