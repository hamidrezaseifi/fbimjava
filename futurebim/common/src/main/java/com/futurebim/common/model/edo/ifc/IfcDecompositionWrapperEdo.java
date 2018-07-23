package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcDecompositionWrapperEdo {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcProject")
  @JsonProperty(value = "IfcProject")
  private List<IfcProjectEdo> projects = new ArrayList<>();

  public List<IfcProjectEdo> getProjects() {
    return projects;
  }

  public void setProjects(final List<IfcProjectEdo> projects) {
    this.projects = projects;
  }

  public void addProject(final IfcProjectEdo project) {
    this.projects.add(project);
  }

}
