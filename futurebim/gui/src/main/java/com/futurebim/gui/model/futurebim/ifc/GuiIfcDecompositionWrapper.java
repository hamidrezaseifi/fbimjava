package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.IfcProjectEdo;
import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

public class GuiIfcDecompositionWrapper {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcProject")
  @JsonIgnore
  private List<GuiIfcProject> projetcs = new ArrayList<>();

  private final String type = "decomposition";
  
  public GuiIfcDecompositionWrapper(final ProjectIfcEdo edo){
    for(final IfcProjectEdo item: edo.getDecomposition().getProjects()){
      addProject(new GuiIfcProject(item));
    }
  }

  public List<GuiIfcProject> getProjetcs() {
    return projetcs;
  }
  
  public void setProjetcs(final List<GuiIfcProject> projetcs) {
    this.projetcs = projetcs;
  }

  public void addProject(final GuiIfcProject project) {
    this.projetcs.add(project);
  }

  public String getType() {
    return type;
  }


  public List<Object> getChildren() {

    final List<Object> children = new ArrayList<>();
    
    children.addAll(projetcs);

    return children;
  }
}
