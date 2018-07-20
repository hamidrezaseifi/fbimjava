package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GuiIfcDecompositionWrapper {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcProject")
  private List<GuiIfcProject> projects = new ArrayList<>();

  public List<GuiIfcProject> getProjects() {
    return projects;
  }

  public void setProjects(final List<GuiIfcProject> projects) {
    this.projects = projects;
  }

  public void addProject(final GuiIfcProject project) {
    this.projects.add(project);
  }

}
